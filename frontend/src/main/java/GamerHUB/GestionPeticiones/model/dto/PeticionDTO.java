package GamerHUB.GestionPeticiones.model.dto;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 */
public class PeticionDTO {

    private IntegerProperty id;
    private StringProperty nombre;
    private StringProperty descripcion;
    //    private IntegerProperty id_usuario;
    private StringProperty respuesta;
//    private BooleanProperty estado;


    public PeticionDTO() {

    }

    /**
     * @param nombre
     * @param descripcion
     * @param respuesta
     */
    public PeticionDTO(String nombre, String descripcion, String respuesta) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = new SimpleStringProperty(nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.respuesta = new SimpleStringProperty(respuesta);
//        this.estado = new SimpleBooleanProperty(estado);
    }

    public PeticionDTO(String nombre, String descripcion) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = new SimpleStringProperty(nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

//    public int getId_usuario() {
//        return id_usuario.get();
//    }
//
//    public IntegerProperty id_usuarioProperty() {
//        return id_usuario;
//    }
//
//    public void setId_usuario(int id_usuario) {
//        this.id_usuario.set(id_usuario);
//    }

    public String getRespuesta() {
        return respuesta.get();
    }

    public void setRespuesta(String respuesta) {
        this.respuesta.set(respuesta);
    }

    public StringProperty respuestaProperty() {
        return respuesta;
    }

//    public boolean isEstado() {
//        return estado.get();
//    }
//
//    public BooleanProperty estadoProperty() {
//        return estado;
//    }
//
//    public void setEstado(boolean estado) {
//        this.estado.set(estado);
//    }

    @Override
    public String toString() {
        return "PeticionDTO{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", descripcion=" + descripcion +
                ", respuesta=" + respuesta +
                '}';
    }
}
