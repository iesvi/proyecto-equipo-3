package com.Equipo3.Backend.Usuario.Dominio;

import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Clase UsuarioVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UsuarioVO {

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
     * password tipo String
     */
    @Column
    private String password;

    /**
     * email tipo String
     */
    @Column
    private String email;

    /**
     * fecha_nacimiento tipo Date
     */
    @Column
    private Date fecha_nacimiento;

    /**
     * telefono tipo int
     */
    @Column
    private int telefono;

    /**
     * rol tipo String
     */
    @Column
    private String rol;

    /**
     * idamigos tipo List<UsuarioVO>
     */
    @Column
    @OneToMany
    private List<UsuarioVO> idamigos;

    /**
     * ideventos tipo List<EventoVO>
     */
    @Column
    @OneToMany
    private List<EventoVO> ideventos;
}
