package GamerHUB.Shared.controllers;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.MainApp;
import GamerHUB.Shared.exception.CustomException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    private Button aceptar;

    @FXML
    private ImageView imageView;

    private Stage dialogStage;
    private UsuarioDTO usuarioDTO;



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
    }



    /**
     *
     * @throws IOException
     * @throws CustomException
     */
    public void Login() throws IOException, CustomException {

        boolean correct = false;
        usuarioDTO = new UsuarioDTO();

        String username = campoUsuario.getText();
        String pass = campoPass.getText();

        for (UsuarioDTO user : main.getUsuarios()) {

            if (user.getNombre().equals(username) && user.getPassword().equals(pass)) {
                main.setUsuarioLogeado(user);
                main.LaunchHomeView();
                dialogStage.close();
            }

        }


    }



    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() throws IOException, CustomException {
        if (isInputValid()) {
            Login();
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

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void LaunchSignUpView(MouseEvent mouseEvent) throws IOException {
        main.LaunchSignUpView();
        this.dialogStage.close();
    }
}
