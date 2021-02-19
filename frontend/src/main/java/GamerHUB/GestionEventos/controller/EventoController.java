package GamerHUB.GestionEventos.controller;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;


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
    private TextField campoNombreEvento, campoañadirnombre, campoañadirdescripcion;
    /**
     * Campo con la descripción y los detalles del evento.
     */
    @FXML
    private TextArea  campoDescEvento;
    /**
     * Fecha de inicio y de fin del evento propuesto.
     */
    @FXML
    private DatePicker fecha_i, fecha_f, Fechainicioañadir, Fechafinalañadir;

    /**
     * Botones para editar o eliminar el evento seleccionado. Otro para volver a la
     * vista anterior.
     */
    @FXML
    private Button btnEditarEvento, btnEliminarEvento, btnVolver, BotonAñadir;


    public EventoController(){

    }


    @FXML
    public void volver() throws IOException {
        mainApp.loadHomeView2(dialogStage);
    }

    public void setdialogStage(Stage dialog){
        this.dialogStage=dialog;
    }

    public void setmainApp(MainApp main){
        this.mainApp = main;
    }

    @FXML
    public void añadirEvento() {
        String nombre = campoañadirnombre.getText();
        String Descripcion = campoañadirdescripcion.getText();
        LocalDate fecha_ini = Fechainicioañadir.getValue();
        LocalDate fecha_f = Fechafinalañadir.getValue();
        int idusuario = mainApp.getUsuarioLogeado().getId();

        EventoDTO newevento = new EventoDTO(nombre,Descripcion,fecha_ini,fecha_f,idusuario);

        mainApp.getEventos().add(newevento);

        info("Evento añadido correctamente."
                , "Evento añadido.\n"+
                        newevento.toString());


    }

    public void info(String title, String msg){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(title);
        alerta.setHeaderText(null);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }


}
