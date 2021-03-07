package com.Equipo3.Backend.Peticion.Dominio;

import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@Entity(name="Peticion")
public class PeticionVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 200, nullable = false)
    private String Descripcion;

    @Column(length = 200)
    private String Respuesta;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="usuarioId",foreignKey = @ForeignKey(name = "USUARIO_ID_FK"))
//    private UsuarioVO idusuario;

    public PeticionVO(String nombre, String Descripcion, String Respuesta) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.Respuesta = Respuesta;
    }
}
