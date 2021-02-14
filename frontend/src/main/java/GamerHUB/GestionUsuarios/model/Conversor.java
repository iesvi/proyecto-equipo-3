package GamerHUB.GestionUsuarios.model;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import javafx.collections.FXCollections;

public class Conversor {

    public Conversor(){}


    public UsuarioDTO voToDto(UsuarioVO usuarioVO){

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuarioVO.getId());
        usuarioDTO.setNombre(usuarioVO.getNombre());
        usuarioDTO.setPassword(usuarioVO.getPassword());
        usuarioDTO.setEmail(usuarioVO.getEmail());
        usuarioDTO.setTelefono(usuarioVO.getTelefono());
        usuarioDTO.setFecha_nacimiento(usuarioVO.getFecha_nacimiento().toLocalDate());
        //usuarioDTO.setAmigos(FXCollections.observableArrayList(usuarioVO.getAmigos()));


       return usuarioDTO;
    }



}
