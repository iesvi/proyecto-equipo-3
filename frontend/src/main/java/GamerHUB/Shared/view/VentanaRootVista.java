package GamerHUB.Shared.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VentanaRootVista {

    private Stage primaryStage;
    private BorderPane rootLayout;


    public void inicioStage(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Welcome to GamerHub!");

        Init();

        VentanaInicioVista inicio = new VentanaInicioVista(primaryStage,rootLayout);
        inicio.LaunchInicio();


    }



    /**
     * Método que inicializa el componente padre de la ventana de la interfaz.
     * El resto de vistas se mostrán anidadas dentro de esta, según las acciones
     * de los usuarios.
     *
     * @throws IOException
     */
    public void Init() throws IOException {
        URL url = new File("frontend/src/main/java/GamerHUB/Shared/view/RootLayout.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        rootLayout = (BorderPane) loader.load();
        Scene scene = new Scene(rootLayout, 350, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
