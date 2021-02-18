package com.Equipo3.Backend.Evento.Aplicacion.Service;

import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Evento.Dominio.Repository.EventoRepository;
import com.Equipo3.Backend.Shared.Err.EntityExist;
import com.Equipo3.Backend.Shared.Err.EntityNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Casos de uso de la entidad evento
 */
@Service
public class EventoService {

    /**
     * eventoRepo tipo EventoRepository
     */
    @Autowired
    EventoRepository eventoRepo;


    /**
     * Método para dar de alta un nuevo evento. Tambien se convierte un EventoDTO a EventoVO
     * @param eventodto
     * @return eventoRepo.save(event)
     */
    @Transactional
    public EventoVO darDeAltaUnEvento(EventoDTO eventodto) {

        EventoVO event = eventoRepo.findOne(eventodto.getId());
        if (event!=null)
            throw new EntityExist(EventoVO.class.toString(),event.getId());


        event = new EventoVO(eventodto.getId(), eventodto.getNombre(), eventodto.getFecha(), eventodto.getIdusuario(), eventodto.getDescripcion());
        return eventoRepo.save(event);
    }

    /**
     * Método para eliminar un evento
     * @param id
     */
    @Transactional
    public boolean eliminarUnEvento(int id){
        EventoVO event = eventoRepo.findOne(id);
        if (event == null)
            throw new EntityNotExist(EventoVO.class.toString(),id);

        //Borra el evento si está en la base de datos
        return eventoRepo.delete(event);
    }

    /**
     * Método para consultar un evento en función a la id que se le pase
     * @param id
     * @return eventoRepo.findOne(id)
     */
    @Transactional
    public EventoVO consultarEventos(int id) {
        EventoVO event = eventoRepo.findOne(id);
        if (event == null)
            throw new EntityNotExist(EventoVO.class.toString(),id);

        return eventoRepo.findOne(id);
    }

    /**
     * Método para modificar un evento en función a la id que se le pase. Si no existe se genera una excepción. Tambien se convierte un EventoDTO a EventoVO
     * @param eventodto
     */
    @Transactional
    public EventoVO modificarEvento(EventoDTO eventodto) {

        EventoVO newevent = eventoRepo.findOne(eventodto.getId());
        if (newevent == null)
            throw new EntityNotExist(EventoVO.class.toString(),eventodto.getId());

        EventoVO event = new EventoVO(eventodto.getId(), eventodto.getNombre(), eventodto.getFecha(), eventodto.getIdusuario(), eventodto.getDescripcion());
        return eventoRepo.save(event);
    }
}
