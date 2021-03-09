package com.Equipo3.Backend.Shared.Infraestructura.Socket;

import com.Equipo3.Backend.Chat.Aplicacion.Service.ChatService;
import com.Equipo3.Backend.Peticion.Aplicacion.PeticionService;
import com.Equipo3.Backend.Shared.Aplicacion.Dto;
import com.Equipo3.Backend.Shared.Dominio.Socket.SocketServer;
import com.Equipo3.Backend.Shared.Infraestructura.ProductorConsumidor.ColaPeticiones;
import com.Equipo3.Backend.Shared.Infraestructura.ProductorConsumidor.ConsumidorPeticiones;
import com.Equipo3.Backend.Usuario.Aplicacion.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

@Component
@Controller
public class MultiThreadedServerTcp implements SocketServer, Runnable{

    protected int          serverPort   = 5555;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;

    HashMap<Integer, SocketClientConnectionWorker> clientsConnections = new HashMap<>();

    @Autowired
    private UsuarioService US;

    @Autowired
    private PeticionService PS;

    @Autowired
    private ChatService CS;

    private static ColaPeticiones colap = new ColaPeticiones();
    private ConsumidorPeticiones consumidorPeticiones = new ConsumidorPeticiones(colap,PS);

    public MultiThreadedServerTcp() {
    }

    public MultiThreadedServerTcp(Integer port){
        this.serverPort = port;
    }

    public void run(){
        if(!consumidorPeticiones.isAlive()){
            consumidorPeticiones = new ConsumidorPeticiones(colap,PS);
            consumidorPeticiones.start();
        }
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        while(! isStopped()){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }

            Integer clientId = clientsConnections.size()+1;
            clientsConnections.put(clientId,new SocketClientConnectionWorker(clientSocket, "ClienteID: " + clientId, US, colap, CS));

            new Thread(clientsConnections.get(clientId)).start();

            System.out.println("SockerServer. New connection received. ClienteID:" + clientId);
        }

        System.out.println("Server Stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
            System.out.println("Server-Socket Stopped") ;
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
            System.out.println("Server-Socket Started on " + this.serverSocket.toString()) ;

        } catch (IOException e) {
            throw new RuntimeException("Cannot open port " + this.serverPort, e);
        }
    }

    @Override
    public void Send(Integer clientId,String texto) {
        if (!clientsConnections.containsKey(clientId)) {
            System.out.println("SocketServer. El clienteID:" + clientId + " no existe!!");
            return;
        }

        SocketClientConnectionWorker client = clientsConnections.get(clientId);

        client.Send(texto);
    }

    @Override
    public void Send(Integer clientId, Dto object) {
        if (!clientsConnections.containsKey(clientId)) {
            System.out.println("SocketServer. El clienteID:" + clientId + " no existe!!");
            return;
        }

        SocketClientConnectionWorker client = clientsConnections.get(clientId);

        //Deserailizar object to String....
        String deserializedText = object.toString();  //TODO: Esto hay que cambiarlo...
        client.Send(deserializedText);
    }
}