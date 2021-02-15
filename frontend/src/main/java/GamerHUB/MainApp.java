package GamerHUB;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.Shared.controllers.VistaHomeControlador;
import GamerHUB.Shared.controllers.VistaInicioControlador;
import GamerHUB.Shared.exception.CustomException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 */
public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane anchorPane;
    private Stage stage;

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

    }

    public static void main(String[] args) {
        launch(args);
    }


    /**
     * @throws Exception
     */
    public void init() throws CustomException, IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("vistas/VistaInicio.fxml"));
        anchorPane = (AnchorPane) loader.load();

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);

        VistaInicioControlador controladorInicio = loader.getController();
        controladorInicio.setMain(this);

        primaryStage.show();

    }

    /**
     *
     * @param usuarioDTO
     * @throws CustomException
     * @throws IOException
     */
    public void launchHomeView(UsuarioDTO usuarioDTO)throws CustomException, IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("vistas/VistaHome.fxml"));
        anchorPane = (AnchorPane) loader.load();

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);

        VistaHomeControlador controladorHome = loader.getController();
        controladorHome.setMainApp(this);

        primaryStage.show();



    }

}
