package com.Equipo3.Backend.Chat.Aplicacion;

import com.Equipo3.Backend.Chat.Aplicacion.Service.ChatService;
import com.Equipo3.Backend.Chat.Dominio.ChatVO;
import com.Equipo3.Backend.Chat.Dominio.ChatVOBuilder;
import com.Equipo3.Backend.Chat.Dominio.DTO.ChatDTO;
import com.Equipo3.Backend.Chat.Dominio.Mapper.ChatMapper;
import com.Equipo3.Backend.Chat.Dominio.Repository.ChatRepository;
import com.Equipo3.Backend.Shared.Config.ConfigurationMongoTest;
import com.Equipo3.Backend.Shared.Config.ConfigurationPersistenceTest;
import com.Equipo3.Backend.Shared.Config.ConfigurationSpringTest;
import com.Equipo3.Backend.Shared.Err.EntityExist;
import com.Equipo3.Backend.Shared.Err.EntityNotExist;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationPersistenceTest.class, ConfigurationMongoTest.class})
public class ChatIntegraTest {
    @Autowired
    ChatService chatService;

    @Autowired
    ChatRepository chatRepo;

    @Test
    @Transactional
    public void ShouldAddChatNotExistTest() {

        ChatVO newchat = chatService.darDeAltaUnChat(buildChatDto());

        Assert.assertNotNull("Devuelve nuevo Chat", newchat);
    }

    @Test(expected = EntityExist.class)
    @Transactional
    public void ShouldAddChatExist_ThrowExceptionTest() {


        ChatVO Chatyaexistente = chatRepo.save(new ChatVOBuilder().build());

        ChatVO newchat = chatService.darDeAltaUnChat(ChatMapper.toDTO(Chatyaexistente));

    }

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldRemoveChatNotExist_ThrowExceptionTest() {

        ChatVO Chatyaexistente = new ChatVOBuilder().build();

        chatService.eliminarUnChat(Chatyaexistente.getId());
    }

    @Test
    @Transactional
    public void ShouldRemoveChatExistTest() {


        ChatVO Chatyaexistente = chatService.darDeAltaUnChat(ChatMapper.toDTO(new ChatVOBuilder().build()));


        Assert.assertEquals(true, chatService.eliminarUnChat(Chatyaexistente.getId()));

    }

    @Test
    @Transactional
    public void ShouldReturnChatExistTest() {

        ChatVO Chatyaexistente = chatService.darDeAltaUnChat(ChatMapper.toDTO(new ChatVOBuilder().build()));

        ChatVO Chatdevuelto = chatService.consultarChats(Chatyaexistente.getId());

        Assert.assertNotNull(Chatdevuelto);

    }

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldReturnChatNotExist_ThrowExceptionTest() {


        ChatVO Chatyaexistente = new ChatVOBuilder().build();

        ChatVO Chatdevuelto = chatService.consultarChats(Chatyaexistente.getId());

    }

    @Test
    @Transactional
    public void ShouldEditChatExistTest() {

        ChatVO Chatsineditar = chatService.darDeAltaUnChat(ChatMapper.toDTO(new ChatVOBuilder().build()));

        ChatVO Chataeditar = chatService.consultarChats(Chatsineditar.getId());

        Chataeditar.setNombre("Chat de los chavales");

        ChatVO chatdb = chatService.modificarChat(ChatMapper.toDTO(Chataeditar));

        Assert.assertEquals(Chataeditar, chatdb);

    }

    @Test(expected = EntityNotExist.class)
    @Transactional
    public void ShouldEditChatNotExist_ThrowExceptionTest() {


        ChatVO Chatsineditar = new ChatVOBuilder().build();

        ChatVO Chataeditar = Chatsineditar;

        Chataeditar.setNombre("Chat de los chavales");

        ChatVO chatdb = chatService.modificarChat(ChatMapper.toDTO(Chataeditar));


    }

    private ChatDTO buildChatDto() {
        return ChatMapper.toDTO(new ChatVOBuilder().build());
    }

}