package com.Equipo3.Backend.Peticion.Aplicacion;

import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Evento.Dominio.Mapper.EventoMapper;
import com.Equipo3.Backend.Evento.Dominio.Repository.EventoRepository;
import com.Equipo3.Backend.Peticion.Dominio.DTO.PeticionDTO;
import com.Equipo3.Backend.Peticion.Dominio.Mapper.PeticionMapper;
import com.Equipo3.Backend.Peticion.Dominio.PeticionVO;
import com.Equipo3.Backend.Peticion.Dominio.Repository.PeticionRepository;
import com.Equipo3.Backend.Shared.Err.EntityExist;
import com.Equipo3.Backend.Shared.Err.EntityNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PeticionService {
    /**
     * peticionRepo tipo PeticionRepository
     */
    @Autowired
    PeticionRepository peticionRepo;


    /**
     * Método para dar de alta una nueva peticion. Tambien se convierte una PeticionDTO a PeticionVO
     * @param peticiondto
     * @return eticionRepo.save(peticion)
     */
    @Transactional
    public PeticionVO darDeAltaUnaPeticion(PeticionDTO peticiondto) {

        Optional<PeticionVO> nbd = peticionRepo.findById(peticiondto.getId());
        if (nbd.isPresent())
            throw new EntityExist(PeticionVO.class.toString(),peticiondto.getId());

        PeticionVO peticion = PeticionMapper.fromDTO(peticiondto);
        return peticionRepo.save(peticion);
    }

//    /**
//     * Método para eliminar un evento
//     * @param id
//     */
//    @Transactional
//    public boolean eliminarUnapeticion(int id){
//        Optional<EventoVO> nbd = eventoRepo.findById(id);
//        if (!nbd.isPresent())
//            throw new EntityNotExist(EventoVO.class.toString(),id);
//
//        //Borra el evento si está en la base de datos
//        eventoRepo.deleteById(id);
//        return true;
//    }
//
//    /**
//     * Método para consultar un evento en función a la id que se le pase
//     * @param id
//     * @return eventoRepo.findOne(id)
//     */
//    @Transactional
//    public EventoVO consultarEventos(int id) {
//        Optional<EventoVO> nbd = eventoRepo.findById(id);
//        if (!nbd.isPresent()) {
//            throw new EntityNotExist(EventoVO.class.toString(), id);
//        }
//        return eventoRepo.findById(id).get();
//    }
//
//    /**
//     * * Método para modificar un evento en función a la id que se le pase. Si no existe se genera una excepción. Tambien se convierte un EventoDTO a EventoVO
//     *
//     * @param eventodto
//     * @return
//     */
//    @Transactional
//    public EventoVO modificarEvento(EventoDTO eventodto) {
//
//        Optional<EventoVO> nbd = eventoRepo.findById(eventodto.getId());
//        if (!nbd.isPresent()) {
//            throw new EntityNotExist(EventoVO.class.toString(), eventodto.getId());
//        }
//        EventoVO udpevento = EventoMapper.fromDTO(eventodto);
//        return eventoRepo.save(udpevento);
//    }
}
