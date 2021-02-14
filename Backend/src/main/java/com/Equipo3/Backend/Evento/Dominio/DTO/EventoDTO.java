package com.Equipo3.Backend.Evento.Dominio.DTO;

import com.Equipo3.Backend.Usuario.Dominio.Usuario;

import java.sql.Date;

public class EventoDTO {
    private int id;
    private String nombre;
    private Date fecha;
    private Usuario usuario;
    private String descripcion;

    public EventoDTO() {
    }

    public EventoDTO(int id, String nombre, Date fecha, Usuario Usuario, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.usuario = Usuario;
        this.descripcion = descripcion;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
