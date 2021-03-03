package GamerHUB.Shared.view;

import GamerHUB.GestionEventos.repository.ListaEvento;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.GestionUsuarios.ui.VentanaAdminVista;
import GamerHUB.Shared.controllers.VistaHomeControlador;
import GamerHUB.Shared.exception.CustomException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VentanaHomeVista {

    private SplitPane pane;
    private Stage stageppal;
    private ListaUsuario listaUsuario;
    private UsuarioDTO user;

    public VentanaHomeVista(Stage stageppal, UsuarioDTO user, ListaUsuario listaUsuario) {
        this.stageppal = stageppal;
        this.user = user;
        this.listaUsuario = listaUsuario;
    }

    /**
     * @throws CustomException
     * @throws IOException
     */
    public void LaunchHomeView() throws CustomException, IOException {
        URL url = new File("src/main/java/GamerHUB/Shared/view/VistaHome.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane home = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        Scene scene = new Scene(home, 800, 525);
        dialogStage.setScene(scene);
        pane = (SplitPane) home.getChildren().get(0);

        loadHomeView1(dialogStage);
        loadHomeView2(dialogStage, null);

        pane.setDividerPositions(0.32);

        VistaHomeControlador controladorHome = loader.getController();
        controladorHome.setVista(this, dialogStage, pane);
        controladorHome.setUsuario(user);
        controladorHome.setlistaUsuarios(listaUsuario);
        dialogStage.setTitle("Bienvenido " + user.getNombre() + "!");

        dialogStage.show();

    }

    /**
     * @throws IOException
     */
    public void loadHomeView1(Stage dialog) throws IOException {
        URL url = new File("src/main/java/GamerHUB/Shared/view/VistaHome1.fxml").toURI().toURL();
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(url);
        AnchorPane anchorPane = loader1.load();
        pane.getItems().set(0, anchorPane);

        VistaHomeControlador controladorHome = loader1.getController();
        controladorHome.setVista(this, dialog, pane);
        controladorHome.setlistaUsuarios(listaUsuario);
        controladorHome.setUsuario(user);
        controladorHome.setUserNameLabel();

        pane.setDividerPositions(0.32);
    }

    /**
     * @throws IOException
     */
    public void loadHomeView2(Stage dialog, ListaEvento listaEvento) throws IOException {
        URL url = new File("src/main/java/GamerHUB/Shared/view/VistaHome2.fxml").toURI().toURL();
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(url);
        AnchorPane anchorPane1 = loader2.load();
        pane.getItems().set(1, anchorPane1);
        VistaHomeControlador controladorHome = loader2.getController();
        controladorHome.setVista(this, dialog, pane);
        controladorHome.setUsuario(user);
        controladorHome.setlistaUsuarios(listaUsuario);
        controladorHome.setEventos(listaEvento);
        controladorHome.setImagenLupa();
        controladorHome.iniciar_Reloj();
        controladorHome.llenarTablaEventos();

        pane.setDividerPositions(0.32);
    }

    /**
     *
     * @throws IOException
     */
    public void LaunchVistaAdmin() throws IOException {
        VentanaAdminVista ventanaAdminVista = new VentanaAdminVista();
        ventanaAdminVista.LaunchVistaAdmin(stageppal);
    }


    public Stage getStageppal() {
        return stageppal;
    }

    public UsuarioDTO getUser() {
        return user;
    }
}
