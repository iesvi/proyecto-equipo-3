package GamerHUB.Shared.controllers;

import GamerHUB.GestionChat.repository.Impl.ChatRepositorySocket;
import GamerHUB.GestionChat.repository.ListaChat;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.GestionUsuarios.repository.impl.UsuarioRespositorySocket;
import GamerHUB.GestionUsuarios.ui.VentanaSignUpVista;
import GamerHUB.Shared.conexion.ClientSocket;
import GamerHUB.Shared.exception.CustomException;
import GamerHUB.Shared.util.ActionDialogs;
import GamerHUB.Shared.view.VentanaHomeVista;
import GamerHUB.Shared.view.VentanaInicioVista;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

/**
 * Clase controlador de la vista de acceso a la aplicación (Login).
 */
public class VistaInicioControlador {


    /**
     *
     */
    @FXML
    Label accederARegistro;
    // private final Socket socket = new Socket("localhost", 12345);
    private VentanaInicioVista vista;
    private UsuarioDTO usuarioLogeado = new UsuarioDTO();
    private ListaUsuario listaUsuario;
    private VentanaSignUpVista ventanaSignUpVista;
    private UsuarioRespositorySocket URS;
    private ChatRepositorySocket CRS;
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
    private PasswordField campoPass;
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


    /**
     *
     */
    public VistaInicioControlador() throws IOException {

    }

    public void setVista(VentanaInicioVista vista, Stage stageinicio, ListaUsuario listaUsuario, ClientSocket CS, ListaChat LC) {
        this.stageinicio = stageinicio;
        this.vista = vista;
        this.listaUsuario = listaUsuario;
        this.CS = CS;
        this.LC = LC;
    }

    public void setListaUsuario() {
        URS = new UsuarioRespositorySocket(CS);
        listaUsuario.setlistaUsuarios(URS.retrieveUsers());
    }

    public void setListaChat() {
        CRS = new ChatRepositorySocket(CS);
        LC.setlistaChat(CRS.retrieveChats());
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
     * @throws IOException
     * @throws CustomException
     */
    public void Login() throws Exception, IOException, CustomException {

        boolean correct = false;
        usuarioDTO = new UsuarioDTO();

        String username = campoUsuario.getText();
        String pass = campoPass.getText();

        //LoginThread loginThread =new LoginThread(socket);

        for (UsuarioDTO user : listaUsuario.getUsers()) {
            if (user.getNombre().equals(username) && user.getPassword().equals(pass)) {
                logUsuario(user);
                VentanaHomeVista home = new VentanaHomeVista(stageinicio, user, listaUsuario, CS, LC);
                home.LaunchHomeView();
                vista.getStageppal().close();
                correct = true;
                break;


            } else if (user.getEmail().equals(username) && user.getPassword().equals(pass)) {
                logUsuario(user);
                VentanaHomeVista home = new VentanaHomeVista(stageinicio, user, listaUsuario, CS, LC);
                home.LaunchHomeView();
                vista.getStageppal().close();
                correct = true;
                break;
            }
        }
        if (!correct) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error con las credenciales");
            alert.setHeaderText("Usuario/contraseña incorrectos.");
            alert.setContentText("Vuelva a intentarlo de nuevo.");
            alert.showAndWait();
        }


    }

    @FXML
    public void Loginenter(KeyEvent keyEvent) throws Exception {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Login();
        }
    }


    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() throws Exception, IOException, CustomException {
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
            ActionDialogs.error("Error en los campos.", errorMsg);

            return false;
        }
    }

    /**
     * @param mouseEvent
     * @throws IOException
     */
    public void LaunchSignUpView(MouseEvent mouseEvent) throws IOException {
        ventanaSignUpVista = new VentanaSignUpVista(stageinicio, listaUsuario, CS, LC);
        ventanaSignUpVista.LaunchSignUpView();
        vista.getStageppal().close();
    }

    public void logUsuario(UsuarioDTO user) {
        try {
            File directorio = new File("target/classes/");
            ProcessBuilder pb = new ProcessBuilder("java", "GamerHUB.Shared.util.UserLog");
            pb.directory(directorio);
            Process p = pb.start();

            OutputStream os = p.getOutputStream();

            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(user.getNombre());
            dos.flush();
            int exitVal;
            try {
                exitVal = p.waitFor();
                System.out.println("Valor de Salida: " + String.valueOf(exitVal));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
