package GamerHUB.Shared.controllers;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *
 */
public class VistaHomeControlador {

    private MainApp mainApp;
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
    public Button btnConfig, btnAyuda, btnSubirArchivo, btnVerArchivos, btnNuevoCanal, btnNuevoEvento, btnConfigEventos;

    @FXML
    public MenuItem btnSalir;



    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public UsuarioDTO getUsuarioLogeado() {
        return userLogeado;
    }
    public void setUsuario() {
        this.userLogeado = mainApp.getUsuarioLogeado();
    }

    public MainApp getMainApp() {
        return mainApp;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public VistaHomeControlador() {
      //

    }
    ////
    @FXML
    public void initialize(){
       // userName.setText(this.getUsuarioLogeado().getNombre().toString());

    }
    public void setImagenLupa(){
        URL url = getClass().getResource("/images/search.png");
        File file = new File(url.getPath());
        Image image = new Image(file.toURI().toString());
        fotoBusqueda.setImage(image);
    }
    public void llenarTablaAmigos(){

    }

    public void llenarTablaCanales(){

    }

    public void llenarTablaEventos(){

    }


    @FXML
    public void Logout() throws IOException {
        mainApp.Init();
        mainApp.LaunchInicio();
        dialogStage.close();
    }

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    @FXML
    public void LaunchPerfil(MouseEvent mouseEvent) throws IOException {
        mainApp.LaunchVistaPerfil(userLogeado);
    }

    public void LoadEventoView() throws IOException {
        getMainApp().loadEventoView();
    }
}
