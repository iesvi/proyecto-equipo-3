package GamerHUB.GestionChat.repository.Impl;

import GamerHUB.GestionChat.model.ConversorCanal;
import GamerHUB.GestionChat.model.dto.CanalDTO;
import GamerHUB.GestionChat.model.vo.CanalVO;
import GamerHUB.GestionChat.repository.ChatRepository;
import GamerHUB.Shared.conexion.ClientSocket;
import GamerHUB.Shared.util.ActionDialogs;
import GamerHUB.Shared.util.JsonMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class ChatRepositorySocket implements ChatRepository {

    private static ObjectMapper mapper = new ObjectMapper();
    private ClientSocket CS;

    public ChatRepositorySocket(ClientSocket CS) {
        this.CS = CS;
    }

    @Override
    public boolean add(CanalDTO canalDTO) {
        CanalVO CNVO = ConversorCanal.dtoToVo(canalDTO);
        try {
            if (CS.comprobarConexion()) {
                String Json = JsonMapper.fromJavaToJson(CNVO);
                CS.sendO(Json, "canal");
            } else {
                ActionDialogs.error("Error", "No se ha podido registrar en la base de datos. Se registrará solo en local.");
            }
            return true;
        } catch (IOException er) {
            er.printStackTrace();
            return false;
        }

    }

    @Override
    public ArrayList<CanalVO> retrieveChats() {
        ArrayList<CanalVO> listaChats = new ArrayList<>();
        try {
            if (CS.comprobarConexion()) {
                CS.send("chats");
                Object o = CS.receive();
                ArrayList<CanalVO> listaChat = (ArrayList<CanalVO>) o;
                for (int i = 0; i < listaChat.size(); i++) {
                    CanalVO canal = mapper.convertValue(listaChat.get(i), CanalVO.class);
                    listaChats.add(canal);
                }
            } else {
                ActionDialogs.error("Error", "No hay conexion con la base de datos. Prueba mas tarde.");
                listaChats = null;
            }
        } catch (IOException er) {
            er.printStackTrace();
        }
        return listaChats;
    }
}
