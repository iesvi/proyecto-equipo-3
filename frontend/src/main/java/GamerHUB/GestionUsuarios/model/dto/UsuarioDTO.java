package GamerHUB.GestionUsuarios.model.dto;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;
import java.util.ArrayList;

public class UsuarioDTO {

        private int id;
        private String nombre;
        private String password;
        private String email;
        private Date fecha_nacimiento;
        private int telefono;
        private String rol;
        private ArrayList<UsuarioDTO> amigos;



        public UsuarioDTO() {
        }

        public UsuarioDTO(int id, String nombre, String password, String email, Date fecha_nacimiento, int telefono, String rol, ArrayList<UsuarioDTO> amigos) {



        }






}
