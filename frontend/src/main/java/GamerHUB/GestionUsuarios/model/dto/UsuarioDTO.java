package GamerHUB.GestionUsuarios.model.dto;

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
            this.usuario = new SimpleStringProperty(usuario);
            this.email = new SimpleStringProperty(email);
            this.password = new SimpleStringProperty(password);
            this.fecha_nacimiento = new SimpleObjectProperty<LocalDate>(fecha_nacimiento);

        }

        public StringProperty getUsuarioProperty() {
            return usuario;
        }

        public String getUsuario() {
            return usuario.get();
        }

        public StringProperty usuarioProperty() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario.set(usuario);
        }

        public String getEmail() {
            return email.get();
        }

        public StringProperty emailProperty() {
            return email;
        }

        public void setEmail(String email) {
            this.email.set(email);
        }

        public String getPassword() {
            return password.get();
        }

        public StringProperty passwordProperty() {
            return password;
        }

        public void setPassword(String password) {
            this.password.set(password);
        }

        public LocalDate getFecha_nacimiento() {
            return fecha_nacimiento.get();
        }

        public ObjectProperty<LocalDate> fecha_nacimientoProperty() {
            return fecha_nacimiento;
        }

        public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
            this.fecha_nacimiento.set(fecha_nacimiento);
        }





}
