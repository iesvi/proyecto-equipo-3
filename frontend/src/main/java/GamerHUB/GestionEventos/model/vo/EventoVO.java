package GamerHUB.GestionEventos.model.vo;

import java.sql.Date;

/**
 *Tipo VO de la entidad Evento. Es el tipo de dato que se utiliza para persistir en la BBDD.
 */
public class EventoVO {

    private int id;
    private String nombre;
    private String descripcion;
    private Date fecha_ini;
    private Date fecha_final;
    private int usuario;

    public EventoVO() {
    }

    /**
     *
     * @param id
     * @param nombre
     * @param descripcion
     * @param fechaini
     * @param fechaf
     * @param usuario
     */
    public EventoVO(int id, String nombre, String descripcion, Date fechaini, Date fechaf, int usuario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_ini = fechaini;
        this.fecha_final = fechaf;
        this.usuario = usuario;
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

    public Date getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "EventoVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha_ini=" + fecha_ini +
                ", fecha_final=" + fecha_final +
                ", usuario=" + usuario +
                '}';
    }
}
