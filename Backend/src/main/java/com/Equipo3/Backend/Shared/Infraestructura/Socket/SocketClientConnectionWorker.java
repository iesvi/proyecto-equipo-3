package com.Equipo3.Backend.Shared.Infraestructura.Socket;

import com.Equipo3.Backend.Shared.util.JsonMapper;
import com.Equipo3.Backend.Usuario.Aplicacion.Service.UsuarioService;
import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

/**

 */
public class SocketClientConnectionWorker implements Runnable {

    protected Socket clientSocket = null;
    protected String clientID = null;

    private InputStream entrada;
    private OutputStream salida;

    private UsuarioService US;

    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;
    private DataInputStream DataEntrada;
    private DataOutputStream DataSalida;
    private String data;

    public SocketClientConnectionWorker(Socket clientSocket, String clientID, UsuarioService US) {
        this.clientSocket = clientSocket;
        this.clientID = clientID;
        this.US = US;

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
                        ArrayList<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
                        lista = US.Consultar_Usuarios();
//                       lista.add(new UsuarioDTO(2,"Manuel","123456","hola@hotmail.com",new Date(),123456789,"admin"));
                        DataSalida = new DataOutputStream(salida);
                        data = JsonMapper.fromJavaToJson(lista);
                        DataSalida.writeUTF(data);
                        DataSalida.flush();
                        break;
                    case "add":
                            DataEntrada = new DataInputStream(entrada);
                            data = DataEntrada.readUTF();
                            Object o = JsonMapper.fromJsonToJava(data,UsuarioDTO.class);
                            UsuarioDTO user = (UsuarioDTO) o;
                            UsuarioVO userVO = US.Registro_De_Usuario(user);
                        break;
                    case "ok":
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

