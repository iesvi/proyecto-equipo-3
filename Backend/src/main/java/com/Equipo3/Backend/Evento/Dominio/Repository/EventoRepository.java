package com.Equipo3.Backend.Evento.Dominio.Repository;

import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz EventoRepository la cual extiende de GenericRepository
 */
@Repository
public interface EventoRepository extends JpaRepository<EventoVO, Integer> {

}

