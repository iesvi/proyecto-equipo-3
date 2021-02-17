package GamerHUB.GestionUsuarios.controller;

import GamerHUB.GestionUsuarios.model.Conversor;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.GestionUsuarios.repository.impl.UsuarioRespositoryJDBC;
import GamerHUB.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class VistaRegistroControlador {

    @FXML
    private TextField campoUsuario, campoEmail, campoPass;

    @FXML
    private DatePicker fechaNac;
    @FXML
    private CheckBox checkBoxPoliticas = new CheckBox();

    @FXML
    private Button botonOk = new Button();

    private UsuarioRespositoryJDBC usuarioRespositoryJDBC =new UsuarioRespositoryJDBC();

    private Stage dialogStage;
    private UsuarioDTO usuarioDTO;
    private boolean okClicked = false;

    private MainApp mainApp = new MainApp();

    /**
     *
     */
    public VistaRegistroControlador() {
        //Inicializamos un valor por defecto para la fecha de nacimiento o cumpleaños
        //fechaNac = LocalDate.now();

        if (checkBoxPoliticas.isSelected())
            botonOk.setDisable(false);
        else botonOk.setDisable(true);


    }

    public MainApp getMainApp() {
        return mainApp;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void setUsuario(UsuarioDTO usuario) {


    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }


    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {

                UsuarioDTO usuarioDTO = new UsuarioDTO();

                usuarioDTO.setNombre(campoUsuario.getText().toString());
                usuarioDTO.setPassword(campoPass.getText());
                usuarioDTO.setEmail(campoEmail.getText());
                usuarioDTO.setFecha_nacimiento(fechaNac.getValue());
                usuarioDTO.setTelefono(000);
                usuarioDTO.setAmigos(null);
                usuarioDTO.setEventos(null);

                usuarioRespositoryJDBC.add(Conversor.dtoToVo(usuarioDTO));

                okClicked = true;
                dialogStage.close();

        }
    }


    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (campoUsuario.getText() == null || campoUsuario.getText().length() == 0) {
            errorMessage += "Nombre de usuario no válido!\n";
        }
        if (campoEmail.getText() == null || campoEmail.getText().length() == 0) {
            errorMessage += "Email no válido!\n";
        }
        if (campoPass.getText() == null || campoPass.getText().length() == 0) {
            errorMessage += "Contraseña no válidos!\n";
        }
        if (fechaNac == null) {
            errorMessage += "Fecha de cumpleaños no válida!\n";
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error en los campos.");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, revisa algún dato que no esté correcto.");
            alerta.showAndWait();
            return false;
        }
    }


    /**
     *
     */
    @FXML
    public void handleVolver() throws IOException {
        mainApp.Init();
    }

}
