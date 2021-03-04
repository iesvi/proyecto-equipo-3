package com.Equipo3.Backend.Chat.Infraestructura;

import com.Equipo3.Backend.Chat.Dominio.ChatVO;
import com.Equipo3.Backend.Chat.Dominio.ChatVOBuilder;
import com.Equipo3.Backend.Shared.Config.ConfigurationMongoTest;
import com.Equipo3.Backend.Shared.Config.ConfigurationPersistenceTest;
import com.Equipo3.Backend.Shared.Config.ConfigurationSpringTest;
import com.Equipo3.Backend.Shared.UnitTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurationPersistenceTest.class, ConfigurationMongoTest.class})
public class ChatInfraUnitTest extends UnitTestCase {

    @PersistenceContext
    EntityManager em;

    @Override
    public void setup() {
        super.setup();
    }

    @Test
    @Transactional
    public void ShouldNewChatTest() {
        //Arrange
        ChatVO chat = createAndSaveNewChat();

        //Assert
        ChatVO chatBd = em.find(ChatVO.class,chat.getId());
        Assert.assertEquals(chat, chatBd);
    }

    @Test
    @Transactional
    public void ShouldEditChatTest() {
        //Arrange
        ChatVO chat = createAndSaveNewChat();

        ChatVO chatEdit = em.find(ChatVO.class,chat.getId());
        chatEdit.setNombre("Chat los chavales");

        //Act
        em.persist(chatEdit);

        em.flush();
        em.clear();

        //Assert
        ChatVO chatBd = em.find(ChatVO.class,chat.getId());

        Assert.assertEquals(chatEdit, chatBd);
    }

    @Test
    @Transactional
    public void ShouldRemoveChat() {
        //Arrange
        ChatVO chatDelete = em.find(ChatVO.class,createAndSaveNewChat().getId());

        //Act
        em.remove(chatDelete);
        em.flush();
        em.clear();

        ChatVO chatBd = em.find(ChatVO.class,chatDelete.getId());

        //Assert
        Assert.assertNull(chatBd);

    }


    private ChatVO createAndSaveNewChat() {
        ChatVO chat = new ChatVOBuilder().build();
        em.persist(chat);
        return chat;
    }
}
