package GamerHUB.Shared.view;

import GamerHUB.GestionChat.repository.ListaChat;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.Shared.conexion.ClientSocket;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *Clase que muestra la ventana principal (raiz) de la aplicacion.
 */
public class VentanaRootVista {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ListaUsuario listaUsuario;
    private ClientSocket CS;
    private ListaChat LC;


    public void inicioStage(Stage primaryStage, ListaUsuario listaUsuario, ClientSocket CS, ListaChat LC) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Welcome to GamerHub!");
        this.listaUsuario = listaUsuario;
        this.CS = CS;
        this.LC = LC;

        Init();

        VentanaInicioVista inicio = new VentanaInicioVista(primaryStage, rootLayout, listaUsuario, CS, LC);
        inicio.LaunchInicio();

    }


    /**
     * Método que inicializa el componente padre de la ventana de la interfaz.
     * El resto de vistas se mostrán anidadas dentro de esta, según las acciones
     * de los usuarios.
     *
     * @throws IOException
     */
    public void Init() throws IOException {
        URL url = new File("src/main/java/GamerHUB/Shared/view/RootLayout.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        rootLayout = (BorderPane) loader.load();
        Scene scene = new Scene(rootLayout, 350, 600);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (CS.comprobarConexion()) {
                    CS.desconectar();
                }
                primaryStage.close();
            }
        });
        primaryStage.show();

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
