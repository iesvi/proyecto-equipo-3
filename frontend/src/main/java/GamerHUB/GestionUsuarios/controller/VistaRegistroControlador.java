package GamerHUB.GestionUsuarios.controller;

import GamerHUB.GestionUsuarios.model.Conversor;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.GestionUsuarios.repository.impl.UsuarioRespositoryJDBC;
import GamerHUB.MainApp;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class VistaRegistroControlador {


    @FXML
    private TextField campoUsuario;
    @FXML
    private TextField campoEmail;
    @FXML
    private TextField campoPass;
    @FXML
    private ComboBox<String> campoRol = new ComboBox<String>();;
    @FXML
    private DatePicker fechaNac;
    @FXML
    private CheckBox checkBoxPoliticas = new CheckBox();

    @FXML
    private Button botonOk = new Button();

    private UsuarioRespositoryJDBC usuarioRespositoryJDBC = new UsuarioRespositoryJDBC();

    private Stage dialogStage;
    private UsuarioDTO usuarioDTO;
    private boolean okClicked = false;
    private ArrayList<String> roles;
    {
        roles = new ArrayList<String>() {
            {  add("cliente");
                add("admin");  }

        };
    }

    private MainApp mainApp = new MainApp();

    /**
     *
     */
    public VistaRegistroControlador() {
        //Inicializamos un valor por defecto para la fecha de nacimiento o cumpleaños
        //fechaNac = LocalDate.now();
        campoRol.setItems(FXCollections.observableArrayList(roles));

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

            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    campoUsuario.getText(),
                    campoPass.getText(),
                    campoEmail.getText(),
                    fechaNac.getValue(),
                    0,
                    campoRol.getValue(),
                    new ArrayList<>(),
                    new ArrayList<>()

            );



            mainApp.getUsuarios().add(usuarioDTO);
            usuarioRespositoryJDBC.add(Conversor.dtoToVo(usuarioDTO));
            info("Usuario registrado correctamente."
                    , "Bienvenido a Gamerhub, disfruta de cheetos, doritos y mucho hentai.\n"+
                    usuarioDTO.toString());



            campoUsuario.setText("");
            campoPass.setText("");
            campoEmail.setText("");
            checkBoxPoliticas.setSelected(false);


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
        if (fechaNac.getValue() == null) {
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
     * Volver a la pantalla de inicio de la app.
     */
    @FXML
    public void handleVolver() throws IOException {
        mainApp.Init();
        mainApp.LaunchInicio();
        dialogStage.close();
    }

    /**
     *
     * @param title
     * @param msg
     */
    public void info(String title, String msg){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(title);
        alerta.setHeaderText(null);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }

}
