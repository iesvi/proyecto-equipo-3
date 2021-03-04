package GamerHUB.GestionUsuarios.ui;

import GamerHUB.GestionUsuarios.controller.VistaRegistroControlador;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
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
    private ListaUsuario listaUsuario;

    public VentanaSignUpVista(Stage stageppal, ListaUsuario listaUsuario) {
        this.stageppal = stageppal;
        this.listaUsuario = listaUsuario;
    }

    /**
     * @throws IOException
     */
    public void LaunchSignUpView() throws IOException {
        URL url = new File("src/main/java/GamerHUB/GestionUsuarios/ui/VistaRegistro.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane signup = (AnchorPane) loader.load();

        Scene scene = new Scene(signup, 400, 500);
        Stage dialogStage = new Stage();
        dialogStage.setScene(scene);
        dialogStage.setTitle("Únete a gamerhub!");
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        VistaRegistroControlador controladorRegistro = loader.getController();
        controladorRegistro.setVista(this, dialogStage, listaUsuario);

        dialogStage.show();


    }
}
