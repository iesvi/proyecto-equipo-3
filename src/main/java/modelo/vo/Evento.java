package modelo.vo;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Evento {

    private IntegerProperty id;
    private StringProperty nombre;
    private StringProperty descripcion;
    private ObjectProperty<Usuario> usuario;
    private ObjectProperty<LocalDate> fecha_inicio;
    private ObjectProperty<LocalDate> fecha_fin;

    public Evento() {

    }

    public Evento(String nombre, String descripcion, Usuario usuario,
                  LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = new SimpleStringProperty(nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.usuario = new SimpleObjectProperty<Usuario>(usuario);
        this.fecha_inicio = new SimpleObjectProperty<LocalDate>(fecha_inicio);
        this.fecha_fin = new SimpleObjectProperty<LocalDate>(fecha_fin);
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

    public Usuario getUsuario() {
        return usuario.get();
    }

    public ObjectProperty<Usuario> usuarioProperty() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario.set(usuario);
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio.get();
    }

    public ObjectProperty<LocalDate> fecha_inicioProperty() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio.set(fecha_inicio);
    }

    public LocalDate getFecha_fin() {
        return fecha_fin.get();
    }

    public ObjectProperty<LocalDate> fecha_finProperty() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin.set(fecha_fin);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", descripcion=" + descripcion +
                ", usuario=" + usuario +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                '}';
    }
}
