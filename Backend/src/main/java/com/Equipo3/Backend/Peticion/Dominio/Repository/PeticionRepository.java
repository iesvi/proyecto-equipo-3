package com.Equipo3.Backend.Peticion.Dominio.Repository;

import com.Equipo3.Backend.Peticion.Dominio.PeticionVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz PeticionRepository la cual extiende de JpaRepository
 */
@Repository
public interface PeticionRepository extends JpaRepository<PeticionVO, Integer> {
}
