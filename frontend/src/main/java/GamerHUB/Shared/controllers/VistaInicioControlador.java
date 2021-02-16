package GamerHUB.Shared.controllers;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.MainApp;
import GamerHUB.Shared.exception.CustomException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;


public class VistaInicioControlador {

    private MainApp main;

    @FXML
    private TextField campoUsuario;
    @FXML
    private PasswordField campoPass;
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

    public void setdialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMain(MainApp main) {
        this.main = main;
    }

    @FXML
    private void initialize() {
        URL url = getClass().getResource("/images/gamerhublogo.png");
        File file = new File(url.getPath());
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }

    /**
     *
     */
    public VistaInicioControlador() {
       /* try {
            imageView = new ImageView(new Image(new FileInputStream("C:/Users/Vic/Desktop/proyecto-equipo-3/proyecto-equipo-3/frontend/src/main/resources/images/gamerhublogo.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    /**
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

        if (campoUsuario == null || campoUsuario.getText().isEmpty()) {
            errorMsg += "Introduce un nombre de usuario válido.\n ";
        }
        if (campoPass == null || campoPass.getText().isEmpty()) {
            errorMsg += "Introduce una contraseña válida.";
        }
        if (errorMsg.isEmpty()) {
            return true;
        } else {
            // Show the error message.
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error en los campos.");
            alerta.setHeaderText(null);
            alerta.setContentText(errorMsg);
            alerta.showAndWait();
            return false;
        }
    }

}
