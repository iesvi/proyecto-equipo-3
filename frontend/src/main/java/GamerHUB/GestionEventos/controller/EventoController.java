package GamerHUB.GestionEventos.controller;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;


/**
 *
 */
public class EventoController {


    /**
     * Variable de acceso al controlador principal.
     */
    private MainApp mainApp;

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
    private TextField campoNombreEvento, campoPrioridad;
    /**
     * Campo con la descripción y los detalles del evento.
     */
    @FXML
    private TextArea  campoDescEvento;
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


    public EventoController(){

    }





}
