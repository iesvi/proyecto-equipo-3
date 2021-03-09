package com.Equipo3.Backend.Evento.Aplicacion.Service;

import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Evento.Dominio.Mapper.EventoMapper;
import com.Equipo3.Backend.Evento.Dominio.Repository.EventoRepository;
import com.Equipo3.Backend.Shared.Err.EntityExist;
import com.Equipo3.Backend.Shared.Err.EntityNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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

            Optional<EventoVO> nbd = eventoRepo.findById(eventodto.getId());
        if (nbd.isPresent())
            throw new EntityExist(EventoVO.class.toString(),eventodto.getId());

        EventoVO event = EventoMapper.fromDTO(eventodto);
        return eventoRepo.save(event);
    }

    /**
     * Método para eliminar un evento
     * @param id
     */
    @Transactional
    public boolean eliminarUnEvento(int id){
        Optional<EventoVO> nbd = eventoRepo.findById(id);
        if (!nbd.isPresent())
            throw new EntityNotExist(EventoVO.class.toString(),id);

        //Borra el evento si está en la base de datos
         eventoRepo.deleteById(id);
         return true;
    }

    /**
     * Método para consultar un evento en función a la id que se le pase
     * @param id
     * @return eventoRepo.findOne(id)
     */
    @Transactional
    public Optional<EventoVO> consultarEventos(int id) {
        Optional<EventoVO> nbd = eventoRepo.findById(id);
        if (!nbd.isPresent()) {
            throw new EntityNotExist(EventoVO.class.toString(), id);
        }
        return nbd;
    }

    /**
     * * Método para modificar un evento en función a la id que se le pase. Si no existe se genera una excepción. Tambien se convierte un EventoDTO a EventoVO
     *
     * @param eventodto
     * @return
     */
    @Transactional
    public EventoVO modificarEvento(EventoDTO eventodto) {

        Optional<EventoVO> nbd = eventoRepo.findById(eventodto.getId());
        if (!nbd.isPresent()) {
            throw new EntityNotExist(EventoVO.class.toString(), eventodto.getId());
        }
        EventoVO udpevento = EventoMapper.fromDTO(eventodto);
        return eventoRepo.save(udpevento);
    }
}
