package GamerHUB.GestionEventos.ui;

import GamerHUB.GestionEventos.controller.EventoController;
import GamerHUB.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VentanaEventoVista {

    private Stage stageppal;

    public VentanaEventoVista(Stage stageppal) {
        this.stageppal = stageppal;
    }


    /**
     *
     * @throws IOException
     */
    public void loadEventoView(SplitPane pane) throws IOException {
        URL url = new File("frontend/src/main/java/GamerHUB/GestionEventos/ui/VistaGestionEventos.fxml").toURI().toURL();
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(url);
        AnchorPane anchorPane1 = loader2.load();
        pane.getItems().set(1, anchorPane1);

        EventoController eventocontrol = loader2.getController();
        eventocontrol.setVista(this, stageppal);

    }

}
