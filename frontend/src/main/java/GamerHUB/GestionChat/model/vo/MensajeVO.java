package GamerHUB.GestionChat.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class MensajeVO implements Serializable {

    private int id;
    private  int id_chat;
    private String contenido;
    private Date fecha;

    /**
     *
     * @param id
     * @param id_chat
     * @param contenido
     * @param fecha
     */
    public MensajeVO(int id, int id_chat, String contenido, Date fecha) {
        this.id = id;
        this.id_chat = id_chat;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_chat() {
        return id_chat;
    }

    public void setId_chat(int id_chat) {
        this.id_chat = id_chat;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "MensajeVO{" +
                "id=" + id +
                ", id_chat=" + id_chat +
                ", contenido='" + contenido + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
