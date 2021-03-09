package GamerHUB.GestionChat.model.dto;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 *
 */
public class MensajeDTO {


    private IntegerProperty id;
    private IntegerProperty id_chat;
    private StringProperty contenido;
    private ObjectProperty<LocalDate> fecha;

    /**
     * @param id_chat
     * @param contenido
     * @param fecha
     */
    public MensajeDTO(int id_chat, String contenido, LocalDate fecha) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        ;
        this.id_chat = new SimpleIntegerProperty(id_chat);
        this.contenido = new SimpleStringProperty(contenido);
        this.fecha = new SimpleObjectProperty<LocalDate>(fecha);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public int getId_chat() {
        return id_chat.get();
    }

    public void setId_chat(int id_chat) {
        this.id_chat.set(id_chat);
    }

    public IntegerProperty id_chatProperty() {
        return id_chat;
    }

    public String getContenido() {
        return contenido.get();
    }

    public void setContenido(String contenido) {
        this.contenido.set(contenido);
    }

    public StringProperty contenidoProperty() {
        return contenido;
    }

    public LocalDate getFecha() {
        return fecha.get();
    }

    public void setFecha(LocalDate fecha) {
        this.fecha.set(fecha);
    }

    public ObjectProperty<LocalDate> fechaProperty() {
        return fecha;
    }

    @Override
    public String toString() {
        return "MensajeDTO{" +
                "id=" + id +
                ", id_chat=" + id_chat +
                ", contenido=" + contenido +
                ", fecha=" + fecha +
                '}';
    }
}
