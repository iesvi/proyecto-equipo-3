package GestionUsuarios.model.dto;

import javafx.beans.property.*;

import java.time.LocalDate;

public class UsuarioDTO {


    private StringProperty usuario;
    private StringProperty email;
    private StringProperty password;
    private ObjectProperty<LocalDate> fecha_nacimiento;



    public UsuarioDTO() {
    }

    public UsuarioDTO(String usuario, String email, String password, LocalDate fecha_nacimiento) {
        this.usuario = new SimpleStringProperty(usuario);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.fecha_nacimiento = new SimpleObjectProperty<LocalDate>(fecha_nacimiento);

    }

    public StringProperty getUsuarioProperty() {
        return usuario;
    }

    public String getUsuario() {
        return usuario.get();
    }

    public StringProperty usuarioProperty() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario.set(usuario);
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

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
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



}
