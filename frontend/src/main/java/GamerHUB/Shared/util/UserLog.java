package GamerHUB.Shared.util;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;

public class UserLog {
    public static void main(String[] args) {
        String contenido = "";
        String linea = "";
        try {
            File file = new File("frontend/src/main/resources/log.txt");
//            FileReader fr = new FileReader(file);
//            BufferedReader br = new BufferedReader(fr);
//
//            while ((linea = br.readLine()) != null) {
//
//                contenido = contenido + "\n" + linea;
//
//            }

            String usuario = String.valueOf(args[0]);
            LocalDate Localdate = LocalDate.now();
            String tiempo = Localdate.toString();

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("\n" + "Usuario " + usuario + " ha iniciado sesion a las ")

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
