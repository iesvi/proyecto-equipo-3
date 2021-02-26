package GamerHUB;

import GamerHUB.Shared.view.VentanaRootVista;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controlador principal de la aplicación. Se encargará de lanzar los métodos de renderizado de las vistas
 * y las listas en memoria.
 */
public class MainApp extends Application {

    private VentanaRootVista ventanaRoot;

    private AnchorPane home;
    //private AnchorPane perfil;
   // private AnchorPane evento;
    /**
     *
     */



    /**
     *
     */





    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        ventanaRoot = new VentanaRootVista();
        ventanaRoot.inicioStage(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }


    public void LaunchVistaAdmin() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/VistaAdmin.fxml"));
        home = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        Scene scene = new Scene(home, 800, 525);
        dialogStage = new Stage();
        dialogStage.setScene(scene);

    }


}
