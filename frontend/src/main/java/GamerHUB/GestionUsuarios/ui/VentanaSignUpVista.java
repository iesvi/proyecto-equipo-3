package GamerHUB.GestionUsuarios.ui;

import GamerHUB.GestionUsuarios.controller.VistaRegistroControlador;
import GamerHUB.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VentanaSignUpVista {

    private Stage stageppal;

    public VentanaSignUpVista(Stage stageppal) {
        this.stageppal = stageppal;
    }

    /**
     * @throws IOException
     */
    public void LaunchSignUpView() throws IOException {
        URL url = new File("frontend/src/main/java/GamerHUB/Shared/view/VistaRegistro.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane signup = (AnchorPane) loader.load();

        Scene scene = new Scene(signup, 400, 500);
        Stage dialogStage = new Stage();
        dialogStage.setScene(scene);
        dialogStage.setTitle("Únete a gamerhub!");
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        VistaRegistroControlador controladorRegistro = loader.getController();
        controladorRegistro.setVista(this, dialogStage);

        dialogStage.show();


    }
}
