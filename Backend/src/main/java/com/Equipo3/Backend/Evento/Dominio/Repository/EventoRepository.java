package com.Equipo3.Backend.Evento.Dominio.Repository;

import com.Equipo3.Backend.Evento.Dominio.Evento;
import com.Equipo3.Backend.Shared.Dominio.Repository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends GenericRepository<Evento,Integer> {

}
