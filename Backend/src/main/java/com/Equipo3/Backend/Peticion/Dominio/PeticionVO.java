package com.Equipo3.Backend.Peticion.Dominio;

import lombok.*;

import javax.persistence.*;

/**
 * Clase PeticionVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@Entity(name = "Peticion")
public class PeticionVO {

    /**
     * id tipo int el cual es el Id en la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * nombre tipo String
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Descripcion tipo String
     */
    @Column(length = 200, nullable = false)
    private String Descripcion;

    /**
     * Respuesta tipo String
     */
    @Column(length = 200)
    private String Respuesta;

    /**
     * Constructor de PeticionVO
     * @param nombre
     * @param Descripcion
     * @param Respuesta
     */
    public PeticionVO(String nombre, String Descripcion, String Respuesta) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.Respuesta = Respuesta;
    }
}
