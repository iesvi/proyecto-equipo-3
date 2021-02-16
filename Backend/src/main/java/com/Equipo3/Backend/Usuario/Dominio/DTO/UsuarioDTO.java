package com.Equipo3.Backend.Usuario.Dominio.DTO;

import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.Evento;
import com.Equipo3.Backend.Usuario.Dominio.Usuario;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
    private int id;
    private String nombre;
    private String password;
    private String email;
    private Date fecha_nacimiento;
    private int telefono;
    private String rol;
    private List<Integer> idamigos;
    private List<Integer> ideventos;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, String nombre, String password, String email, Date fecha_nacimiento, int telefono, String rol, List<Integer> idamigos, List<Integer> ideventos) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rol = rol;
        this.idamigos = idamigos;
        this.ideventos = ideventos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Integer> getAmigos() {
        return idamigos;
    }

    public void setAmigos(List<Integer> idamigos) {
        this.idamigos = idamigos;
    }

    public List<Integer> getEventos() {
        return ideventos;
    }

    public void setEventos(List<Integer> ideventos) {
        this.ideventos = ideventos;
    }
}
