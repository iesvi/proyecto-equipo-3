package GamerHUB.Shared.controllers;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.MainApp;
import GamerHUB.Shared.exception.CustomException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class VistaInicioControlador {

    private MainApp main;

    @FXML
    private TextField campoUsuario;
    @FXML
    private TextField campoPass;
    @FXML
    Label accederARegistro;

    @FXML
    private ImageView imageView;

    private Stage dialogStage;
    private UsuarioDTO usuarioDTO;
    private boolean okClicked = false;


    public MainApp getMain() {
        return main;
    }

    public void setMain(MainApp main) {
        this.main = main;
    }

    /**
     *
     */
    public VistaInicioControlador() {
        try {
            imageView = new ImageView((Element) new Image(new FileInputStream("C:/Users/Vic/Desktop/proyecto-equipo-3/proyecto-equipo-3/frontend/src/main/resources/images/gamerhublogo.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @throws IOException
     * @throws CustomException
     */
    public void login() throws IOException, CustomException {

        usuarioDTO = new UsuarioDTO();

        if (isInputValid()) {
            String username = campoUsuario.getText();
            String pass = campoPass.getText();

            for (UsuarioDTO user : main.getUsuarios()) {

                if (user.getNombre().equals(username) && user.getPassword().equals(pass)) {
                    main.launchHomeView(user);
                    break;
                }

            }


        } else {

        }


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

           /* usuarioDTO.setUsuario(campoUsuario.getText());
            usuarioDTO.setEmail(campoEmail.getText());
            usuarioDTO.setPassword(campoPass.getText());
            usuarioDTO.setFecha_nacimiento(fechaNac);*/

            okClicked = true;
            dialogStage.close();
        }
    }


    /**
     * @return
     */
    public boolean isInputValid() {

        String errorMsg = "";

        if (campoUsuario.getText().isEmpty() || campoUsuario.getText() == null) {
            errorMsg += "Introduce un nombre de usuario válido";
        }

        if (campoPass.getText().isEmpty() || campoPass.getText() == null) {
            errorMsg += "Introduce una contraseña válida.";
        }
        if (errorMsg.length() == 0) {
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
