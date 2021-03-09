package com.Equipo3.Backend.Evento.Dominio.DTO;

import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import lombok.*;

import java.util.Date;

/**
 * Clase EventoDTO
 */
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
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
    private UsuarioDTO idusuario;

    /**
     * descripcion tipo descripcion
     */
    private String descripcion;

    /**
     * Constructor de EventoDTO
     * @param nombre
     * @param fecha
     * @param descripcion
     */
    public EventoDTO(String nombre, Date fecha, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
