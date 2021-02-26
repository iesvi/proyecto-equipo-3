package GamerHUB.GestionEventos.controller;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.GestionEventos.repository.ListaEvento;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.Shared.util.ActionDialogs;
import GamerHUB.GestionEventos.ui.VentanaAddEventVista;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class EventoAddController {

    @FXML
    private TextField campoAddName, campoAddDesc;

    @FXML
    private DatePicker fechainicioadd, fechafinaladd;

    @FXML
    private Button BotonAdd;

    private Stage dialogStage;

    private VentanaAddEventVista vista;

    private ListaEvento listaEvento = new ListaEvento();
    private ListaUsuario listaUsuario;

    private UsuarioDTO user;

    @FXML
    public void addEvento() {

        if (isInputValid()) {
            String nombre = campoAddName.getText();
            String Descripcion = campoAddDesc.getText();
            LocalDate fecha_ini = fechainicioadd.getValue();
            LocalDate fecha_f = fechafinaladd.getValue();
            int idusuario = user.getId();

            EventoDTO newevento = new EventoDTO(nombre, Descripcion, fecha_ini, fecha_f, idusuario);

            listaEvento.getEvents().add(newevento);


            ActionDialogs.info("Evento añadido correctamente.", "Evento añadido.\n" +
                    newevento.toString());

            dialogStage.close();
        }

    }

    public void setUsuarioLogeado(UsuarioDTO user) {
        this.user = user;
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

        if (fechainicioadd.getValue() == null) {
            errorMsg += "Introduce una fecha de inicio válida.";
        }
        if (fechafinaladd.getValue() == null) {
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

    public void setVista(VentanaAddEventVista vista, Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.vista = vista;
    }
}
