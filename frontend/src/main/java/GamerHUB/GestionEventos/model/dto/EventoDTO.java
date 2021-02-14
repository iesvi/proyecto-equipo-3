package GamerHUB.GestionEventos.model.dto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 *
 */
public class EventoDTO {

    private IntegerProperty id;
    private StringProperty nombre;
    private StringProperty descripcion;
    private LocalDate fecha;
    private IntegerProperty usuario;


    public EventoDTO() {
    }

    /**
     *
     * @param id
     * @param nombre
     * @param descripcion
     * @param fecha
     * @param usuario
     */
    public EventoDTO(IntegerProperty id, StringProperty nombre, StringProperty descripcion, LocalDate fecha, IntegerProperty usuario) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis()/10000));
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getUsuario() {
        return usuario.get();
    }

    public IntegerProperty usuarioProperty() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario.set(usuario);
    }

    @Override
    public String toString() {
        return "EventoDTO{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", descripcion=" + descripcion +
                ", fecha=" + fecha +
                ", usuario=" + usuario +
                '}';
    }
}
