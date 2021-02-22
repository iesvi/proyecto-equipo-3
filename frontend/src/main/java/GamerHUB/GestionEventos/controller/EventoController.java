package GamerHUB.GestionEventos.controller;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.MainApp;
import GamerHUB.Shared.util.ActionDialogs;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


/**
 *Controlador de la vista de los eventos que crea el usuario.
 */
public class EventoController {

    private Stage dialogStage;

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
    private TextField campoNombreEvento, campoAddName, campoAddDesc;
    /**
     * Campo con la descripción y los detalles del evento.
     */
    @FXML
    private TextArea campoDescEvento;
    /**
     * Fecha de inicio y de fin del evento propuesto.
     */
    @FXML
    private DatePicker fecha_i, fecha_f, fechainicioAdd, fechafinalAdd;

    /**
     * Botones para editar o eliminar el evento seleccionado. Otro para volver a la
     * vista anterior.
     */
    @FXML
    private Button btnEditarEvento, btnEliminarEvento, btnVolver, BotonAdd;


    public EventoController() {
        //colEvento.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
    }


    @FXML
    public void volver() throws IOException {
        mainApp.loadHomeView2(dialogStage);
    }

    public void setdialogStage(Stage dialog) {
        this.dialogStage = dialog;
    }

    public MainApp getMainApp() {
        return mainApp;
    }

    public void setMainApp(MainApp main) {
        this.mainApp = main;
        //  eventos.setItems(getMainApp().getEventos());
    }

    @FXML
    public void addEvento() {

        if (isInputValid()) {
            String nombre = campoAddName.getText();
            String Descripcion = campoAddDesc.getText();
            LocalDate fecha_ini = fechainicioAdd.getValue();
            LocalDate fecha_f = fechafinalAdd.getValue();
            int idusuario = mainApp.getUsuarioLogeado().getId();

            EventoDTO newevento = new EventoDTO(nombre, Descripcion, fecha_ini, fecha_f, idusuario);

            mainApp.getEventos().add(newevento);

            ActionDialogs.info("Evento añadido correctamente.", "Evento añadido.\n" +
                    newevento.toString());

            dialogStage.close();
        }

    }


    /**
     * @return
     */
    public boolean isInputValid() {

        String errorMsg = "";

        if (campoAddName == null || campoAddName.getText().isEmpty()) {
            errorMsg += "Introduce un nombre de evento válido.\n ";
        }
        if (campoAddDesc == null || campoAddDesc.getText().isEmpty()) {
            errorMsg += "Introduce una descripción válida.";
        }

        if (fechainicioAdd.getValue() == null) {
            errorMsg += "Introduce una fecha de inicio válida.";
        }
        if (fechafinalAdd.getValue() == null) {
            errorMsg += "Introduce una fecha de fin válida.";
        }

        if (errorMsg.isEmpty()) {
            return true;
        } else {
            // Show the error message.
            ActionDialogs.error("Error en los campos", errorMsg);
            return false;
        }
    }


}
