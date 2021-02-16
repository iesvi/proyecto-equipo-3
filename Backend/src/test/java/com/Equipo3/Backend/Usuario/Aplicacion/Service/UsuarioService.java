package com.Equipo3.Backend.Usuario.Aplicacion.Service;

import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import com.Equipo3.Backend.Usuario.Dominio.Repository.UsuarioRepository;
import com.Equipo3.Backend.Usuario.Dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepo;

    public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Transactional
    public Usuario Registro_De_Usuario(UsuarioDTO usuariodto) {

        //Crear Usuario-entity desde UsuarioDTO (por ahora lo creamos manualmente)
        Usuario user = new Usuario(usuariodto.getId(), usuariodto.getNombre(), usuariodto.getPassword(), usuariodto.getEmail(), usuariodto.getFecha_nacimiento(), usuariodto.getTelefono(), usuariodto.getRol(), usuariodto.getAmigos(), usuariodto.getEventos());
        return usuarioRepo.save(user);
    }

    public Usuario ConsultarPerfilUsuario(int id) {
        return usuarioRepo.findOne(id);
    }

    @Transactional
    public void Modificar_Usuario(UsuarioDTO usuariodto) throws Exception {
        Usuario nbd = usuarioRepo.findOne(usuariodto.getId());
        if (nbd == null)
            throw new Exception("Usuario no existe");
        Usuario user = new Usuario(nbd.getId(), nbd.getNombre(), nbd.getPassword(), nbd.getEmail(), nbd.getFecha_nacimiento(), nbd.getTelefono(), nbd.getRol(), nbd.getAmigos(), nbd.getEventos());
        usuarioRepo.save(user);
    }

    @Transactional
    public void Eliminar_Usuario(UsuarioDTO usuariodto) throws Exception {
        Usuario nbd = usuarioRepo.findOne(usuariodto.getId());
        if (nbd == null)
            throw new Exception("Usuario no existe");
        usuarioRepo.delete(nbd);
    }
}
