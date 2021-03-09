package GamerHUB.GestionChat.model.dto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 */
public class CanalDTO {


    private IntegerProperty id;
    private StringProperty nombre;
    private IntegerProperty puerto;
//    private ObservableList<Integer> miembros;
    //private ObservableList<MensajeDTO> historial;

    /**
     *
     * @param nombre
     * @param miembros

     */
    public CanalDTO( String nombre,int puerto) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));;
        this.nombre = new SimpleStringProperty(nombre);
        this.puerto = new SimpleIntegerProperty(puerto);
//        this.miembros = FXCollections.observableArrayList(miembros);
        //this.historial = FXCollections.observableArrayList(historial);
    }

    public CanalDTO(Integer id, String nombre, Integer puerto) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.puerto =  new SimpleIntegerProperty(puerto);
    }

    public CanalDTO() {
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

//    public ObservableList<Integer> getMiembros() {
//        return miembros;
//    }
//
//    public void setMiembros(ObservableList<Integer> miembros) {
//        this.miembros = miembros;
//    }

    public int getPuerto() {
        return puerto.get();
    }

    public IntegerProperty puertoProperty() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto.set(puerto);
    }

    @Override
    public String toString() {
        return "CanalDTO{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", puerto=" + puerto +
//                ", miembros=" + miembros +
                '}';
    }

    //  public ObservableList<MensajeDTO> getHistorial() {
     //   return historial;
  //  }

   // public void setHistorial(ObservableList<MensajeDTO> historial) {
      //  this.historial = historial;
   // }


}
