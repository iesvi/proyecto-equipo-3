package com.Equipo3.Backend.Chat.Infraestructura.JPA;


import com.Equipo3.Backend.Chat.Dominio.ChatVO;
import com.Equipo3.Backend.Chat.Dominio.Repository.ChatRepository;
import com.Equipo3.Backend.Shared.Infraestructura.JPA.GenericRepositoryJPA;
import org.springframework.stereotype.Repository;

/**
 * Implementación del repositorio de eventos para Java Persistence Api
 */
@Repository
public class ChatReporitoryJPA extends GenericRepositoryJPA<ChatVO,Integer> implements ChatRepository {
    public ChatRepositoryJPA() {
        super(ChatVO.class);
    }
}