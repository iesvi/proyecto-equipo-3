package com.Equipo3.Backend.Evento.Dominio;

import com.Equipo3.Backend.Usuario.Dominio.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
    private int idusuario;
    private String descripcion;

    public Evento() {
    }

    public Evento(int id, String nombre, Date fecha, int idusuario, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.idusuario = idusuario;
        this.descripcion = descripcion;
    }
    public Evento(String nombre, Date fecha, int idusuario, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.idusuario = idusuario;
        this.descripcion = descripcion;
    }
}