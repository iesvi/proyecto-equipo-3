package GamerHUB.GestionUsuarios.controller;

import GamerHUB.GestionChat.repository.ListaChat;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.GestionUsuarios.repository.impl.UsuarioRespositorySocket;
import GamerHUB.GestionUsuarios.ui.VentanaSignUpVista;
import GamerHUB.Shared.conexion.ClientSocket;
import GamerHUB.Shared.util.ActionDialogs;
import GamerHUB.Shared.view.VentanaInicioVista;
import GamerHUB.Shared.view.VentanaRootVista;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class VistaRegistroControlador {

    private VentanaSignUpVista vista;
    private VentanaInicioVista ventanaInicioVista;
    private VentanaRootVista ventanaRootVista;
    private ListaUsuario listaUsuario;
    private ClientSocket CS;
    private ListaChat LC;

    /**
     *
     */
    @FXML
    private TextField campoUsuario;
    /**
     *
     */
    @FXML
    private TextField campoEmail;
    /**
     *
     */
    @FXML
    private TextField campoPass;

    /**
     *
     */
    @FXML
    private DatePicker fechaNac;
    @FXML
    private CheckBox checkBoxPoliticas = new CheckBox();

    @FXML
    private Button botonOk = new Button();

    private UsuarioRespositorySocket usuarioRespositorySocket;

    private Stage dialogStage;
    private UsuarioDTO usuarioDTO;
    private boolean okClicked = false;
    private ArrayList<String> roles;

    {
        roles = new ArrayList<String>() {
            {
                add("cliente");
                add("admin");
            }

        };
    }

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


    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setVista(VentanaSignUpVista vista, Stage dialogStage, ListaUsuario listaUsuario, ClientSocket CS, ListaChat LC) {
        this.dialogStage = dialogStage;
        this.vista = vista;
        this.listaUsuario = listaUsuario;
        this.CS = CS;
        this.LC = LC;
        usuarioRespositorySocket = new UsuarioRespositorySocket(CS);
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
    private void handleOk() throws IOException {
        if (isInputValid()) {

            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    campoUsuario.getText(),
                    campoPass.getText(),
                    campoEmail.getText(),
                    fechaNac.getValue(),
                    0,
                    "user"
            );

            usuarioRespositorySocket.add(usuarioDTO);
            listaUsuario.AddUsuario(usuarioDTO);

            ActionDialogs.info("Usuario registrado correctamente.", "Bienvenido a Gamerhub, disfruta de cheetos y doritos.\n" +
                    "Nombre de usuario: " + usuarioDTO.getNombre() + "\n" + "Password: " + usuarioDTO.getPassword());

            campoUsuario.setText("");
            campoPass.setText("");
            campoEmail.setText("");
            checkBoxPoliticas.setSelected(false);

            handleVolver();

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
            ActionDialogs.error("Error en los campos.", "Por favor, revisa algún dato que no esté correcto.");
            return false;
        }
    }


    /**
     * Volver a la pantalla de inicio de la app.
     */
    @FXML
    public void handleVolver() throws IOException {
        ventanaRootVista = new VentanaRootVista();
        ventanaRootVista.inicioStage(dialogStage, listaUsuario, CS, LC);
    }


}
