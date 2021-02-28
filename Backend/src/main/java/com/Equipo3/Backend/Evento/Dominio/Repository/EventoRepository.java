package com.Equipo3.Backend.Evento.Dominio.Repository;

import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Shared.Dominio.Repository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
/**
 * Clase interfaz EventoRepository la cual extiende de GenericRepository
 */
public interface EventoRepository extends JpaRepository<EventoVO,Integer> {

}

