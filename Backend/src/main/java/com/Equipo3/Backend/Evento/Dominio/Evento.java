package com.Equipo3.Backend.Evento.Dominio;

import com.Equipo3.Backend.Usuario.Dominio.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class Evento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private Date fecha;
    @ManyToOne(fetch= FetchType.LAZY)
    private Usuario usuario;
    private String descripcion;

    public Evento() {
    }

    public Evento(int id, String nombre, Date fecha, Usuario usuario, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.usuario = usuario;
        this.descripcion = descripcion;
    }
}