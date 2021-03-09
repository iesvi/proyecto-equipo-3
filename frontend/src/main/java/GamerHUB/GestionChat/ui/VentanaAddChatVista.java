package GamerHUB.GestionChat.ui;

import GamerHUB.GestionChat.controller.ChatAddController;
import GamerHUB.GestionChat.model.dto.CanalDTO;
import GamerHUB.GestionChat.repository.ListaChat;
import GamerHUB.GestionEventos.controller.EventoAddController;
import GamerHUB.GestionEventos.repository.ListaEvento;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.Shared.conexion.ClientSocket;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *
 */
public class VentanaAddChatVista {

    private Stage stageppal;
    private CanalDTO canalDTO;
    private ListaChat listaChat;
    private ClientSocket CS;



    public VentanaAddChatVista(Stage stageppal){
        this.stageppal =stageppal;
    }

    public VentanaAddChatVista(Stage stageppal, ListaChat listaChat, ClientSocket CS){
        this.stageppal = stageppal;
        this.listaChat = listaChat;
        this.CS = CS;
    }


    /**
     *
     * @throws IOException
     */
    public void LaunchAddCanal() throws IOException {
        URL url = new File("src/main/java/GamerHUB/GestionChat/ui/VistaAddChat.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane addCanal = (AnchorPane) loader.load();

        Scene scene = new Scene(addCanal, 281, 253);
        Stage dialogStage = new Stage();
        dialogStage.setScene(scene);
        dialogStage.setTitle("Nuevo canal");
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        ChatAddController chataddController = loader.getController();

        chataddController.setListaChat(listaChat);
        chataddController.setVista(this, dialogStage, CS);

        dialogStage.show();
    }

}
