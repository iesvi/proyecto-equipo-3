package com.Equipo3.Backend.Chat.Dominio.Repository;

import com.Equipo3.Backend.Chat.Dominio.ChatVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase interfaz ChatRepository la cual extiende de GenericRepository
 */
@Repository
public interface ChatRepository extends JpaRepository<ChatVO, Integer> {

}