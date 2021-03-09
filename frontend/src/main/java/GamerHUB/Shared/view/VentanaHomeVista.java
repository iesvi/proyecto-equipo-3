package GamerHUB.Shared.view;

import GamerHUB.GestionChat.repository.ListaChat;
import GamerHUB.GestionEventos.repository.ListaEvento;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.GestionUsuarios.ui.VentanaAdminVista;
import GamerHUB.Shared.conexion.ClientSocket;
import GamerHUB.Shared.controllers.VistaHomeControlador;
import GamerHUB.Shared.exception.CustomException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VentanaHomeVista {

    private SplitPane pane;
    private Stage stageppal;
    private ListaUsuario listaUsuario;
    private UsuarioDTO user;
    private ClientSocket CS;
    private ListaChat LC;
    private VistaHomeControlador controladorHome;
    private VistaHomeControlador controladorHomeview1;
    private VistaHomeControlador controladorHomeview2;

    public VentanaHomeVista(Stage stageppal, UsuarioDTO user, ListaUsuario listaUsuario, ClientSocket CS, ListaChat LC) {
        this.stageppal = stageppal;
        this.user = user;
        this.listaUsuario = listaUsuario;
        this.CS = CS;
        this.LC = LC;
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
        dialogStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override public void handle(WindowEvent event) {
                if(CS.comprobarConexion()){
                    CS.desconectar();
                }
                dialogStage.close();
            }
        });
        controladorHome = loader.getController();
        controladorHome.setVista(this, dialogStage, pane, CS, LC);
        controladorHome.setUsuario(user);
        controladorHome.setlistaUsuarios(listaUsuario);
        dialogStage.setTitle("Bienvenido " + user.getNombre() + "!");

        loadHomeView1(dialogStage);
        loadHomeView2(dialogStage, null);
        controladorHome.setControladores(controladorHome, controladorHomeview1, controladorHomeview2);

        pane.setDividerPositions(0.32);


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

        controladorHomeview1 = loader1.getController();
        controladorHomeview1.setVista(this, dialog, pane, CS, LC);
        controladorHomeview1.setUsuario(user);
        controladorHomeview1.setlistaUsuarios(listaUsuario);
        controladorHomeview1.setControladores(controladorHome, controladorHomeview1, controladorHomeview2);
        controladorHomeview1.setUserNameLabel();
        controladorHomeview1.setImagenActualizar();
        controladorHomeview1.llenarTablaCanales();
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

        controladorHomeview2 = loader2.getController();
        controladorHomeview2.setVista(this, dialog, pane, CS, LC);
        controladorHomeview2.setUsuario(user);
        controladorHomeview2.setlistaUsuarios(listaUsuario);
        controladorHomeview1.setControladorHomeView2(controladorHomeview2);
        controladorHomeview2.setControladores(controladorHome, controladorHomeview1, controladorHomeview2);
        controladorHomeview2.setEventos(listaEvento);
        controladorHomeview2.setImagenLupa();
        controladorHomeview2.iniciar_Reloj();
        controladorHomeview2.llenarTablaEventos();

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

    public VistaHomeControlador getcontrollerHome(){
        return controladorHome;
    }

    public VistaHomeControlador getcontrollerHomeview1(){
        return controladorHomeview1;
    }

    public VistaHomeControlador getcontrollerHomeview2(){
        return controladorHomeview2;
    }

    public Stage getStageppal() {
        return stageppal;
    }

    public UsuarioDTO getUser() {
        return user;
    }
}
