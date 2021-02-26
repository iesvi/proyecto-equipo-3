package GamerHUB.GestionEventos.controller;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.GestionEventos.ui.VentanaEventoVista;
import GamerHUB.Shared.view.VentanaHomeVista;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


/**
 *Controlador de la vista de los eventos que crea el usuario.
 */
public class EventoController {

    private Stage dialogStage;

    private VentanaEventoVista vista;
    private VentanaHomeVista ventanaHomeVista;

    /**
     * Tabla que muestra todos los eventos de la plataforma
     */
    @FXML
    private TableView eventos;
    /**
     *Columna de la tabla de eventos que visualizará el listado de eventos.
     */
    @FXML
    TableColumn<EventoDTO, String> colEvento;

    /**
     * Campos para visualizar el nombre y la prioridad del evento seleccionado
     * de la tabla.
     */
    @FXML
    private TextField campoNombreEvento;
    /**
     * Campo con la descripción y los detalles del evento.
     */
    @FXML
    private TextArea campoDescEvento;
    /**
     * Fecha de inicio y de fin del evento propuesto.
     */
    @FXML
    private DatePicker fecha_i, fecha_f;

    /**
     * Botones para editar o eliminar el evento seleccionado. Otro para volver a la
     * vista anterior.
     */
    @FXML
    private Button btnEditarEvento, btnEliminarEvento, btnVolver;


    public EventoController() {
        //colEvento.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
    }


    @FXML
    public void volver() throws IOException {
        ventanaHomeVista.loadHomeView2(dialogStage);
        //mainApp.loadHomeView2(dialogStage);
    }

    public void setVista(VentanaEventoVista vista,Stage dialog) {
        this.dialogStage = dialog;
        this.vista = vista;
    }



}
