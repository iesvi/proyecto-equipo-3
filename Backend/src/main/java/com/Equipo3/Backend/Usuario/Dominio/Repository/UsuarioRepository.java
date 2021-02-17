package com.Equipo3.Backend.Usuario.Dominio.Repository;


import com.Equipo3.Backend.Shared.Dominio.Repository.GenericRepository;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz UsuarioRepository la cual extiende de GenericRepository
 */
@Repository
public interface UsuarioRepository extends GenericRepository<UsuarioVO,Integer> {

}
