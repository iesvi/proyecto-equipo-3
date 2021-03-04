package GamerHUB.GestionUsuarios.controller;

import GamerHUB.GestionEventos.repository.ListaEvento;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.repository.ListaUsuario;
import GamerHUB.GestionUsuarios.ui.VentanaPerfilVista;
import GamerHUB.Shared.view.VentanaHomeVista;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


/**
 *
 */
public class VistaPerfilControlador {
    private VentanaPerfilVista vista;
    private UsuarioDTO userLogeado;
    private Stage dialogStage;
    private ListaUsuario listaUsuario;
    private VentanaHomeVista ventanaHomeVista;

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

    public void setcampos(){
        if(userLogeado != null) {
            campoNombre.setText(userLogeado.getNombre());
            campoEmail.setText(userLogeado.getEmail());
            campoTelefono.setText(String.valueOf(userLogeado.getTelefono()));
            fechaNac.setValue(userLogeado.getFecha_nacimiento());
        }
    }

    @FXML
    public void volver() throws IOException {
        ventanaHomeVista.loadHomeView1(dialogStage);
    }


    public void setVentanahome(VentanaHomeVista ventanaHomeVista) {
        this.ventanaHomeVista = ventanaHomeVista;
    }

    public void setVista(VentanaPerfilVista vista, Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.vista = vista;
    }

    public void setUserLogeado(UsuarioDTO userLogeado) {
        this.userLogeado = userLogeado;
    }

}
