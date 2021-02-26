package GamerHUB.GestionUsuarios.ui;

import GamerHUB.GestionUsuarios.controller.VistaPerfilControlador;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaPerfilVista {

    private Stage stageppal;

    public VentanaPerfilVista(Stage stageppal) {
        this.stageppal = stageppal;
    }

    /**
     * @param usuarioDTO
     * @throws IOException
     */
    public void LaunchVistaPerfil(UsuarioDTO usuarioDTO) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("Shared/view/VistaPerfil.fxml"));
        AnchorPane perfil = (AnchorPane) loader.load();

        Scene scene = new Scene(perfil, 400, 500);
        stageppal.setScene(scene);

        stageppal.setTitle("Configuración");

        VistaPerfilControlador controladorHome = loader.getController();
        controladorHome.setVista(this,stageppal);
        controladorHome.setUsuarioDTO(usuarioDTO);

        stageppal.show();
    }

}
