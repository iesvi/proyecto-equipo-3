package GamerHUB.GestionPeticiones.model.dto;


import javafx.beans.property.*;

/**
 *
 */
public class PeticionDTO {

    private IntegerProperty id;
    private StringProperty nombre;
    private StringProperty descripcion;
    private IntegerProperty id_usuario;
    private StringProperty respuesta;
    private BooleanProperty estado;


    public PeticionDTO() {

    }

    /**
     * @param nombre
     * @param descripcion
     * @param respuesta
     * @param estado
     */
    public PeticionDTO(String nombre, String descripcion, String respuesta, boolean estado) {

        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = new SimpleStringProperty(nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.respuesta = new SimpleStringProperty(respuesta);
        this.estado = new SimpleBooleanProperty(estado);

    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public int getId_usuario() {
        return id_usuario.get();
    }

    public IntegerProperty id_usuarioProperty() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario.set(id_usuario);
    }

    public String getRespuesta() {
        return respuesta.get();
    }

    public StringProperty respuestaProperty() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta.set(respuesta);
    }

    public boolean isEstado() {
        return estado.get();
    }

    public BooleanProperty estadoProperty() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado.set(estado);
    }


    @Override
    public String toString() {
        return "PeticionDTO{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", descripcion=" + descripcion +
                ", id_usuario=" + id_usuario +
                ", respuesta=" + respuesta +
                ", estado=" + estado +
                '}';
    }
}
