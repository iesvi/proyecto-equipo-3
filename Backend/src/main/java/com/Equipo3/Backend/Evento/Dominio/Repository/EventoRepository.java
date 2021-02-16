package com.Equipo3.Backend.Evento.Dominio.Repository;

import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Shared.Dominio.Repository.GenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz EventoRepository la cual extiende de GenericRepository
 */
@Repository
public interface EventoRepository extends GenericRepository<EventoVO,Integer> {

}
