package com.Equipo3.Backend.Usuario.Aplicacion.Service;

import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import com.Equipo3.Backend.Usuario.Dominio.Repository.UsuarioRepository;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepo;

    public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Transactional
    public UsuarioVO Registro_De_Usuario(UsuarioDTO usuariodto) {

        //Crear Usuario-entity desde UsuarioDTO (por ahora lo creamos manualmente)
        UsuarioVO user = new UsuarioVO(usuariodto.getId(), usuariodto.getNombre(), usuariodto.getPassword(), usuariodto.getEmail(), usuariodto.getFecha_nacimiento(), usuariodto.getTelefono(), usuariodto.getRol(), usuariodto.getIdamigos(), usuariodto.getIdeventos());
        return usuarioRepo.save(user);
    }

    public UsuarioVO ConsultarPerfilUsuario(int id) {
        return usuarioRepo.findOne(id);
    }

    @Transactional
    public void Modificar_Usuario(UsuarioDTO usuariodto) throws Exception {
        UsuarioVO nbd = usuarioRepo.findOne(usuariodto.getId());
        if (nbd == null)
            throw new Exception("Usuario no existe");
        UsuarioVO user = new UsuarioVO(nbd.getId(), nbd.getNombre(), nbd.getPassword(), nbd.getEmail(), nbd.getFecha_nacimiento(), nbd.getTelefono(), nbd.getRol(), nbd.getIdamigos(), nbd.getIdeventos());
        usuarioRepo.save(user);
    }

    @Transactional
    public void Eliminar_Usuario(UsuarioDTO usuariodto) throws Exception {
        UsuarioVO nbd = usuarioRepo.findOne(usuariodto.getId());
        if (nbd == null)
            throw new Exception("Usuario no existe");
        usuarioRepo.delete(nbd);
    }
}
