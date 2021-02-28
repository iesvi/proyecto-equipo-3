package com.Equipo3.Backend.Chat.Aplicacion.Service;

import com.Equipo3.Backend.Chat.Dominio.ChatVO;
import com.Equipo3.Backend.Chat.Dominio.DTO.ChatDTO;
import com.Equipo3.Backend.Chat.Dominio.Repository.ChatRepository;
import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Evento.Dominio.Mapper.EventoMapper;
import com.Equipo3.Backend.Shared.Err.EntityExist;
import com.Equipo3.Backend.Shared.Err.EntityNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Casos de uso de la entidad chat
 */
@Service
public class ChatService {
    /**
     * chatRepo tipo ChatRepository
     */
    @Autowired
    ChatRepository chatRepo;


    /**
     * Método para dar de alta un nuevo chat. Tambien se convierte un ChatDTO a ChatVO
     * @param chatdto
     * @return chatRepo.save(chat)
     */
    @Transactional
    public ChatVO darDeAltaUnChat(ChatDTO chatdto) {

        Optional<ChatVO> nbd = chatRepo.findById(chatdto.getId());
        if (nbd.isPresent())
            throw new EntityExist(ChatVO.class.toString(),chatdto.getId());

        ChatVO chat = new ChatVO(eventodto.getId(), eventodto.getNombre(), eventodto.getFecha(), eventodto.getIdusuario(), eventodto.getDescripcion());
        return chatRepo.save(chat);
    }

    /**
     * Método para eliminar un evento
     * @param id
     */
    @Transactional
    public boolean eliminarUnEvento(int id){
        Optional<EventoVO> nbd = eventoRepo.findById(id);
        if (nbd.isPresent())
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
    public EventoVO consultarEventos(int id) {
        return eventoRepo.findById(id).get();
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
        if (nbd.isPresent()) {
            throw new EntityNotExist(EventoVO.class.toString(), eventodto.getId());
        }
        EventoVO udpevento = EventoMapper.fromDTO(eventodto);
        return eventoRepo.save(udpevento);
    }
}