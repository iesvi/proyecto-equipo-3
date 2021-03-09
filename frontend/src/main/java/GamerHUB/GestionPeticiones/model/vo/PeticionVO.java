package GamerHUB.GestionPeticiones.model.vo;

import java.io.Serializable;

/**
 *
 */
public class PeticionVO implements Serializable {

    private int id;
    private String nombre;
    private String descripcion;
    //    private int id_usuario;
    private String respuesta;
//    private boolean estado;


    public PeticionVO() {
    }

    /**
     * @param id
     * @param nombre
     * @param descripcion
     * @param respuesta
     */
    public PeticionVO(int id, String nombre, String descripcion, String respuesta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
//        this.id_usuario = id_usuario;
        this.respuesta = respuesta;
//        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//    public int getId_usuario() {
//        return id_usuario;
//    }
//
//    public void setId_usuario(int id_usuario) {
//        this.id_usuario = id_usuario;
//    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

//    public boolean isEstado() {
//        return estado;
//    }
//
//    public void setEstado(boolean estado) {
//        this.estado = estado;
//    }


    @Override
    public String toString() {
        return "PeticionVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", respuesta='" + respuesta + '\'' +
                '}';
    }
}
