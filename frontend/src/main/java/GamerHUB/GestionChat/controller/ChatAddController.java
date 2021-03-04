package GamerHUB.GestionChat.controller;

import GamerHUB.GestionChat.model.dto.CanalDTO;
import GamerHUB.GestionChat.repository.ListaChat;
import GamerHUB.GestionChat.ui.VentanaAddChatVista;
import GamerHUB.Shared.util.ActionDialogs;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChatAddController {


    @FXML
    private TextField campoNombreCanal;

    @FXML
    private Button btnGuardar;

     private VentanaAddChatVista vista;

     private Stage stage;

     private int puerto;

    private ListaChat listaChat =new ListaChat();

    public ChatAddController(int puerto){
        this.puerto = puerto;
    }


    public ListaChat getListaChat() {
        return listaChat;
    }

    public void setListaChat(ListaChat listaChat) {
        this.listaChat = listaChat;
    }

    public void setVista(VentanaAddChatVista vista, Stage stage){
        this.vista =vista;
        this.stage =stage;
    }

    public int getPuerto() {
        return puerto;
    }

    @FXML
    public void addChat(){
        if(isInputValid()){

            String campo = campoNombreCanal.getText();
            CanalDTO chatDTO = new CanalDTO(campo, getPuerto(), null);

            listaChat.getCanales().add(chatDTO);

            ActionDialogs.info("Se ha registrado un chat.", "Se creó el chat "+campo+ ".\n" +
                    chatDTO.toString());
            stage.close();
        } else {

        }

    }

    public boolean isInputValid(){

        String errorMsg="";

        if(campoNombreCanal.getText().isEmpty() || campoNombreCanal.getText().equals(null)){
            errorMsg+="Introduce un nombre para el nuevo canal";
        }

        if(errorMsg.isEmpty()){
            return true;
        } else{
            ActionDialogs.error("Error en el campo.", errorMsg);
            return false;
        }


    }




}
