package com.Equipo3.Backend.Usuario.Dominio;

import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UsuarioVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private Date fecha_nacimiento;
    @Column
    private int telefono;
    @Column
    private String rol;
    @Column
    @OneToMany
    private List<UsuarioVO> idamigos;
    @Column
    @OneToMany
    private List<EventoVO> ideventos;

}
