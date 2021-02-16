package com.Equipo3.Backend.Evento.Aplicacion.Service;

import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Evento.Dominio.Repository.EventoRepository;
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
     * Metodo que instancia en atributo eventoRepo
     * @param eventoRepo
     */
    public void setUsuarioRepo(EventoRepository eventoRepo) {
        this.eventoRepo = eventoRepo;
    }


    /**
     * Método para dar de alta un nuevo evento. Tambien se convierte un EventoDTO a EventoVO
     * @param eventodto
     * @return eventoRepo.save(event)
     */
    @Transactional
    public EventoVO darDeAltaUnEvento(EventoDTO eventodto) {

        //Crear Evento-entity desde EventoDTO (por ahora lo creamos manualmente)
        EventoVO event = new EventoVO(eventodto.getId(), eventodto.getNombre(), eventodto.getFecha(), eventodto.getIdusuario(), eventodto.getDescripcion());
        return eventoRepo.save(event);
    }

    /**
     * Método para eliminar un evento
     * @param eventodto
     * @throws Exception
     */
    public void eliminarUnEvento(EventoDTO eventodto) throws Exception {
        EventoVO nbd = eventoRepo.findOne(eventodto.getId());
        if (nbd == null)
            throw new Exception("Evento no existe");

        //Borra el evento si está en la base de datos
        eventoRepo.delete(nbd);
    }

    /**
     * Método para consultar un evento en función a la id que se le pase
     * @param id
     * @return eventoRepo.findOne(id)
     */
    public EventoVO consultarEventos(int id) {
        return eventoRepo.findOne(id);
    }

    /**
     * Método para modificar un evento en función a la id que se le pase. Si no existe se genera una excepción. Tambien se convierte un EventoDTO a EventoVO
     * @param eventodto
     * @throws Exception
     */
    @Transactional
    public void modificarEvento(EventoDTO eventodto) throws Exception {

        EventoVO nbd = eventoRepo.findOne(eventodto.getId());
        if (nbd == null)
            throw new Exception("Evento no existe");

        //Crear Evento-entity desde EventoDTO (por ahora lo creamos manualmente)
        EventoVO event = new EventoVO(eventodto.getId(), eventodto.getNombre(), eventodto.getFecha(), eventodto.getIdusuario(), eventodto.getDescripcion());
        eventoRepo.save(event);
    }
}
