package GamerHUB;

import GamerHUB.GestionEventos.controller.EventoController;
import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.GestionEventos.model.vo.EventoVO;
import GamerHUB.GestionUsuarios.controller.VistaPerfilControlador;
import GamerHUB.GestionUsuarios.controller.VistaRegistroControlador;
import GamerHUB.GestionUsuarios.model.Conversor;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.Shared.controllers.VistaHomeControlador;
import GamerHUB.Shared.controllers.VistaInicioControlador;
import GamerHUB.Shared.exception.CustomException;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Controlador principal de la aplicación. Se encargará de lanzar los métodos de renderizado de las vistas
 * y las listas en memoria.
 */
public class MainApp extends Application {

    /**
     *
     */
    private Stage primaryStage;
    private Scene scene;


    /**
     *
     */
    private BorderPane rootLayout;
    /**
     *
     */
    private AnchorPane inicio;
    private AnchorPane home;
    private AnchorPane perfil;
    private AnchorPane evento;
    /**
     *
     */
    private SplitPane pane;

    /**
     * Lista con los datos de usuarios de tipo DTO, que usará la aplicación para
     * mostrar y manipular.
     */
    private ObservableList<UsuarioDTO> usuarios = FXCollections.observableArrayList();
    /**
     * Lista con los datos de usuarios de tipo VO, que simulará una bbdd.
     */
    private ObservableList<UsuarioVO> usuarios_bd = FXCollections.observableArrayList();

    private ObservableList<EventoDTO> evento_list = FXCollections.observableArrayList();

    private ObservableList<EventoVO> evento_bd = FXCollections.observableArrayList();


    private Set<UsuarioVO> usuarios_bbdd = new TreeSet<UsuarioVO>();

    /**
     *
     */
    private UsuarioDTO usuarioLogeado = new UsuarioDTO();


    public MainApp() {

        //usuarios.add(new UsuarioDTO( new SimpleStringProperty("kk")));

        LocalDate localDate = LocalDate.now();
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "user",
                "user",
                "email",
                localDate,
                0
        );

        usuarios.add(usuarioDTO);

        if (!usuarios_bd.isEmpty()) {
            for (UsuarioVO user : usuarios_bd) {
                usuarios.add(Conversor.voToDto(user));

            }
            usuarios_bbdd.addAll(usuarios_bd);
        }

    }

    public ObservableList<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public ObservableList<UsuarioVO> getUsuarios_bd() {
        return usuarios_bd;
    }

    public ObservableList<EventoDTO> getEventos() {
        return evento_list;
    }

    public ObservableList<EventoVO> getEventos_bd() {
        return evento_bd;
    }


    public Set<UsuarioVO> getUsuarios_bbdd() {
        return usuarios_bbdd;
    }

    public UsuarioDTO getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(UsuarioDTO usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }

    public SplitPane getPane() {
        return pane;
    }

    public void setPane(SplitPane pane) {
        this.pane = pane;
    }



    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Welcome to GamerHub!");

        Init();
        LaunchInicio();


    }

    public static void main(String[] args) {
        launch(args);
    }


    /**
     * Método que inicializa el componente padre de la ventana de la interfaz.
     * El resto de vistas se mostrán anidadas dentro de esta, según las acciones
     * de los usuarios.
     *
     * @throws IOException
     */
    public void Init() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/shared/RootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();

        scene = new Scene(rootLayout, 350, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    /**
     * Vista de acceso o "logeo" a la aplicación. Se solicitan los datos nombre de usuario
     * y contraseña al usuario para poder acceder al resto de la aplicación, si esta registrado,
     * o en su defecto registrarse antes.
     *
     * @throws IOException
     */
    public void LaunchInicio() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/shared/VistaInicio.fxml"));
        inicio = (AnchorPane) loader.load();

        rootLayout.setCenter(inicio);

        //inicio.setBackground();
        VistaInicioControlador controladorInicio = loader.getController();
        controladorInicio.setdialogStage(primaryStage);
        controladorInicio.setMain(this);

    }


    /**
     * @throws CustomException
     * @throws IOException
     */
    public void LaunchHomeView() throws CustomException, IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/shared/VistaHome.fxml"));
        home = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        Scene scene = new Scene(home, 800, 525);
        dialogStage = new Stage();
        dialogStage.setScene(scene);
         pane = (SplitPane) home.getChildren().get(0);

        /**
         *
         */
        loadHomeView1(dialogStage);

        /**
         *
         */
        loadHomeView2(dialogStage);

        pane.setDividerPositions(0.32);


        VistaHomeControlador controladorHome = loader.getController();
        controladorHome.setDialogStage(dialogStage);
        controladorHome.setMainApp(this);
        controladorHome.setUsuario();
        dialogStage.setTitle("Bienvenido " + usuarioLogeado.getNombre() + "!");

        dialogStage.show();

    }

    /**
     *
     * @throws IOException
     */
    public void loadHomeView1(Stage dialog) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(MainApp.class.getResource("/vistas/shared/VistaHome1.fxml"));
        AnchorPane anchorPane = loader1.load();
        pane.getItems().set(0, anchorPane);
        VistaHomeControlador controladorHome = loader1.getController();
        controladorHome.setDialogStage(dialog);
        controladorHome.setMainApp(this);
        controladorHome.setUsuario();
    }

    /**
     *
     * @throws IOException
     */
    public void loadHomeView2(Stage dialog) throws IOException {
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(MainApp.class.getResource("/vistas/shared/VistaHome2.fxml"));
        AnchorPane anchorPane1 = loader2.load();
        pane.getItems().set(1, anchorPane1);
        VistaHomeControlador controladorHome = loader2.getController();
        controladorHome.setDialogStage(dialog);
        controladorHome.setMainApp(this);
        controladorHome.setUsuario();
        controladorHome.setImagenLupa();
        controladorHome.iniciar_Reloj();
    }

    /**
     *
     * @throws IOException
     */
    public void loadEventoView(Stage dialog) throws IOException {
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(MainApp.class.getResource("/vistas/gestioneventos/VistaGestionEventos.fxml"));
        AnchorPane anchorPane1 = loader2.load();
        pane.getItems().set(1, anchorPane1);

        EventoController eventocontrol = loader2.getController();
        eventocontrol.setdialogStage(dialog);
        eventocontrol.setmainApp(this);



    }

    /**
     * @throws IOException
     */
    public void LaunchSignUpView() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/gestionusuario/VistaRegistro.fxml"));
        AnchorPane signup = (AnchorPane) loader.load();

        Scene scene = new Scene(signup, 400, 500);
        Stage dialogStage = new Stage();
        dialogStage.setScene(scene);
        dialogStage.setTitle("Únete a gamerhub!");
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        VistaRegistroControlador controladorRegistro = loader.getController();
        controladorRegistro.setDialogStage(dialogStage);
        controladorRegistro.setMainApp(this);

        dialogStage.show();


    }

    /**
     * @param usuarioDTO
     * @throws IOException
     */
    public void LaunchVistaPerfil(UsuarioDTO usuarioDTO) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/gestionusuario/VistaPerfil.fxml"));
        perfil = (AnchorPane) loader.load();

        Scene scene = new Scene(home, 400, 500);
        Stage dialogStage = new Stage();
        dialogStage.setScene(scene);

        dialogStage.setTitle("Configuración");

        VistaPerfilControlador controladorHome = loader.getController();
        controladorHome.setDialogStage(dialogStage);
        controladorHome.setUsuarioDTO(usuarioDTO);
        controladorHome.setMainApp(this);

        dialogStage.show();
    }


}
