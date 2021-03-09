package GamerHUB.GestionEventos.controller;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.GestionEventos.repository.ListaEvento;
import GamerHUB.GestionEventos.ui.VentanaEventoVista;
import GamerHUB.Shared.util.ActionDialogs;
import GamerHUB.Shared.view.VentanaHomeVista;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


/**
 * Controlador de la vista de los eventos que crea el usuario.
 */
public class EventoController {

    /**
     * Columna de la tabla de eventos que visualizará el listado de eventos.
     */
    @FXML
    TableColumn<EventoDTO, String> colEvento;
    private Stage dialogStage;
    private VentanaEventoVista vista;
    private VentanaHomeVista ventanaHomeVista;
    private ListaEvento listaEvento;
    private EventoDTO currentEvento;
    /**
     * Tabla que muestra todos los eventos de la plataforma
     */
    @FXML
    private TableView<EventoDTO> eventos;
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

    }

    public void setVentanahome(VentanaHomeVista ventanaHomeVista) {
        this.ventanaHomeVista = ventanaHomeVista;
    }

    /**
     * @throws IOException
     */
    @FXML
    public void volver() throws IOException {
        ventanaHomeVista.loadHomeView2(dialogStage, listaEvento);
        //mainApp.loadHomeView2(dialogStage);
    }

    /**
     * @param vista
     * @param dialog
     * @param listaEvento
     */
    public void setVista(VentanaEventoVista vista, Stage dialog, ListaEvento listaEvento) {
        this.dialogStage = dialog;
        this.vista = vista;
        this.listaEvento = listaEvento;
    }

    /**
     *
     */
    public void iniciarEventos() {
        eventos.setItems(listaEvento.getEvents());
        colEvento.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());

        eventos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showEventoDetails(newValue));
    }

    /**
     * @param evento
     */
    public void showEventoDetails(EventoDTO evento) {
        if (evento != null) {
            campoNombreEvento.setText(evento.getNombre());
            campoDescEvento.setText(evento.getDescripcion());
            fecha_i.setValue(evento.getFechaini());
            fecha_f.setValue(evento.getFechaf());
            currentEvento = evento;
        } else {
            campoNombreEvento.setText("");
            campoDescEvento.setText("");
            fecha_i.setValue(null);
            fecha_f.setValue(null);
        }
    }

    /**
     *
     */
    @FXML
    public void eliminarEvento() {
        boolean correct = false;
        for (EventoDTO event : listaEvento.getEvents()) {
            if (event.equals(currentEvento)) {
                listaEvento.getEvents().remove(event);
                currentEvento = null;
                campoNombreEvento.setText("");
                campoDescEvento.setText("");
                fecha_i.setValue(null);
                fecha_f.setValue(null);
                correct = true;
                ActionDialogs.info("Eliminado", "El evento ha sido eliminado correctamente.");

                break;
            }
        }
        if (!correct) {
            ActionDialogs.error("Error", "Selecciona uno para poder eliminarlo");
        }
    }

    /**
     *
     */
    @FXML
    public void editarEvento() {
        String nombre = campoNombreEvento.getText();
        String Descripcion = campoDescEvento.getText();
        LocalDate fechainicial = fecha_i.getValue();
        LocalDate fechafinal = fecha_f.getValue();
        if (nombre.compareToIgnoreCase("") == 0 || Descripcion.compareToIgnoreCase("") == 0 || fechainicial == null || fechafinal == null) {
            ActionDialogs.error("Error", "Debes especificar todos los campos.\n" + "Vuelva a intentarlo de nuevo.");
        } else if (currentEvento == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No has seleccionado ningun evento a editar.");
            alert.setContentText("Vuelva a intentarlo de nuevo.");
            alert.showAndWait();
        } else {
            for (EventoDTO event : listaEvento.getEvents()) {
                if (event.equals(currentEvento)) {
                    event.setNombre(nombre);
                    event.setDescripcion(Descripcion);
                    event.setFechaini(fechainicial);
                    event.setFechaf(fechafinal);
                    currentEvento = event;
                    ActionDialogs.info("Editado", "El evento ha sido editado correctamente.");
                    break;
                }
            }
        }
    }


}
