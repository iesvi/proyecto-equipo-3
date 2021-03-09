package GamerHUB.GestionUsuarios.controller;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.GestionPeticiones.model.dto.PeticionDTO;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.ui.VentanaAdminVista;
import GamerHUB.GestionUsuarios.ui.VentanaGestionUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    private TableView<EventoDTO> eventos;
    @FXML
    private TableColumn<EventoDTO, String> colEvento;
    @FXML
    private TableView<PeticionDTO> peticiones;
    @FXML
    private TableColumn<PeticionDTO, String> colPeticion;
    @FXML
    private TableView<UsuarioDTO> usuarios;
    @FXML
    private TableColumn<UsuarioDTO, String> colUsuario;
    @FXML
    private Button btnEditarUser, btnEliminarUser, btnGestionarEventos, btnGestionarChats, btnGestionarFTP, btnGestionarUsuarios, btnGestionarPeticiones, btnVolver;


    private VentanaAdminVista ventanaAdminVista;
    private Stage dialogStage;

    public void setVentanaAdminVista(VentanaAdminVista ventanaAdminVista, Stage dialogStage) {
        this.ventanaAdminVista = ventanaAdminVista;
        this.dialogStage = dialogStage;
    }

    public AdminController(){

    }

    @FXML
    public void LaunchVistaGestionUsers() throws IOException {
        //VentanaGestionUser ventanaGestionUser = new VentanaGestionUser(dialogStage);
        //ventanaAdminVista.LaunchVistaGestionUsers(dialogStage);
    }


    public void gestionarEventos(){

    }



    public void volver() throws IOException {
        VentanaAdminVista ventanaAdminVista = new VentanaAdminVista(dialogStage);
        ventanaAdminVista.LaunchVistaAdmin(dialogStage);
    }

}
