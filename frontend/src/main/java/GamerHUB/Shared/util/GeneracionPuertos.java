package GamerHUB.Shared.util;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GeneracionPuertos {


    public static int generarPuerto() throws IOException{
        boolean correcto = false;
        int nGenerado = 0;
        while(!correcto) {
            nGenerado = (int) (Math.random() * 65500);
            correcto = isPortInUse("localhost", nGenerado);
        }
        return nGenerado;
    }




    private static boolean isPortInUse(String host, int port) throws IOException {
        boolean result = false;
        ServerSocket socket;

        try {
            Socket clientSocket = new Socket("192.168.1.37",port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            System.out.println("Puerto " + port + " abierto");
            out.close();
            clientSocket.close();
            result = true;
        }
        catch(SocketException e) {
            e.printStackTrace();
        }catch(IOException er){
            System.out.println("Puerto " + port + " cerrado");
        }

        return result;
    }

}
