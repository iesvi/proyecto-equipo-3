package GamerHUB.GestionUsuarios.ui;

import GamerHUB.GestionChat.repository.ListaChat;
import GamerHUB.GestionUsuarios.controller.AdminController;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.Shared.conexion.ClientSocket;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VentanaGestionUser {

    private Stage stageppal;
    private ListaUsuario listaUsuario;
    private ClientSocket CS;
    private ListaChat LC;

    public VentanaGestionUser(Stage stageppal, ListaUsuario listaUsuario, ClientSocket CS, ListaChat LC) {
        this.stageppal = stageppal;
        this.listaUsuario = listaUsuario;
        this.CS = CS;
        this.LC = LC;
    }


    public void LaunchVistaGestionUsers(Stage dialogStage) throws IOException {

        URL url = new File("src/main/java/GamerHUB/GestionUsuarios/ui/VistaAdminUsers.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane anchorPane = (AnchorPane) loader.load();

        dialogStage = new Stage();
        AdminController adminController = loader.getController();
        Scene scene = new Scene(anchorPane, 591, 417);
        dialogStage.setScene(scene);
        //adminController.setVentanaAdminVista(this, dialogStage);
        dialogStage.close();

    }



}
