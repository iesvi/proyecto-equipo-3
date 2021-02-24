package GamerHUB.Shared.view;

import GamerHUB.GestionEventos.controller.EventoController;
import GamerHUB.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

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
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(MainApp.class.getResource("Shared/view/VistaGestionEventos.fxml"));
        AnchorPane anchorPane1 = loader2.load();
        pane.getItems().set(1, anchorPane1);

        EventoController eventocontrol = loader2.getController();
        eventocontrol.setVista(this, stageppal);

    }

}
