package GamerHUB.GestionPeticiones.controller;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.GestionPeticiones.model.dto.PeticionDTO;
import GamerHUB.GestionPeticiones.repository.Impl.PeticionRepositorySocket;
import GamerHUB.GestionPeticiones.repository.PeticionRepository;
import GamerHUB.GestionPeticiones.ui.VentanaPeticionVista;
import GamerHUB.Shared.conexion.ClientSocket;
import GamerHUB.Shared.util.ActionDialogs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 */
public class PeticionController {

    private String[] lista = new String[]{"No me llegan las notificaciones o me llegan mal.",
            "No me llegan las notificaciones de chat.", "Soy subnormal y no tendría que haber estudiado DAM me doy asco."};
    @FXML
    private ComboBox<String> listaIncidencias;

    @FXML
    private TextArea campoDescripcion;

    @FXML
    private Button enviar;

    private VentanaPeticionVista ventanaPeticionVista;
    private Stage stage;
    private ClientSocket CS;
    private PeticionRepositorySocket PRS;

    public void setVentanaPeticionVista(VentanaPeticionVista ventanaPeticionVista, Stage stage, ClientSocket CS) {
        this.ventanaPeticionVista = ventanaPeticionVista;
        this.stage = stage;
        this.CS = CS;
        PRS = new PeticionRepositorySocket(CS);
    }

    public PeticionController() {

    }
    public void setListaIncidencias(){
        listaIncidencias.setItems(FXCollections.observableArrayList(lista));
    }


    /**
     *
     */
    @FXML
    public void enviarPeticion() {

        if (!(listaIncidencias.getSelectionModel().getSelectedItem().isEmpty())) {

            if (!campoDescripcion.getText().isEmpty()) {
                PeticionDTO peticionDTO = new PeticionDTO(listaIncidencias.getSelectionModel().getSelectedItem().toString(),campoDescripcion.getText());


                PRS.add(peticionDTO);


                ActionDialogs.info("Petición enviada", "Gracias por tu mensaje.\n" + "Te enviaremos una respuesta lo antes posible.");

            }

        } else {

            ActionDialogs.error("Error.", "Error al enviar la petición. Revisa algún dato.");
        }

    }


}
