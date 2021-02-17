package com.Equipo3.Backend.Usuario.Dominio.Builder;

import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;

public class UsuarioVOMother {
    public static UsuarioVO general() {
        return new UsuarioVOBuilder().build();
    }
}
