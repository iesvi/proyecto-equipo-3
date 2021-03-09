package GamerHUB.GestionUsuarios.ui;

import GamerHUB.GestionUsuarios.controller.AdminController;
import javafx.fxml.FXML;
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
public class VentanaAdminVista {


    private Stage stageppal;


    public VentanaAdminVista(Stage stageppal) {

        this.stageppal = stageppal;
    }

    /**
     * @param dialogStage
     * @throws IOException
     */
    @FXML
    public void LaunchVistaAdmin(Stage dialogStage) throws IOException {

        URL url = new File("src/main/java/GamerHUB/GestionUsuarios/ui/VistaAdmin.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane anchorPane = (AnchorPane) loader.load();

        dialogStage = new Stage();
        Scene scene = new Scene(anchorPane, 591, 417);
        dialogStage.setScene(scene);
        AdminController adminController = loader.getController();
        adminController.setVentanaAdminVista(this, dialogStage);
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        dialogStage.show();

    }


    public void LaunchVistaGestionChats(Stage dialogStage) {

    }

    public void LaunchVistaGestionEventos(Stage dialogStage) {

    }


}
