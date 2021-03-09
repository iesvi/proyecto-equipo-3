package GamerHUB.GestionUsuarios.ui;

import GamerHUB.GestionUsuarios.controller.VistaPerfilControlador;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.Shared.view.VentanaHomeVista;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VentanaPerfilVista {

    private Stage stageppal;
    private UsuarioDTO userLogeado;
    private VentanaHomeVista ventanaHomeVista;

    public VentanaPerfilVista(Stage stageppal, VentanaHomeVista ventanaHomeVista) {
        this.stageppal = stageppal;
        this.ventanaHomeVista = ventanaHomeVista;
    }

    /**
     * @param usuarioDTO
     * @throws IOException
     */
    public void LaunchVistaPerfil(SplitPane pane, UsuarioDTO usuarioDTO) throws IOException {
        URL url = new File("src/main/java/GamerHUB/GestionUsuarios/ui/VistaPerfil.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane perfil = (AnchorPane) loader.load();
        pane.getItems().set(0, perfil);

        VistaPerfilControlador controladorPerfil = loader.getController();
        controladorPerfil.setVista(this, stageppal);
        controladorPerfil.setUserLogeado(usuarioDTO);
        controladorPerfil.setVentanahome(ventanaHomeVista);
        controladorPerfil.setcampos();

        pane.setDividerPositions(0.32);
    }

}
