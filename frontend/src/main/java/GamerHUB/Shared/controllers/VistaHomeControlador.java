package GamerHUB.Shared.controllers;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.text.TableView;
import javax.swing.text.html.ImageView;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 *
 */
public class VistaHomeControlador {

    private MainApp mainApp;
    private UsuarioDTO usuarioDTO;
    private Stage dialogStage;

    private UsuarioDTO userLogeado;

    @FXML
    private TableView amigos, canales, eventos;
    @FXML
    private Label userName;

    @FXML
    private ImageView fotoUser, fotoBusqueda;

    @FXML
    private TextField searchBar, msgBar;

    @FXML
    public Button btnConfig, btnAyuda, btnSubirArchivo, btnVerArchivos, btnNuevoCanal, btnNuevoEvento;

    public VistaHomeControlador() {
        userLogeado = mainApp.getUsuarioLogeado();
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public VistaHomeControlador(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public MainApp getMainApp() {
        return mainApp;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    ////

    public void llenarTablaAmigos(){

    }

    public void llenarTablaCanales(){

    }

    public void llenarTablaEventos(){

    }



    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void launchPerfil(MouseEvent mouseEvent) throws IOException {
        mainApp.LaunchVistaPerfil(userLogeado);
    }
}
