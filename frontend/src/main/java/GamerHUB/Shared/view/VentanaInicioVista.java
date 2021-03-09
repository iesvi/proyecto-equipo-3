package GamerHUB.Shared.view;

import GamerHUB.GestionChat.repository.ListaChat;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.Shared.conexion.ClientSocket;
import GamerHUB.Shared.controllers.VistaInicioControlador;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *Clase que muestra en la ventana raiz la vista inicio, que permite hacer login en la aplicación, o bien
 * lleva a la de registro.
 */
public class VentanaInicioVista {

    private Stage stageppal;
    private BorderPane rootLayout;
    private ListaUsuario listaUsuario;
    private ClientSocket CS;
    private ListaChat LC;

    public VentanaInicioVista(Stage stageppal, BorderPane rootLayout, ListaUsuario listaUsuario, ClientSocket CS, ListaChat LC) {
        this.stageppal = stageppal;
        this.rootLayout = rootLayout;
        this.listaUsuario = listaUsuario;
        this.CS = CS;
        this.LC = LC;
    }

    /**
     * Vista de acceso o "logeo" a la aplicación. Se solicitan los datos nombre de usuario
     * y contraseña al usuario para poder acceder al resto de la aplicación, si esta registrado,
     * o en su defecto registrarse antes.
     *
     * @throws IOException
     */
    public void LaunchInicio() throws IOException {

        URL url = new File("src/main/java/GamerHUB/Shared/view/VistaInicio.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane inicio = (AnchorPane) loader.load();

        rootLayout.setCenter(inicio);
        stageppal.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (CS.comprobarConexion()) {
                    CS.desconectar();
                }
                stageppal.close();
            }
        });

        //inicio.setBackground();
        VistaInicioControlador controladorInicio = loader.getController();
        controladorInicio.setVista(this, stageppal, listaUsuario, CS, LC);
        controladorInicio.setListaUsuario();
        controladorInicio.setListaChat();

    }

    public Stage getStageppal() {
        return stageppal;
    }
}
