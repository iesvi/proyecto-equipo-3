package GamerHUB.Shared.controllers;


import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.GestionEventos.ui.VentanaEventoVista;
import GamerHUB.Shared.view.VentanaHomeVista;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *Controlador de la
 */
public class VistaHomeControlador {

    private Stage dialogStage;
    private UsuarioDTO userLogeado;
    private VentanaHomeVista vista;
    private VentanaEventoVista vistaevento;
    private SplitPane pane;
    private ListaUsuario listaUsuario;


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

    @FXML
    private MenuBar menu;

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



    public VistaHomeControlador() {
        llenarTablaEventos();
        // addOpcionAdmin();
    }

    /**
     * Método que muestra la hora actual completa (hh:mm:ss) en tiempo real.
     */
    public void iniciar_Reloj() {

    }

    public void setVista(VentanaHomeVista vista, Stage dialogStage, SplitPane pane) {
        this.dialogStage = dialogStage;
        this.vista = vista;
        this.pane = pane;
    }


    public UsuarioDTO getUsuarioLogeado() {
        return userLogeado;
    }

    public void setUsuario() {
        this.userLogeado = listaUsuario.getUsuarioLogeado();
    }


    /**
     *
     */
    @FXML
    public void initialize() {
        //colEvento.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
    }

    public MenuBar getMenu() {
        return menu;
    }



    public void llenarTablaAmigos() {

    }

    public void llenarTablaCanales() {

    }

    /**
     *
     */
    public void llenarTablaEventos() {


    }


    /**
     *
     */
    public void addOpcionAdmin() {
        if (getUsuarioLogeado().getRol().equals("admin")) {
            Menu menu = new Menu();
            menu.setText("Opciones");

            MenuItem menuItem = new MenuItem();
            menuItem.setText("Config admin");
            menu.getItems().add(menuItem);

            getMenu().getMenus().add(menu);

            menuItem.setOnAction(event -> {

            });
        }
    }

    /**
     *
     */
    public void setImagenLupa() {
        URL url = getClass().getResource("/images/search.png");
        File file = new File(url.getPath());
        Image image = new Image(file.toURI().toString());
        fotoBusqueda.setImage(image);
    }

    /**
     * Método para salir de la aplicación (Log-out)
     *
     * @throws IOException
     */
    @FXML
    public void Logout() throws IOException {
        /*mainApp.Init();
        mainApp.LaunchInicio();*/
        dialogStage.close();
    }

    /**
     * *Método que carga la vista del perfil del usuario.
     * @throws IOException
     */
    @FXML
    public void LaunchPerfil() throws IOException {
       // mainApp.LaunchVistaPerfil(userLogeado);
    }

    /**
     * Método para cargar la vista del formulario y tablas de los eventos.
     *
     * @throws IOException
     */
    public void LoadEventoView() throws IOException {
        vistaevento = new VentanaEventoVista(dialogStage);
        vistaevento.loadEventoView(pane);
    }

    /**
     * @throws IOException
     */
    @FXML
    public void LoadAddEvent() throws IOException {
       // getMainApp().LaunchaddEvent();
    }



    /*@FXML
    public void AbrirdialogAñadirEvento() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/gestioneventos/VistaAddEventoDialog.fxml"));
        AnchorPane Aevent = (AnchorPane) loader.load();

        Stage newevent = new Stage();
        newevent.setTitle("Añadir Evento");
        newevent.initModality(Modality.WINDOW_MODAL);
        newevent.initOwner(dialogStage);
        Scene scene = new Scene(Aevent);
        newevent.setScene(scene);

        EventoController contevnt = loader.getController();
        contevnt.setdialogStage(dialogStage);
        contevnt.setMainApp(mainApp);

        dialogStage.showAndWait();
    }*/
}
