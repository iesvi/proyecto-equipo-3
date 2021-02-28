package com.Equipo3.Backend.Chat.Infraestructura.JPA;


import com.Equipo3.Backend.Chat.Dominio.ChatVO;
import com.Equipo3.Backend.Shared.Infraestructura.JPA.GenericRepositoryJPA;

/**
 * Implementación del repositorio de eventos para Java Persistence Api
 */
public class ChatReporitoryJPA extends GenericRepositoryJPA<ChatVO,Integer> implements ChatRepository {
    public ChatRepositoryJPA() {
        super(ChatVO.class);
    }
}