package com.Equipo3.Backend.Usuario.Infraestructura.JPA;


import com.Equipo3.Backend.Shared.Infraestructura.JPA.GenericRepositoryJPA;
import com.Equipo3.Backend.Usuario.Dominio.Repository.UsuarioRepository;
import com.Equipo3.Backend.Usuario.Dominio.Usuario;

public class UsuarioRepositoryJPA extends GenericRepositoryJPA<Usuario,Integer> implements UsuarioRepository {
    public UsuarioRepositoryJPA() {
        super(Usuario.class);
    }

}
