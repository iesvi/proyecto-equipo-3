package com.Equipo3.Backend.Usuario.Dominio.Builder;

import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Evento.Dominio.EventoVOBuilder;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import io.beanmother.core.ObjectMother;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@With
public class UsuarioVOBuilder {
    private String nombre;
    private String password;
    private String email;
    private Date fecha_nacimiento;
    private int telefono;
    private String rol;
    private List<UsuarioVO> idamigos;
    private List<EventoVO> ideventos;


    public UsuarioVO build(){
        ObjectMother om = ObjectMother.getInstance();
        UsuarioVO mother= om.bear("UsuarioVO",UsuarioVO.class);

        return new UsuarioVO(
                nombre!=null ? nombre : mother.getNombre(),
                password!=null ? password : mother.getPassword(),
                email!=null ? email : mother.getEmail(),
                fecha_nacimiento!=null ? fecha_nacimiento : mother.getFecha_nacimiento(),
                telefono!=0 ? telefono : mother.getTelefono(),
                rol!=null ? rol : "admin",
                idamigos!=null ? idamigos : null,
                ideventos!=null ? ideventos : null
        );
    }
}
