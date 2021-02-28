package GamerHUB.GestionChat.model.vo;


/**
 *
 */
import java.io.Serializable;
import java.util.ArrayList;

public class CanalVO implements Serializable {


    private int id;
    private String nombre;
    private ArrayList<Integer> miembros;
    private ArrayList<MensajeVO> historial;

    /**
     *
     * @param id
     * @param nombre
     * @param miembros
     * @param historial
     */
    public CanalVO(int id, String nombre, ArrayList<Integer> miembros, ArrayList<MensajeVO> historial) {
        this.id = id;
        this.nombre = nombre;
        this.miembros = miembros;
        this.historial = historial;
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

    public ArrayList<Integer> getMiembros() {
        return miembros;
    }

    public void setMiembros(ArrayList<Integer> miembros) {
        this.miembros = miembros;
    }

    public ArrayList<MensajeVO> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<MensajeVO> historial) {
        this.historial = historial;
    }

    @Override
    public String toString() {
        return "CanalVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", miembros=" + miembros +
                ", historial=" + historial +
                '}';
    }
}
