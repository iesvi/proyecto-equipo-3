package GamerHUB.Shared.controllers;

import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.MainApp;

public class VistaHomeControlador {

    private MainApp mainApp;
    private UsuarioDTO usuarioDTO;
    
    public VistaHomeControlador(){}

    public VistaHomeControlador(UsuarioDTO usuarioDTO){
        this.usuarioDTO = usuarioDTO;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public MainApp getMainApp() {
        return mainApp;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
