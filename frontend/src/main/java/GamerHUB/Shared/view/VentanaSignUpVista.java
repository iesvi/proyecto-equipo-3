package GamerHUB.Shared.view;

import GamerHUB.GestionUsuarios.controller.VistaRegistroControlador;
import GamerHUB.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaSignUpVista {

    private Stage stageppal;

    public VentanaSignUpVista(Stage stageppal) {
        this.stageppal = stageppal;
    }

    /**
     * @throws IOException
     */
    public void LaunchSignUpView() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("Shared/view/VistaRegistro.fxml"));
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
