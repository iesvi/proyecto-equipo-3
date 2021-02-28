package com.Equipo3.Backend.Chat.Dominio.Repository;

import com.Equipo3.Backend.Shared.Dominio.Repository.GenericRepository;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;

/**
 * Clase interfaz ChatRepository la cual extiende de GenericRepository
 */
public interface ChatRepository extends GenericRepository<UsuarioVO, Integer> {

}