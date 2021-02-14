package com.Equipo3.Backend.Evento.Dominio.Repository;

import com.Equipo3.Backend.Evento.Dominio.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
