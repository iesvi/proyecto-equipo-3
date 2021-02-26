package GamerHUB.GestionUsuarios.model.dto;

import GamerHUB.GestionEventos.model.dto.EventoDTO;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 *
 */
public class UsuarioDTO {

    private IntegerProperty id;
    private StringProperty nombre;
    private StringProperty password;
    private StringProperty email;
    private ObjectProperty<LocalDate> fecha_nacimiento;
    private IntegerProperty telefono;
    private StringProperty rol;
    private ObservableList<UsuarioDTO> amigos = FXCollections.observableArrayList();
    private ObservableList<UsuarioDTO> amigosde = FXCollections.observableArrayList();
    private ObservableList<EventoDTO> eventos = FXCollections.observableArrayList();

    public UsuarioDTO() {
    }

    public UsuarioDTO(StringProperty nombre, StringProperty password, StringProperty email, ObjectProperty<LocalDate> fecha_nacimiento, IntegerProperty telefono, StringProperty rol) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rol = rol;
    }


    public UsuarioDTO(String nombre, String password, String email, LocalDate fecha_nacimiento, int telefono) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = new SimpleStringProperty(nombre);
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);
        this.fecha_nacimiento = new SimpleObjectProperty<LocalDate>(fecha_nacimiento);
        this.telefono = new SimpleIntegerProperty(telefono);
    }

    public UsuarioDTO(String nombre, String password, String email, LocalDate fecha_nacimiento, int telefono, String rol) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = new SimpleStringProperty(nombre);
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);
        this.fecha_nacimiento = new SimpleObjectProperty<LocalDate>(fecha_nacimiento);
        this.telefono = new SimpleIntegerProperty(telefono);
        this.rol = new SimpleStringProperty(rol);
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

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento.get();
    }

    public ObjectProperty<LocalDate> fecha_nacimientoProperty() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento.set(fecha_nacimiento);
    }

    public int getTelefono() {
        return telefono.get();
    }

    public IntegerProperty telefonoProperty() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono.set(telefono);
    }

    public String getRol() {
        return rol.get();
    }

    public StringProperty rolProperty() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol.set(rol);
    }

    public ObservableList<UsuarioDTO> getAmigos() {
        return amigos;
    }

    public void setAmigos(ObservableList<UsuarioDTO> amigos) {
        this.amigos = amigos;
    }

    public ObservableList<UsuarioDTO> getAmigosDe() {
        return amigosde;
    }

    public void setAmigosDe(ObservableList<UsuarioDTO> amigosde) {
        this.amigosde = amigosde;
    }

    public ObservableList<EventoDTO> getEventos() {
        return eventos;
    }

    public void setEventos(ObservableList<EventoDTO> eventos) {
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                "\n, nombre=" + nombre +
                "\n, password=" + password +
                "\n, email=" + email +
                "\n, fecha_nacimiento=" + fecha_nacimiento +
                "\n, telefono=" + telefono +
                "\n, rol=" + rol +
                "\n, amigos=" + amigos +
                '}';
    }
}
