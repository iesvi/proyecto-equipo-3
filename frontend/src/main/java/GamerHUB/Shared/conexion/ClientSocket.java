package GamerHUB.Shared.conexion;

import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.Shared.util.JsonMapper;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 */
public class ClientSocket {


    private Socket socket;
    private String Host = "localhost";
    private int Puerto = 5555;


    public ClientSocket() {

    }

    public boolean comprobarConexion(){
        if (socket == null){
            return false;
        }else{
            return true;
        }
    }


    /**
     *
     * @param n
     * @throws IOException
     */
    public void sendO(String Json, String n) throws IOException{
        DataOutputStream Dos = new DataOutputStream(socket.getOutputStream());
        Dos.writeUTF(n);
        Dos.flush();
        DataOutputStream DOs = new DataOutputStream(socket.getOutputStream());
        DOs.writeUTF(Json);
        DOs.flush();
    }

    public void send(String n) throws IOException{
        DataOutputStream Dos = new DataOutputStream(socket.getOutputStream());
        Dos.writeUTF(n);
        Dos.flush();
    }


    /**
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object receive() throws IOException {
        Object o = null;
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String json = dataInputStream.readUTF();
            o = JsonMapper.fromJsonToJava(json, ArrayList.class);
        return o;
    }

    public void conectar() {
        try {
            this.socket = new Socket(Host, Puerto);
        } catch (IOException er) {
            System.out.println("No hay conexion.");
        }
    }
    public void desconectar() {
        try {
            socket.close();
        } catch (IOException er) {
                System.out.println("No hay conexion.");
        }
        }


}
