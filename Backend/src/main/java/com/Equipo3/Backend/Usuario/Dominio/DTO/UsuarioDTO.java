package com.Equipo3.Backend.Usuario.Dominio.DTO;


import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Shared.Aplicacion.Dto;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase UsuarioDTO
 */
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@AllArgsConstructor
public class UsuarioDTO implements Dto, Serializable {

    /**
     * id tipo int
     */
    private int id;

    /**
     * nombre tipo String
     */
    private String nombre;

    /**
     * password tipo String
     */
    private String password;

    /**
     * email tipo String
     */
    private String email;

    /**
     * fecha_nacimiento tipo Date
     */
    private Date fecha_nacimiento;

    /**
     * telefono tipo int
     */
    private int telefono;

    /**
     * rol tipo String
     */
    private String rol;

    /**
     * amigos tipo List<UsuarioVO>
     */
    private List<UsuarioDTO> amigos = new ArrayList<>();

    /**
     * amigosde tipo List<UsuarioDTO>
     */
    private List<UsuarioDTO> amigosde = new ArrayList<>();
    /**
     * eventos tipo List<EventoDTO>
     */
    private List<EventoDTO> eventos = new ArrayList<>();
//    /**
//     * chats tipo List<ChatDTO>
//     */
//    private List<ChatDTO> chats = new ArrayList<>();

    public UsuarioDTO(int id, String nombre, String password, String email, Date fecha_nacimiento, int telefono, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rol = rol;
    }

    public UsuarioDTO(String nombre, String password, String email, Date fecha_nacimiento, int telefono, String rol) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rol = rol;
    }
}
