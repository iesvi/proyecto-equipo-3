package GamerHUB.Shared.controllers;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.Shared.exception.CustomException;
import GamerHUB.Shared.view.VentanaHomeVista;
import GamerHUB.Shared.view.VentanaInicioVista;
import GamerHUB.GestionUsuarios.ui.VentanaSignUpVista;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Clase controlador de la vista de acceso a la aplicación (Login).
 */
public class VistaInicioControlador {


    private VentanaInicioVista vista;
    private UsuarioDTO usuarioLogeado = new UsuarioDTO();
    private ListaUsuario listaUsuario = new ListaUsuario();
    private VentanaSignUpVista ventanaSignUpVista;

    /**
     *
     */
    @FXML
    private TextField campoUsuario;
    /**
     *
     */
    @FXML
    private PasswordField campoPass;
    /**
     *
     */
    @FXML
    Label accederARegistro;

    /**
     *
     */
    @FXML
    private Button aceptar;

    /**
     *
     */
    @FXML
    private ImageView imageView;

    private Stage stageinicio;
    private UsuarioDTO usuarioDTO;




    public void setVista(VentanaInicioVista vista, Stage stageinicio) {
        this.stageinicio= stageinicio;
        this.vista = vista;
    }

    public UsuarioDTO getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(UsuarioDTO usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }

    /**
     *
     */
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

        for (UsuarioDTO user : listaUsuario.getUsers()) {
            if (user.getNombre().equals(username) && user.getPassword().equals(pass)) {
                VentanaHomeVista home = new VentanaHomeVista(stageinicio, user);
                home.LaunchHomeView();
                vista.getStageppal().close();

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
        ventanaSignUpVista.LaunchSignUpView();
        vista.getStageppal().close();
    }
}
