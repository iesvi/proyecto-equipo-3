package GamerHUB.GestionUsuarios.repository;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.Shared.controllers.VistaHomeControlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class ListaUsuario {

    private ObservableList<UsuarioDTO> users = FXCollections.observableArrayList();

    private VistaHomeControlador vistaHomeControlador;

    private UsuarioDTO usuarioLogeado;

    public ListaUsuario() {


        LocalDate localDate = LocalDate.now();
        //Usuario normal
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "user",
                "user",
                "email",
                localDate,
                0
        );
        UsuarioDTO admin = new UsuarioDTO(
                "admin",
                "admin",
                "email",
                localDate,
                0,
                "admin"
        );

        users.add(usuarioDTO);
        users.add(admin);
    }

    public ObservableList<UsuarioDTO> getUsers() {
        return users;
    }

    public UsuarioDTO getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado() {
        this.usuarioLogeado = vistaHomeControlador.getUsuarioLogeado();
    }

}
