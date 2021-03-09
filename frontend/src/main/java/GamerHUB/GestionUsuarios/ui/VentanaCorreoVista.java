package GamerHUB.GestionUsuarios.ui;

import GamerHUB.GestionPeticiones.controller.PeticionController;
import GamerHUB.GestionUsuarios.controller.CorreoController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class VentanaCorreoVista {

    private Stage stage;


    public VentanaCorreoVista(Stage stage){
            this.stage = stage;
    }


    public void LaunchVistaCorreo()  throws IOException {

        URL url = new File("src/main/java/GamerHUB/GestionUsuarios/ui/VistaCorreo.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);

        AnchorPane peticion = (AnchorPane) loader.load();

        Scene scene = new Scene(peticion, 477, 369);
        Stage dialogStage = new Stage();
        dialogStage.setScene(scene);
        dialogStage.setTitle("Correos");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        CorreoController correoController = loader.getController();
        correoController.setVentanaCorreoVista(this, dialogStage);
        try {
            correoController.mostrarCorreos();
        }catch(MessagingException e){
            e.printStackTrace();
        }

        dialogStage.show();




    }




}
