package com.Equipo3.Backend.Usuario.Infraestructura.JPA;

import com.Equipo3.Backend.Shared.Infraestructura.JPA.GenericRepositoryJPA;
import com.Equipo3.Backend.Usuario.Dominio.Repository.UsuarioRepository;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;

/**
 * Implementación del repositorio de usuarios para Java Persistence Api
 */
public class UsuarioRepositoryJPA extends GenericRepositoryJPA<UsuarioVO,Integer> implements UsuarioRepository {
    public UsuarioRepositoryJPA() {
        super(UsuarioVO.class);
    }
}
