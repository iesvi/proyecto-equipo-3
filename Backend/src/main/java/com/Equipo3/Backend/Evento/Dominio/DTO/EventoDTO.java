package com.Equipo3.Backend.Evento.Dominio.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

/**
 * Clase EventoDTO
 */
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class EventoDTO {

    /**
     * id tipo int
     */
    private int id;

    /**
     * nombre tipo String
     */
    private String nombre;

    /**
     * fecha tipo Date
     */
    private Date fecha;

    /**
     * idusuario tipo int
     */
    private int idusuario;

    /**
     * descripcion tipo descripcion
     */
    private String descripcion;
}
