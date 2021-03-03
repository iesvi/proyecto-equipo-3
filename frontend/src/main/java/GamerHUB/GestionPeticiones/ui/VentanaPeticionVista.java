package GamerHUB.GestionPeticiones.ui;

import GamerHUB.GestionPeticiones.controller.PeticionController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 */
public class VentanaPeticionVista {


    private Stage stageppal;

    public VentanaPeticionVista(Stage stageppal){
            this.stageppal = stageppal;
    }

    /**
     *
     * @throws IOException
     */
    public void LaunchVistaPeticion() throws IOException {

        URL url = new File("src/main/java/GamerHUB/GestionPeticiones/ui/VistaPeticionDialog.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);

        AnchorPane peticion = (AnchorPane) loader.load();

        Scene scene = new Scene(peticion, 603, 417);
        Stage dialogStage = new Stage();
        dialogStage.setScene(scene);
        dialogStage.setTitle("Gracias por confiar en nosotros.");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        PeticionController peticionController = loader.getController();
        peticionController.setVentanaPeticionVista(this, dialogStage);

        dialogStage.show();

    }


}
