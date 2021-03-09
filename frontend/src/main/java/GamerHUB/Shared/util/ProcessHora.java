package GamerHUB.Shared.util;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;

/**
 *
 */
public class ProcessHora {

    public ProcessHora() {
    }

    /**
     *
     * @return
     */
    public LocalTime procesoHora() {
        String hora = "";
        if (OsUtil.isWindows()) {
            try {
                ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "echo %time%");
                Process p = pb.start();
                try {
                    InputStream is = p.getInputStream();
                    int c;
                    int n = 0;
                    while ((c = is.read()) != -1 && n < 8) {
                        n++;
                        hora = hora + ((char) c);
                    }
                    if(hora.charAt(0) == ' '){
                        String horaarreglada = "0" + hora.charAt(1) + hora.charAt(2) + hora.charAt(3) + hora.charAt(4) + hora.charAt(5) + hora.charAt(6) + hora.charAt(7);
                        hora = horaarreglada;
                    }
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (OsUtil.isUnix()) {
            try {
                ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", "date '+%H:%M:%S'");
                Process p = pb.start();
                try {
                    InputStream is = p.getInputStream();
                    int c;
                    int n = 0;
                    while ((c = is.read()) != -1 && n < 8) {
                        n++;
                        hora = hora + ((char) c);
                    }
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return LocalTime.parse(hora);
    }


}
