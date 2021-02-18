package com.Equipo3.Backend.Usuario.Dominio;

import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Clase UsuarioVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@Entity(name="Usuario")
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
    @ManyToMany
    private List<UsuarioVO> idamigos;

    /**
     * ideventos tipo List<EventoVO>
     */
    @Column
    @OneToMany
    private List<EventoVO> ideventos;

    public UsuarioVO(String nombre, String password, String email, Date fecha_nacimiento, int telefono, String rol) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rol = rol;
    }
}
