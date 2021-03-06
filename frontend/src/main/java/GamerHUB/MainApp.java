package GamerHUB;

import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.Shared.conexion.ClientSocket;
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


    /**
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        ListaUsuario listaUsuario = new ListaUsuario();
        ClientSocket CS = new ClientSocket();
        CS.conectar();
        ventanaRoot = new VentanaRootVista();
        ventanaRoot.inicioStage(primaryStage, listaUsuario, CS);

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
