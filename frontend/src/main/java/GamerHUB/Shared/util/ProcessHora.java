package GamerHUB.Shared.util;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;

public class ProcessHora {

    public ProcessHora() {
    }

    public LocalTime procesoHora() {
        String hora = "";
        if(OsUtil.isWindows()){
            try{
            ProcessBuilder pb = new ProcessBuilder("CMD","/C", "echo %time%");
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
            }}
            catch(IOException e) {
                e.printStackTrace();
            }
        }else if (OsUtil.isUnix()){
            try{
            ProcessBuilder pb = new ProcessBuilder("date '+%H:%M:%S'");
            Process p = pb.start();
            try {
                InputStream is = p.getInputStream();
                int c;
                while ((c = is.read()) != -1) {
                    hora = hora + ((char) c);
                }
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }}
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        return LocalTime.parse(hora);
    }










}
