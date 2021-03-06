package GamerHUB.GestionUsuarios.repository;

import GamerHUB.GestionUsuarios.model.Conversor;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.Shared.controllers.VistaHomeControlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaUsuario {

    private ObservableList<UsuarioDTO> users = FXCollections.observableArrayList();

    private ArrayList<UsuarioVO> listaUsusarios;

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

    public void AddUsuario(UsuarioDTO user){
        users.add(user);
    }

    public UsuarioDTO getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado() {
        this.usuarioLogeado = vistaHomeControlador.getUsuarioLogeado();
    }

    public void setlistaUsuarios(ArrayList<UsuarioVO> lista){
            if(lista != null){
            ArrayList<UsuarioVO> listaVO = lista;
            for (int i = 0; i < listaVO.size(); i++) {
                UsuarioDTO n = Conversor.voToDto(listaVO.get(i));
                users.add(n);
            }}
    }

}
