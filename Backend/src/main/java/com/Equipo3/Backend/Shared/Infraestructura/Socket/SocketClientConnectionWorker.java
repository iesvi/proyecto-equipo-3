package com.Equipo3.Backend.Shared.Infraestructura.Socket;

import com.Equipo3.Backend.Usuario.Aplicacion.Service.UsuarioService;
import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**

 */
public class SocketClientConnectionWorker implements Runnable{

    protected Socket clientSocket = null;
    protected String clientID = null;

    private InputStream entrada;
    private OutputStream salida;
    @Autowired
    private UsuarioService US;

    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;
    private ObjectInputStream ObjectEntrada;
    private ObjectOutputStream ObjectSalida;

    public SocketClientConnectionWorker(Socket clientSocket, String clientID) {
        this.clientSocket = clientSocket;
        this.clientID = clientID;
        this.US = new UsuarioService();

        try {
            this.clientSocket.setReceiveBufferSize(1024);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            entrada  = clientSocket.getInputStream();
            salida = clientSocket.getOutputStream();

            flujoEntrada = new DataInputStream(entrada);
            flujoSalida = new DataOutputStream(salida);

            System.out.println(clientID + ". Waiting....");

            byte[] buffer = new byte[1024];

            while(true) {

                String n = flujoEntrada.readUTF();
                switch (n){
                    case "usuarios":
                        ArrayList<UsuarioDTO> lista = US.Consultar_Usuarios();
                        ObjectSalida.writeObject(lista);
                        ObjectSalida.flush();
                        break;
                    case "add":
                        try {
                            ObjectEntrada = new ObjectInputStream(entrada);
                            Object o = ObjectEntrada.readObject();
                            UsuarioDTO user = (UsuarioDTO) o;
                            US.Registro_De_Usuario(user);
                        }catch(ClassNotFoundException er){
                            er.printStackTrace();
                        }
                        break;
                }


            }

        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }

    public void Send(String text) {
        try{

            salida = clientSocket.getOutputStream();

            flujoSalida = new DataOutputStream(salida);

            flujoSalida.flush();
            flujoSalida.writeUTF(text);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void Recibir() {
        try {

            entrada = clientSocket.getInputStream();

            flujoEntrada = new DataInputStream(entrada);

            String mensaje = flujoEntrada.readUTF();

            System.out.println(this.clientID + ". Valor recibido: " + mensaje);

        }catch (IOException e){
            e.printStackTrace();
        }



    }

}

