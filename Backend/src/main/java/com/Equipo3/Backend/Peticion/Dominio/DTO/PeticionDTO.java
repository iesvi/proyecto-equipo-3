package com.Equipo3.Backend.Peticion.Dominio.DTO;

import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@AllArgsConstructor
public class PeticionDTO {

    private int id;

    private String nombre;

    private String Descripcion;

    private String Respuesta;

    public PeticionDTO(String nombre, String Descripcion, String Respuesta) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.Respuesta = Respuesta;
    }




}
