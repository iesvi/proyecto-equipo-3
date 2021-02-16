package GamerHUB;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.Shared.controllers.RootLayoutController;
import GamerHUB.Shared.controllers.VistaHomeControlador;
import GamerHUB.Shared.controllers.VistaInicioControlador;
import GamerHUB.Shared.exception.CustomException;
import javafx.application.Application;
import javafx.application.Platform;
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

    private Stage primaryStage= new  Stage();
    private BorderPane rootLayout;


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


        init();
        launchInicio();


    }

    public static void main(String[] args) {
        launch(args);
    }


    public void init() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("./Shared/vistas/RootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout);

                primaryStage.setScene(scene);
                RootLayoutController controladorInicio = loader.getController();
                controladorInicio.setMainApp(this);

                primaryStage.show();

    }


    public void launchInicio() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("./Shared/vistas/VistaInicio.fxml"));
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
        loader.setLocation(MainApp.class.getResource("./Shared/vistas/VistaHome.fxml"));
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
