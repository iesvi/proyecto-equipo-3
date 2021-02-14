package GamerHUB.GestionUsuarios.controller;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class VistaRegistroControlador {

    @FXML
    private TextField campoUsuario;
    @FXML
    private TextField campoEmail;
    @FXML
    private TextField campoPass;
    @FXML
    private LocalDate fechaNac;
    @FXML
   private CheckBox checkBoxPoliticas;

    private Stage dialogStage;
    private UsuarioDTO usuarioDTO;
    private boolean okClicked = false;

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public VistaRegistroControlador() {
        //Inicializamos un valor por defecto para la fecha de nacimiento o cumpleaños
        fechaNac = LocalDate.now();
    }

    public void setUsuario(UsuarioDTO usuario){



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

            usuarioDTO.setUsuario(campoUsuario.getText());
            usuarioDTO.setEmail(campoEmail.getText());
            usuarioDTO.setPassword(campoPass.getText());
            usuarioDTO.setFecha_nacimiento(fechaNac);

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
        if (fechaNac == null ) {
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


}
