package com.Equipo3.Backend.Shared.Infraestructura.Socket;

import com.Equipo3.Backend.Shared.Aplicacion.Dto;
import com.Equipo3.Backend.Shared.Dominio.Socket.SocketServer;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTCP implements SocketServer {


    private final int PORT = 12345;
    private ServerSocket serverSocket = new ServerSocket(PORT);

    private final Socket socket = new Socket();

    public SocketServerTCP() throws IOException {
        //Inicialización del Socket ==> Configuración, etc...
        int aaa = 3;
    }

    @Override
    public void Send(Dto object) {
        throw new NotImplementedException();
    }
}