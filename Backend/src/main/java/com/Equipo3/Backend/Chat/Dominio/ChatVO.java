package com.Equipo3.Backend.Chat.Dominio;

import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import com.Equipo3.Backend.Usuario.Err.PersonaErr;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase ChatVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@Entity(name="Chat")
public class ChatVO implements Serializable {
    /**
     * id tipo int el cual es el Id en la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * nombre tipo String
     */
    @Column(unique = true, nullable = false)
    private String nombre;

    /**
     * usuarios tipo List<UsuarioVO>
     */
    @ManyToMany
    @JoinTable(name="usuario",joinColumns = @JoinColumn(name="usuarioId"),inverseJoinColumns = @JoinColumn(name="chatId"))
    private List<UsuarioVO> usuarios = new ArrayList<>();

    /**
     * historial tipo Mensaje
     */
    @Column(nullable = false)
    private Mensaje historial;

    public ChatVO(int id, String nombre, Mensaje historial) {
        this.id = id;
        this.nombre = nombre;
        this.historial = historial;
    }

    public void addUsuario(UsuarioVO usuario) {
        if (usuarios == null)
            usuarios = new ArrayList<>();

        usuarios.add(usuario); //Chat agrega a usuario

    }

    public void eliminarUsuario(UsuarioVO usuario) {
        if (usuarios == null)
            throw new PersonaErr("PER.REM.FRIEND.NULL", "REMOVE FRIEND PARAM IS NULL");

        if (!usuarios.contains(usuario))
            return;

        usuarios.remove(usuario); //Chat elimina a usuario
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatVO chatVO = (ChatVO) o;
        return id == chatVO.id && nombre.equals(chatVO.nombre) && historial.equals(chatVO.historial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, historial);
    }
}
