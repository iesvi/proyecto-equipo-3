package GamerHUB.Shared.conexion;

import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.Shared.util.ActionDialogs;

import javax.net.ssl.SSLSocket;
import java.io.*;
import java.net.Socket;

public class LoginThread{


    private SSLSocket socket;
    private BufferedReader input;
    private UsuarioVO usuarioLogeado;


    /**
     *
     * @param socket
     * @throws IOException
     */
    public LoginThread(SSLSocket socket) throws IOException{

        this.socket = socket;
        this.input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
    }



    /**
     *
     * @param user
     * @param pass
     * @throws IOException
     */
    public  boolean checkServerCredentials(String user, String pass) throws IOException, ClassNotFoundException{


        boolean accepted = false;


        UsuarioVO usuario= new UsuarioVO(user, pass);

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(usuario);


        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);


        while(!accepted){

            usuarioLogeado = (UsuarioVO)  objectInputStream.readObject();

            if(usuarioLogeado!=null){
                ActionDialogs.info("Conexión establecida.", "Bienvenido a Gamerhub "+usuario.getNombre()+"!");

                return true;

            }   else {
                ActionDialogs.info("Conexión rechazada", "No se puedo establecer la conexión.");
                return false;


            }

        }

return true;
    }

    public UsuarioVO getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(UsuarioVO usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
}
