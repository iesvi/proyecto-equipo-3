package com.Equipo3.Backend.Usuario.Dominio.DTO;

import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class UsuarioDTO {
    private int id;
    private String nombre;
    private String password;
    private String email;
    private Date fecha_nacimiento;
    private int telefono;
    private String rol;
    private List<UsuarioVO> idamigos;
    private List<EventoVO> ideventos;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, String nombre, String password, String email, Date fecha_nacimiento, int telefono, String rol, List<UsuarioVO> idamigos, List<EventoVO> ideventos) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rol = rol;
        this.idamigos = idamigos;
        this.ideventos = ideventos;
    }
}
