package GamerHUB;

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

    private BorderPane rootLayout;
    private AnchorPane inicio, home, signup, perfil ;

    /**
     * Lista con los datos de usuarios de tipo DTO, que usará la aplicación para
     * mostrar y manipular.
     */
    private ObservableList<UsuarioDTO> usuarios = FXCollections.observableArrayList();
    /**
     * Lista con los datos de usuarios de tipo VO, que simulará una bbdd.
     */
    private ObservableList<UsuarioVO> usuarios_bd = FXCollections.observableArrayList();

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
                0,
                "admin",
                new ArrayList<>(),
                new ArrayList<>()

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


    public Set<UsuarioVO> getUsuarios_bbdd() {
        return usuarios_bbdd;
    }

    public UsuarioDTO getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(UsuarioDTO usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }

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

        Scene scene = new Scene(home, 800, 525);
        Stage dialogStage = new Stage();
        dialogStage.setScene(scene);

        dialogStage.setTitle("Bienvenido "+usuarioLogeado.getNombre()+"!");

        VistaHomeControlador controladorHome = loader.getController();
        controladorHome.setDialogStage(dialogStage);
        controladorHome.setUsuarioDTO(usuarioLogeado);
        controladorHome.setMainApp(this);

        dialogStage.show();

    }

    /**
     * @throws IOException
     */
    public void LaunchSignUpView() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/gestionusuario/VistaRegistro.fxml"));
        signup = (AnchorPane) loader.load();

        Scene scene = new Scene(signup, 400, 500);
        Stage dialogStage = new Stage();
        dialogStage.setScene(scene);
        //rootLayout.setCenter(signup);
        dialogStage.setTitle("Únete a gamerhub!");
       // Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        //primaryStage.setScene(new Scene(rootLayout, 400, 550));
        //primaryStage.sizeToScene();
        //dialogStage.setScene();

        VistaRegistroControlador controladorRegistro = loader.getController();
        controladorRegistro.setDialogStage(dialogStage);
        controladorRegistro.setMainApp(this);

        //primaryStage.show();
       dialogStage.show();


    }

    /**
     *
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
