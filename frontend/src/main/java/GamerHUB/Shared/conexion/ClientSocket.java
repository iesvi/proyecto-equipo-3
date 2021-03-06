package GamerHUB.Shared.conexion;

import java.io.*;
import java.net.Socket;

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
        try {
            this.socket = new Socket(Host, Puerto);
            socket.close();
        }catch(IOException er){

        }
        if (socket == null){
            return false;
        }else{
            return true;
        }
    }


    /**
     *
     * @param o
     * @param n
     * @throws IOException
     */
    public void sendO(Object o, String n) throws IOException{
        this.socket = new Socket(Host, Puerto);
        DataOutputStream Dos = new DataOutputStream(socket.getOutputStream());
        Dos.writeUTF(n);
        ObjectOutputStream OOs = new ObjectOutputStream(socket.getOutputStream());
        OOs.writeObject(o);
        socket.close();
    }

    public void send(String n) throws IOException{
        this.socket = new Socket(Host, Puerto);
        DataOutputStream Dos = new DataOutputStream(socket.getOutputStream());
        Dos.writeUTF(n);
        socket.close();
    }


    /**
     *
     * @param o
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object receive() throws IOException, ClassNotFoundException{
        this.socket = new Socket(Host, Puerto);
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object o = objectInputStream.readObject();
        socket.close();
         return o;

    }


}
