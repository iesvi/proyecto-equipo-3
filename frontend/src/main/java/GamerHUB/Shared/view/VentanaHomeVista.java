package GamerHUB.Shared.view;

import GamerHUB.GestionEventos.controller.EventoController;
import GamerHUB.MainApp;
import GamerHUB.Shared.controllers.VistaHomeControlador;
import GamerHUB.Shared.exception.CustomException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaHomeVista {

    private SplitPane pane;

    private Stage stageppal;

    public VentanaHomeVista (Stage stageppal) {
        this.stageppal = stageppal;
    }

    /**
     * @throws CustomException
     * @throws IOException
     */
    public void LaunchHomeView() throws CustomException, IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("Shared/view/VistaHome.fxml"));
        AnchorPane home = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        Scene scene = new Scene(home, 800, 525);
        dialogStage.setScene(scene);
        pane = (SplitPane) home.getChildren().get(0);

        loadHomeView1(dialogStage);
        loadHomeView2(dialogStage);

        pane.setDividerPositions(0.32);

        VistaHomeControlador controladorHome = loader.getController();
        controladorHome.setVista(this, dialogStage, pane);
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
        loader1.setLocation(MainApp.class.getResource("/Shared/view/VistaHome1.fxml"));
        AnchorPane anchorPane = loader1.load();
        pane.getItems().set(0, anchorPane);

        VistaHomeControlador controladorHome = loader1.getController();
        controladorHome.setVista(this, dialog, pane);
        controladorHome.setUsuario();
    }

    /**
     *
     * @throws IOException
     */
    public void loadHomeView2(Stage dialog) throws IOException {
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(MainApp.class.getResource("Shared/view/VistaHome2.fxml"));
        AnchorPane anchorPane1 = loader2.load();
        pane.getItems().set(1, anchorPane1);
        VistaHomeControlador controladorHome = loader2.getController();
        controladorHome.setVista(this, dialog, pane);
        controladorHome.setUsuario();
        controladorHome.setImagenLupa();
        controladorHome.iniciar_Reloj();
    }





}
