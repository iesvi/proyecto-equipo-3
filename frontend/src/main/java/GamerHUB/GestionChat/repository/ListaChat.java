package GamerHUB.GestionChat.repository;

import GamerHUB.GestionChat.model.dto.CanalDTO;
import GamerHUB.GestionEventos.model.dto.EventoDTO;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 */
public class ListaChat {

    private ObservableList<CanalDTO> canales = FXCollections.observableArrayList();

    public ListaChat(){

        ObservableList<Integer> miembros =FXCollections.observableArrayList();
        CanalDTO canalDTO = new CanalDTO("CANAL", 12345,
                miembros);

        canales.add(canalDTO);

    }

    public ListaChat(ObservableList<CanalDTO> lista){
        this.canales = lista;
    }

    public ObservableList<CanalDTO> getCanales() {
        return canales;
    }
}
