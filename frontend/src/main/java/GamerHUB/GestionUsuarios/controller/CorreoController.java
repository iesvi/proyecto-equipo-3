package GamerHUB.GestionUsuarios.controller;

import java.util.ArrayList;

import GamerHUB.GestionServidorArchivos.ClientePOP3;
import GamerHUB.GestionUsuarios.ui.VentanaCorreoVista;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.mail.MessagingException;

/**
 * Controlador que llama al ClientePOP3 que permite
 */
public class CorreoController {


    @FXML
    private TextArea textAreacorreo;
    private VentanaCorreoVista ventanaCorreoVista;
    private Stage stage;


    public CorreoController(){

    }

    public void setVentanaCorreoVista(VentanaCorreoVista ventanaCorreoVista, Stage stage){
        this.ventanaCorreoVista  =ventanaCorreoVista;
        this.stage = stage;

    }


    public void mostrarCorreos() throws MessagingException {

        ClientePOP3 clientePOP3 = new ClientePOP3();
        ArrayList<String> correos = clientePOP3.retrieveEmails();

        if(!correos.isEmpty()){
            for(String correo: correos){
                textAreacorreo.appendText(correo);
            }
        }


    }




}
