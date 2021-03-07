package GamerHUB.Shared.util;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UserLog {
    public static void main( String[] args ) {
        String contenido = "";
        String linea = "";
        try {
            File file = new File("../../log.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                contenido = contenido + "\n" + linea;
            }
            br.close();

            DataInputStream dis = new DataInputStream(System.in);

            String usuario = dis.readUTF();
            LocalDateTime Localtime = LocalDateTime.now();
            String tiempo = Localtime.toString();


            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido + "\n" + "Usuario " + usuario + " ha iniciado sesion a las " + tiempo);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hecho.");
    }
}
