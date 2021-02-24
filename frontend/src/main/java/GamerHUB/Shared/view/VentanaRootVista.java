package GamerHUB.Shared.view;

import GamerHUB.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaRootVista {

    private Stage primaryStage;
    private BorderPane rootLayout;


    public void inicioStage(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Welcome to GamerHub!");

        Init();


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
        loader.setLocation(MainApp.class.getResource("Shared/view/RootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout, 350, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
