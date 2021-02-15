package com.Equipo3.Backend.Evento.Aplicacion.Service;

import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.Evento;
import com.Equipo3.Backend.Evento.Dominio.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EventoService {
    @Autowired
    EventoRepository eventoRepo;

    public void setUsuarioRepo(EventoRepository eventoRepo) {
        this.eventoRepo = eventoRepo;
    }

    @Transactional
    public Evento darDeAltaUnEvento(EventoDTO eventodto) {

        //Crear Evento-entity desde EventoDTO (por ahora lo creamos manualmente)
        Evento event = new Evento(eventodto.getId(), eventodto.getNombre(), eventodto.getFecha(), eventodto.getUsuario(), eventodto.getDescripcion());
        return eventoRepo.save(event);
    }

    public void eliminarUnEvento(EventoDTO eventodto) throws Exception {
        Evento nbd = eventoRepo.findOne(eventodto.getId());
        if (nbd == null)
            throw new Exception("Evento no existe");

        //Borra el evento si está en la base de datos
        eventoRepo.delete(nbd);
    }

    public Evento consultarEventos(int id) {
        return eventoRepo.findOne(id);
    }

    @Transactional
    public void modificarEvento(EventoDTO eventodto) throws Exception {

        Evento nbd = eventoRepo.findOne(eventodto.getId());
        if (nbd == null)
            throw new Exception("Evento no existe");

        //Crear Evento-entity desde EventoDTO (por ahora lo creamos manualmente)
        Evento event = new Evento(eventodto.getId(), eventodto.getNombre(), eventodto.getFecha(), eventodto.getUsuario(), eventodto.getDescripcion());
        eventoRepo.save(event);
    }
}
