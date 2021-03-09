package com.Equipo3.Backend.Peticion.Dominio.DTO;

import lombok.*;

/**
 * Clase PeticionDTO
 */
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@AllArgsConstructor
public class PeticionDTO {

    /**
     * id tipo int
     */
    private int id;

    /**
     * nombre tipo String
     */
    private String nombre;

    /**
     * Descripcion tipo String
     */
    private String Descripcion;

    /**
     * Respuesta tipo String
     */
    private String Respuesta;

    /**
     * Constructor de PeticionDTO
     * @param nombre
     * @param Descripcion
     * @param Respuesta
     */
    public PeticionDTO(String nombre, String Descripcion, String Respuesta) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.Respuesta = Respuesta;
    }


}
