package GamerHUB.Shared.controllers;

import GamerHUB.GestionEventos.controller.EventoController;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.MainApp;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

/**
 *Controlador de la
 */
public class VistaHomeControlador {

    private MainApp mainApp;
    private Stage dialogStage;
    private UsuarioDTO userLogeado;

    @FXML
    private TableView amigos, canales, eventos;

    /**
     *
     */
    @FXML
    private TableColumn<UsuarioDTO, String> colAmigo;
    /**
     *
     */
    @FXML
    private TableColumn<UsuarioDTO, String> colCanal;
    /**
     *
     */
    @FXML
    private TableColumn<UsuarioDTO, String> colEvento;

    /**
     *
     */
    @FXML
    private Label userName;

    /**
     *
     */
    @FXML
    private ImageView fotoUser, fotoBusqueda;

    /**
     *
     */
    @FXML
    private TextField searchBar, msgBar;

    /**
     *
     */
    @FXML
    public Button btnConfig, btnAyuda, btnSubirArchivo, btnVerArchivos, btnNuevoCanal, btnNuevoEvento, btnConfigEventos;

    /**
     *
     */
    @FXML
    public MenuItem btnSalir;

    @FXML private Label time;

    private int minute;
    private int hour;
    private int second;

    @FXML
    public void initialize() {

    }

    /**
     * Método que muestra la hora actual completa (hh:mm:ss) en tiempo real.
     */
    public void iniciar_Reloj(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            time.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

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


    /**
     *Método para salir de la aplicación (Log-out)
     * @throws IOException
     */
    @FXML
    public void Logout() throws IOException {
        mainApp.Init();
        mainApp.LaunchInicio();
        dialogStage.close();
    }

    /**
     *Método que carga la vista del perfil del usuario.
     * @param mouseEvent
     * @throws IOException
     */
    @FXML
    public void LaunchPerfil(MouseEvent mouseEvent) throws IOException {
        mainApp.LaunchVistaPerfil(userLogeado);
    }

    /**
     *Método para cargar la vista del formulario y tablas de los eventos.
     * @throws IOException
     */
    public void LoadEventoView() throws IOException {
        getMainApp().loadEventoView(dialogStage);
    }
//    @FXML ¡No funciona!
//    public void AbrirdialogAñadirEvento() throws IOException{
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(MainApp.class.getResource("/vistas/gestioneventos/VistaAddEventoDialog.fxml"));
//        AnchorPane Aevent = (AnchorPane) loader.load();
//
//        Stage newevent = new Stage();
//        newevent.setTitle("Añadir Evento");
//        newevent.initModality(Modality.WINDOW_MODAL);
//        newevent.initOwner(dialogStage);
//        Scene scene = new Scene(Aevent);
//        newevent.setScene(scene);
//
//        EventoController contevnt = loader.getController();
//        contevnt.setdialogStage(dialogStage);
//        contevnt.setmainApp(mainApp);
//
//        dialogStage.showAndWait();
//    }
}
