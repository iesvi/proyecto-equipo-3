package modelo.vo;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class Canal {

    private IntegerProperty id;
    private StringProperty nombre;
    private ObservableList<Usuario> miembros;
    private ObjectProperty<LocalDate> fechaCreacion;
    private ObjectProperty<File> historialChat;

    public Canal() {
    }

    public Canal(String nombre, ObservableList<Usuario> miembros, LocalDate fechaCreacion, File historialChat) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = new SimpleStringProperty(nombre);
        this.miembros = new SimpleListProperty<Usuario>(miembros);
        this.fechaCreacion = new SimpleObjectProperty<LocalDate>(fechaCreacion);
        this.historialChat = new SimpleObjectProperty<File>(historialChat);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
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

    public ObservableList<Usuario> getMiembros() {
        return miembros;
    }

    public void setMiembros(ObservableList<Usuario> miembros) {
        this.miembros = miembros;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion.get();
    }

    public ObjectProperty<LocalDate> fechaCreacionProperty() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion.set(fechaCreacion);
    }

    public File getHistorialChat() {
        return historialChat.get();
    }

    public ObjectProperty<File> historialChatProperty() {
        return historialChat;
    }

    public void setHistorialChat(File historialChat) {
        this.historialChat.set(historialChat);
    }

    @Override
    public String toString() {
        return "Canal{" +
                "nombre=" + nombre +
                ", miembros=" + miembros +
                ", fechaCreacion=" + fechaCreacion +
                ", historialChat=" + historialChat +
                '}';
    }
}
