package com.Equipo3.Backend.Evento.Dominio;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Clase EventoVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class EventoVO {

    /**
     * id tipo int el cual es el Id en la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * nombre tipo String
     */
    @Column
    private String nombre;

    /**
     * fecha tipo Date
     */
    @Column
    private Date fecha;

    /**
     * idusuario tipo int
     */
    @Column
    private int idusuario;

    /**
     * descripcion tipo String
     */
    @Column
    private String descripcion;
}