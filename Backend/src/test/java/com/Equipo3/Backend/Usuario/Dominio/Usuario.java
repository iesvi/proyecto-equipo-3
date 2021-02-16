package com.Equipo3.Backend.Usuario.Dominio;

import com.Equipo3.Backend.Evento.Dominio.Evento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String password;
    private String email;
    private Date fecha_nacimiento;
    private int telefono;
    private String rol;
    @Column(length = 255)
    @OneToMany
    private List<Usuario> amigos;
    @OneToMany
    private List<Evento> eventos;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String password, String email, Date fecha_nacimiento, int telefono, String rol, List<Usuario> idamigos, List<Evento> ideventos) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rol = rol;
        this.amigos = idamigos;
        this.eventos = ideventos;
    }




}
