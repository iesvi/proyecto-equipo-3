package GamerHUB.Shared.controllers;


import GamerHUB.GestionChat.controller.MultiChatUDP;
import GamerHUB.GestionChat.model.dto.CanalDTO;
import GamerHUB.GestionChat.repository.ListaChat;
import GamerHUB.GestionChat.ui.VentanaAddChatVista;
import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.GestionEventos.repository.ListaEvento;
import GamerHUB.GestionEventos.ui.VentanaAddEventVista;
import GamerHUB.GestionEventos.ui.VentanaEventoVista;
import GamerHUB.GestionPeticiones.ui.VentanaPeticionVista;
import GamerHUB.GestionServidorArchivos.Apartado4_5.Servidor;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.GestionUsuarios.ui.VentanaPerfilVista;
import GamerHUB.Shared.util.ActionDialogs;
import GamerHUB.Shared.util.ProcessHora;
import GamerHUB.Shared.view.VentanaHomeVista;
import GamerHUB.Shared.view.VentanaRootVista;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;

/**
 * Controlador de la
 */
public class VistaHomeControlador {

    private Stage dialogStage;
    private UsuarioDTO userLogeado;
    private VentanaHomeVista vista;
    private VentanaEventoVista vistaevento;
    private SplitPane pane;
    private ListaUsuario listaUsuario;
    private ProcessHora hora;
    private ListaEvento listaEvento;
    private ListaChat listaChat;



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
    private TableColumn<EventoDTO, String> colEvento;

    @FXML
    private MenuBar menuBar = new MenuBar();

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
    private TextField searchBar;
    @FXML
    private TextField msgBar = new TextField();

    @FXML
    private TextArea areaChat;

    /**
     *
     */
    @FXML
    public Button btnConfig, btnAyuda, btnGestionArchivos, btnNuevoCanal, btnNuevoEvento, btnConfigEventos;

    /**
     *
     */
    @FXML
    public MenuItem btnSalir;

    @FXML
    private Label time;


    MultiChatUDP multiChatUDP;
    /**
     *
     */
    public VistaHomeControlador() throws IOException {
        hora = new ProcessHora();

        listaChat = new ListaChat();

        multiChatUDP = new MultiChatUDP("user", this);
        new Thread(multiChatUDP).start();



        // addOpcionAdmin();
    }

            @FXML
            public void handlemensaje(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ENTER)
                {
                    try {
                        multiChatUDP.sendMsg("user", msgBar.getText().toString());
                        msgBar.setText("");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


    /**
     * @param vista
     * @param dialogStage
     * @param pane
     */
    public void setVista(VentanaHomeVista vista, Stage dialogStage, SplitPane pane) {
        this.dialogStage = dialogStage;
        this.vista = vista;
        this.pane = pane;
    }

    public void initCanales(ListaChat listaChat){

        if(listaChat ==null){
            this.listaChat = new ListaChat();

            listaChat.getCanales().add(new CanalDTO("factores", 1234, FXCollections.observableArrayList(
                    new Integer(12345678), new Integer(9876543)
            )));
        } else {
            this.listaChat = listaChat;
        }

    }

    /**
     * @param listaEvento
     */
    public void setEventos(ListaEvento listaEvento) {
        if (listaEvento == null) {
            if (userLogeado.getEventos().isEmpty()) {
                this.listaEvento = new ListaEvento();
            } else {
                this.listaEvento = new ListaEvento(userLogeado.getEventos());
            }
        } else {
            this.listaEvento = listaEvento;
        }
    }

    public UsuarioDTO getUsuarioLogeado() {
        return userLogeado;
    }

    public void setUsuario(UsuarioDTO user) {
        this.userLogeado = user;
    }

    public TextField getMsgBar() {
        return msgBar;
    }

    public TextArea getAreaChat() {
        return areaChat;
    }

    /**
     * Método que muestra la hora actual completa (hh:mm:ss) en tiempo real.
     */
    public void iniciar_Reloj() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = hora.procesoHora();
            time.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }


    /**
     *
     */
    @FXML
    public void initialize() {
       addOpcionAdmin();
    }

    public MenuBar getMenu() {
        return menuBar;
    }


    public void llenarTablaAmigos() {

    }

    public void llenarTablaCanales() {

        if(listaChat.getCanales()!=null && listaChat!=null){
            canales.setItems(listaChat.getCanales());
            colCanal.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        }


    }

    /**
     *
     */
    public void llenarTablaEventos() {
        eventos.setItems(listaEvento.getEvents());
        colEvento.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
    }


    /**
     *
     */
    public void addOpcionAdmin() {
       // if (getUsuarioLogeado().getRol().equals("admin")) {
            Menu menu = new Menu();
            menu.setText("Opciones");

            MenuItem menuItem = new MenuItem();
            menuItem.setText("Config admin");
            menu.getItems().add(menuItem);

            getMenu().getMenus().add(menu);

            menuItem.setOnAction(event -> {

                try {
                    vista.LaunchVistaAdmin();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            });
       // }
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
        VentanaRootVista ventanaRoot = new VentanaRootVista();
        ventanaRoot.inicioStage(new Stage(), listaUsuario);
        dialogStage.close();
    }

    /**
     * *Método que carga la vista del perfil del usuario.
     *
     * @throws IOException
     */
    @FXML
    public void LaunchPerfil() throws IOException {
        VentanaPerfilVista ventanavista = new VentanaPerfilVista(dialogStage, vista);
        ventanavista.LaunchVistaPerfil(pane, userLogeado);
    }

    public void setUserNameLabel() {
        userName.setText(userLogeado.getNombre());
    }

    @FXML
    public void LaunchVistaFTP() throws IOException {
        String[] args = {};
        Servidor.main(args);
    }
    /**
     * Método para cargar la vista del formulario y tablas de los eventos.
     *
     * @throws IOException
     */
    public void LoadEventoView() throws IOException {
        vistaevento = new VentanaEventoVista(dialogStage, vista, listaEvento);
        vistaevento.loadEventoView(pane);
    }

    /**
     * @throws IOException
     */
    @FXML
    public void LoadAddEvent() throws IOException {
        VentanaAddEventVista ventanaAddEventVista = new VentanaAddEventVista(dialogStage, userLogeado, listaEvento);
        ventanaAddEventVista.LaunchaddEvent();
        // getMainApp().LaunchaddEvent();
    }

    @FXML
    public void LoadAddCanal() throws  IOException{
        VentanaAddChatVista ventanaAddChatVista = new VentanaAddChatVista(dialogStage);
        ventanaAddChatVista.LaunchAddCanal();
    }

    @FXML
    private void LaunchVistaPeticion() throws IOException {

        VentanaPeticionVista ventanaPeticionVista = new VentanaPeticionVista(dialogStage);
        ventanaPeticionVista.LaunchVistaPeticion();

    }


    public void LaunchVistaAdmin() {

    }

    public void setlistaUsuarios(ListaUsuario listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
}
