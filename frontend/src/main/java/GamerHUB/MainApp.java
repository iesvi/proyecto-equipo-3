package GamerHUB;

import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane anchorPane;
    private Stage stage;

    private ObservableList<UsuarioVO> usuarios =  FXCollections.observableArrayList();

    public MainApp() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public static void main(String[] args) {
        launch(args);
    }


    public void init() throws Exception {

        FXMLLoader loader = new FXMLLoader();



        /*
        y {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();


			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);
         */


    }






}
