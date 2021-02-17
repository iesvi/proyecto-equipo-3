package GamerHUB;

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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 */
public class MainApp extends Application {

    /**
     *
     */
    private Stage primaryStage;
    private Scene scene;
    private BorderPane rootLayout;


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


    public MainApp() {

        //usuarios.add(new UsuarioDTO( new SimpleStringProperty("kk")));

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
     * y contraseña al usuario para poder acceder al resto de la aplicación, si esta registrado.,
     * o en su defecto registrarse antes.
     * @throws IOException
     */
    public void LaunchInicio() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/shared/VistaInicio.fxml"));
        AnchorPane inicio = (AnchorPane) loader.load();

        rootLayout.setCenter(inicio);

        VistaInicioControlador controladorInicio = loader.getController();
        controladorInicio.setdialogStage(primaryStage);
        controladorInicio.setMain(this);

    }


    /**
     *
     * @param usuarioDTO
     * @throws CustomException
     * @throws IOException
     */
    public void LaunchHomeView(UsuarioDTO usuarioDTO) throws CustomException, IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/shared/VistaHome.fxml"));
        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout, 350, 600);
        Stage dialogStage = new Stage();
        dialogStage.setScene(scene);

        VistaHomeControlador controladorHome = loader.getController();
        controladorHome.setDialogStage(dialogStage);
        controladorHome.setUsuarioDTO(usuarioDTO);
        controladorHome.setMainApp(this);

        dialogStage.show();

    }

    /**
     *
     * @throws IOException
     */
    public void LaunchSignUpView() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/gestionusuario/VistaRegistro.fxml"));
        AnchorPane signup = (AnchorPane) loader.load();
        rootLayout.setCenter(signup);

        Stage dialogStage = new Stage();

        primaryStage.setScene(new Scene(rootLayout, 400, 550));
        primaryStage.sizeToScene();
        //dialogStage.setScene();

        VistaRegistroControlador controladorHome = loader.getController();
        controladorHome.setMainApp(this);

        primaryStage.show();
        //dialogStage.show();


    }

}
