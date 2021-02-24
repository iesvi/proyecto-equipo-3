package GamerHUB.Shared.view;

import GamerHUB.MainApp;
import GamerHUB.Shared.controllers.VistaInicioControlador;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaInicioVista {

    private Stage stageppal;
    private BorderPane rootLayout;

    public VentanaInicioVista(Stage stageppal, BorderPane rootLayout) {
        this.stageppal = stageppal;
        this.rootLayout = rootLayout;
    }

    /**
     * Vista de acceso o "logeo" a la aplicación. Se solicitan los datos nombre de usuario
     * y contraseña al usuario para poder acceder al resto de la aplicación, si esta registrado,
     * o en su defecto registrarse antes.
     *
     * @throws IOException
     */
    public void LaunchInicio() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("Shared/view/VistaInicio.fxml"));
        AnchorPane inicio = (AnchorPane) loader.load();

        rootLayout.setCenter(inicio);

        //inicio.setBackground();
        VistaInicioControlador controladorInicio = loader.getController();
        controladorInicio.setVista(this, stageppal);

    }


}
