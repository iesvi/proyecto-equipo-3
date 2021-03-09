package GamerHUB.GestionChat.repository;

import GamerHUB.GestionChat.model.ConversorCanal;
import GamerHUB.GestionChat.model.dto.CanalDTO;
import GamerHUB.GestionChat.model.vo.CanalVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 *
 */
public class ListaChat {

    private ObservableList<CanalDTO> canales = FXCollections.observableArrayList();

    public ListaChat() {

        ObservableList<Integer> miembros = FXCollections.observableArrayList();
        CanalDTO canalDTO = new CanalDTO("CANAL", 12345);

        canales.add(canalDTO);

    }

    public ListaChat(ObservableList<CanalDTO> lista) {
        this.canales = lista;
    }

    public ObservableList<CanalDTO> getCanales() {
        return canales;
    }

    public void setlistaChat(ArrayList<CanalVO> lista) {
        if (lista != null) {
            canales = FXCollections.observableArrayList();
            ArrayList<CanalVO> listaVO = lista;
            for (int i = 0; i < listaVO.size(); i++) {
                CanalDTO n = ConversorCanal.voToDto(listaVO.get(i));
                canales.add(n);
            }
        }
    }
}
