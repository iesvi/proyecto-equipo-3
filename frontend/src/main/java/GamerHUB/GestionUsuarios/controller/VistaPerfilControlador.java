package GamerHUB.GestionUsuarios.controller;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 */
public class VistaPerfilControlador {

    private MainApp mainApp;
    private UsuarioDTO usuarioDTO;
    private Stage dialogStage;

    /**
     *
     */
    private UsuarioDTO userLogeado = mainApp.getUsuarioLogeado();

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


    public MainApp getMainApp() {
        return mainApp;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
