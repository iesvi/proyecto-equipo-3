package GamerHUB.GestionEventos.ui;

import GamerHUB.GestionEventos.controller.EventoController;
import GamerHUB.GestionEventos.repository.ListaEvento;
import GamerHUB.Shared.view.VentanaHomeVista;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VentanaEventoVista {

    private Stage stageppal;
    private VentanaHomeVista ventanaHomeVista;
    private ListaEvento listaEvento;

    public VentanaEventoVista(Stage stageppal, VentanaHomeVista ventanaHomeVista, ListaEvento listaEvento) {
        this.stageppal = stageppal;
        this.ventanaHomeVista = ventanaHomeVista;
        this.listaEvento = listaEvento;
    }


    /**
     * @throws IOException
     */
    public void loadEventoView(SplitPane pane) throws IOException {
        URL url = new File("frontend/src/main/java/GamerHUB/GestionEventos/ui/VistaGestionEventos.fxml").toURI().toURL();
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(url);
        AnchorPane anchorPane1 = loader2.load();
        pane.getItems().set(1, anchorPane1);

        EventoController eventocontrol = loader2.getController();
        eventocontrol.setVista(this, stageppal, listaEvento);
        eventocontrol.iniciarEventos();
        eventocontrol.setVentanahome(ventanaHomeVista);
    }

}
