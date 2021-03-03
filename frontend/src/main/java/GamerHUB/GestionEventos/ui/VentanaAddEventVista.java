package GamerHUB.GestionEventos.ui;

import GamerHUB.GestionEventos.controller.EventoAddController;
import GamerHUB.GestionEventos.repository.ListaEvento;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VentanaAddEventVista {

    private Stage stageppal;
    private UsuarioDTO user;
    private ListaEvento listaEvento;

    public VentanaAddEventVista(Stage stageppal, UsuarioDTO user, ListaEvento listaEvento) {
        this.stageppal = stageppal;
        this.user = user;
        this.listaEvento = listaEvento;
    }

    /**
     * @throws IOException
     */
    public void LaunchaddEvent() throws IOException {
        URL url = new File("src/main/java/GamerHUB/GestionEventos/ui/VistaAddEventoDialog.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane addEvento = (AnchorPane) loader.load();

        Scene scene = new Scene(addEvento, 400, 450);
        Stage dialogStage = new Stage();
        dialogStage.setScene(scene);
        dialogStage.setTitle("Nuevo evento");
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        EventoAddController eventoaddController = loader.getController();
        eventoaddController.setUsuarioLogeado(user);
        eventoaddController.setlistaEventos(listaEvento);
        eventoaddController.setVista(this, dialogStage);

        dialogStage.show();

    }

}
