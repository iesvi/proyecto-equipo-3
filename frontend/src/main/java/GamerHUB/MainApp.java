package GamerHUB;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.Shared.controllers.VistaHomeControlador;
import GamerHUB.Shared.controllers.VistaInicioControlador;
import GamerHUB.Shared.exception.CustomException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 */
public class MainApp extends Application {

    /**
     *
     */
    private Stage primaryStage;
    private BorderPane rootLayout;


    /**
     *
     */
    private ObservableList<UsuarioDTO> usuarios = FXCollections.observableArrayList();


    public MainApp() {
    }

    public ObservableList<UsuarioDTO> getUsuarios() {
        return usuarios;
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


    public void Init() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/RootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout);

                primaryStage.setScene(scene);


                primaryStage.show();

    }


    public void LaunchInicio() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/VistaInicio.fxml"));
        AnchorPane inicio = (AnchorPane) loader.load();

        rootLayout.setCenter(inicio);

        VistaInicioControlador controladorInicio = loader.getController();
        controladorInicio.setMain(this);

    }


    /**
     *
     * @param usuarioDTO
     * @throws CustomException
     * @throws IOException
     */
    public void launchHomeView(UsuarioDTO usuarioDTO)throws CustomException, IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/vistas/VistaHome.fxml"));
        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout);
        Stage dialogStage = new Stage();
        dialogStage.setScene(scene);

        VistaHomeControlador controladorHome = loader.getController();
        controladorHome.setUsuarioDTO(usuarioDTO);
        controladorHome.setMainApp(this);

        dialogStage.show();

    }

    public void launchSignUpView(){



    }

}
