package GamerHUB.GestionEventos.repository;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 *
 */
public class ListaEvento {

    private ObservableList<EventoDTO> events = FXCollections.observableArrayList();


    public ListaEvento() {
        LocalDate localDate = LocalDate.now();
        EventoDTO eventoDTO = new EventoDTO(
                "evento1",
                "desc",
                localDate,
                localDate,
                11
        );
        events.add(eventoDTO);
    }

    public ListaEvento(ObservableList<EventoDTO> lista) {
        this.events = lista;
    }

    public ObservableList<EventoDTO> getEvents() {
        return events;
    }

}
