package GamerHUB.GestionUsuarios.model.vo;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioVO {
    private IntegerProperty id;
    private StringProperty nombre;
    private StringProperty password;
    private StringProperty email;
    private ObjectProperty<LocalDate> fecha_nacimiento;
    private IntegerProperty telefono;
    private StringProperty rol;
    private ArrayList<UsuarioVO> amigos;

    public UsuarioVO() {
    }


}
