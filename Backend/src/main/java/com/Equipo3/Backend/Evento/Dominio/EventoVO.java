package com.Equipo3.Backend.Evento.Dominio;

import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
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
@With
@EqualsAndHashCode
@Entity(name="Evento")
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
    @Column(length = 500)
    private String nombre;

    /**
     * fecha tipo Date
     */
    @Column(length = 500)
    private Date fecha;

    /**
     * idusuario tipo int
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuarioId",foreignKey = @ForeignKey(name = "USUARIO_ID_FK"))
    private UsuarioVO idusuario;

    /**
     * descripcion tipo String
     */
    @Column(length = 500)
    private String descripcion;

    public EventoVO(String nombre, Date fecha, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}