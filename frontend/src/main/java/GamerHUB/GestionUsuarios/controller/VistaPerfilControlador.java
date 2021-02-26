package GamerHUB.GestionUsuarios.controller;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.GestionUsuarios.ui.VentanaPerfilVista;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 */
public class VistaPerfilControlador {
    private VentanaPerfilVista vista;
    private UsuarioDTO usuarioDTO;
    private Stage dialogStage;
private ListaUsuario listaUsuario;
    /**
     *
     */
    private UsuarioDTO userLogeado = listaUsuario.getUsuarioLogeado();

    /**
     *
     */
    @FXML
    private TextField campoNombre, campoEmail, campoTelefono;

    /**
     *
     */
    @FXML
    private DatePicker fechaNac;

    /**
     *
     */
    @FXML
    private Button btnBack, btnEditar, btnCambiarPass, btnAjustesAvanzados;

    public VistaPerfilControlador() {
    }


    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }


    public void setVista(VentanaPerfilVista vista, Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.vista = vista;
    }
}
