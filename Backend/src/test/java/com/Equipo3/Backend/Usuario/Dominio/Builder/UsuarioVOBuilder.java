package com.Equipo3.Backend.Usuario.Dominio.Builder;

import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import io.beanmother.core.ObjectMother;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.Date;

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


    public UsuarioVO build(){
        ObjectMother om = ObjectMother.getInstance();
        UsuarioVO mother= om.bear("UsuarioVO",UsuarioVO.class);

        return new UsuarioVO(
                nombre!=null ? nombre : mother.getNombre(),
                password!=null ? password : mother.getPassword(),
                email!=null ? email : mother.getEmail(),
                fecha_nacimiento!=null ? fecha_nacimiento : null,
                telefono!=0 ? telefono : mother.getTelefono(),
                rol!=null ? rol : "admin"
        );
    }
}
