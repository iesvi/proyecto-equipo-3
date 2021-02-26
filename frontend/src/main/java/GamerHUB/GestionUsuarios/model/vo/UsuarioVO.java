package GamerHUB.GestionUsuarios.model.vo;

import GamerHUB.GestionEventos.model.vo.EventoVO;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 */
public class UsuarioVO {

    private int id;
    private String nombre;
    private String password;
    private String email;
    private Date fecha_nacimiento;
    private int telefono;
    private String rol;
    private ArrayList<UsuarioVO> amigos;
    private ArrayList<UsuarioVO> amigosde;
    private ArrayList<EventoVO> evento;


    public UsuarioVO() {
    }

    public UsuarioVO(int id, String nombre, String password, String email, Date fecha_nacimiento, int telefono, String rol, ArrayList<UsuarioVO> amigos, ArrayList<UsuarioVO> amigosde, ArrayList<EventoVO> evento) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rol = rol;
        this.amigos = amigos;
        this.amigosde = amigosde;
        this.evento = evento;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public ArrayList<UsuarioVO> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<UsuarioVO> amigos) {
        this.amigos = amigos;
    }

    public ArrayList<UsuarioVO> getAmigosDe() {
        return amigosde;
    }

    public void setAmigosDe(ArrayList<UsuarioVO> amigosde) {
        this.amigosde = amigosde;
    }

    public ArrayList<EventoVO> getEvento() {
        return evento;
    }

    public void setEvento(ArrayList<EventoVO> evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "UsuarioVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", telefono=" + telefono +
                ", rol='" + rol + '\'' +
                ", amigos=" + amigos +
                '}';
    }
}
