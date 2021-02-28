package com.Equipo3.Backend.Usuario.Dominio.Repository;


import com.Equipo3.Backend.Shared.Dominio.Repository.GenericRepository;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
/**
 * Clase interfaz UsuarioRepository la cual extiende de GenericRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioVO,Integer> {

}
