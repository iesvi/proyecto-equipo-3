package GamerHUB.GestionEventos.model.dto;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Tipo DTO de la entidad Evento. Es el tipo de dato que maneja la aplicación desde el front.
 */
public class EventoDTO {

    private IntegerProperty id;
    private StringProperty nombre;
    private StringProperty descripcion;
    private ObjectProperty<LocalDate> fechaini;
    private ObjectProperty<LocalDate> fechaf;
    private IntegerProperty usuario;


    public EventoDTO() {
    }

    /**
     * @param nombre
     * @param descripcion
     * @param fechaini
     * @param fechaf
     * @param usuario
     */
    public EventoDTO(StringProperty nombre, StringProperty descripcion, ObjectProperty<LocalDate> fechaini, ObjectProperty<LocalDate> fechaf, IntegerProperty usuario) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaini = fechaini;
        this.fechaf = fechaf;
        this.usuario = usuario;
    }

    public EventoDTO(String nombre, String descripcion, LocalDate fechaini, LocalDate fechaf, Integer usuario) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = new SimpleStringProperty(nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.fechaini = new SimpleObjectProperty<LocalDate>(fechaini);
        this.fechaf = new SimpleObjectProperty<LocalDate>(fechaf);
        this.usuario = new SimpleIntegerProperty(usuario);
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

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    public LocalDate getFechaini() {
        return fechaini.get();
    }

    public void setFechaini(LocalDate fechaini) {
        this.fechaini.set(fechaini);
    }

    public ObjectProperty<LocalDate> fechainiProperty() {
        return fechaini;
    }

    public LocalDate getFechaf() {
        return fechaf.get();
    }

    public void setFechaf(LocalDate fechaf) {
        this.fechaf.set(fechaf);
    }

    public ObjectProperty<LocalDate> fechafProperty() {
        return fechaf;
    }

    public int getUsuario() {
        return usuario.get();
    }

    public void setUsuario(int usuario) {
        this.usuario.set(usuario);
    }

    public IntegerProperty usuarioProperty() {
        return usuario;
    }

    @Override
    public String toString() {
        return "EventoDTO{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", descripcion=" + descripcion +
                ", fechaini=" + fechaini +
                ", fechaf=" + fechaf +
                ", usuario=" + usuario +
                '}';
    }
}
