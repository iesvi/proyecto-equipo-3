package GamerHUB;

import GamerHUB.GestionEventos.controller.EventoController;
import GamerHUB.GestionEventos.model.dto.EventoDTO;
import GamerHUB.GestionEventos.model.vo.EventoVO;
import GamerHUB.GestionUsuarios.controller.VistaPerfilControlador;
import GamerHUB.GestionUsuarios.controller.VistaRegistroControlador;
import GamerHUB.GestionUsuarios.model.Conversor;
import GamerHUB.GestionUsuarios.model.dto.UsuarioDTO;
import GamerHUB.GestionUsuarios.model.vo.UsuarioVO;
import GamerHUB.Shared.controllers.VistaHomeControlador;
import GamerHUB.Shared.controllers.VistaInicioControlador;
import GamerHUB.Shared.exception.CustomException;
import GamerHUB.Shared.view.VentanaRootVista;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

/**
 * Controlador principal de la aplicación. Se encargará de lanzar los métodos de renderizado de las vistas
 * y las listas en memoria.
 */
public class MainApp extends Application {

    private VentanaRootVista ventanaRoot;

    private AnchorPane home;
    private AnchorPane perfil;
    private AnchorPane evento;
    /**
     *
     */
    private SplitPane pane;

    /**
     * Lista con los datos de usuarios de tipo DTO, que usará la aplicación para
     * mostrar y manipular.
     */
    private ObservableList<UsuarioDTO> usuarios = FXCollections.observableArrayList();
    /**
     * Lista con los datos de usuarios de tipo VO, que simulará una bbdd.
     */
    private ObservableList<UsuarioVO> usuarios_bd = FXCollections.observableArrayList();

    private ObservableList<EventoDTO> evento_list = FXCollections.observableArrayList();

    private ObservableList<EventoVO> evento_bd = FXCollections.observableArrayList();


    private Set<UsuarioVO> usuarios_bbdd = new TreeSet<UsuarioVO>();

    /**
     *
     */
    private UsuarioDTO usuarioLogeado = new UsuarioDTO();


    public MainApp() {

        //usuarios.add(new UsuarioDTO( new SimpleStringProperty("kk")));

        LocalDate localDate = LocalDate.now();
        //Usuario normal
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "user",
                "user",
                "email",
                localDate,
                0
        );

        UsuarioDTO admin = new UsuarioDTO(
                "admin",
                "admin",
                "email",
                localDate,
                0,
                "admin"
        );
        EventoDTO eventoDTO = new EventoDTO(
                "evento1",
                "desc",
                localDate,
                localDate,
                11
        );
        usuarios.add(usuarioDTO);
        usuarios.add(admin);

        getEventos().add(eventoDTO);

        if (!usuarios_bd.isEmpty()) {
            for (UsuarioVO user : usuarios_bd) {
                usuarios.add(Conversor.voToDto(user));

            }
            usuarios_bbdd.addAll(usuarios_bd);
        }

    }

    public ObservableList<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public ObservableList<UsuarioVO> getUsuarios_bd() {
        return usuarios_bd;
    }

    public ObservableList<EventoDTO> getEventos() {
        return evento_list;
    }

    public ObservableList<EventoVO> getEventos_bd() {
        return evento_bd;
    }


    public Set<UsuarioVO> getUsuarios_bbdd() {
        return usuarios_bbdd;
    }

    public UsuarioDTO getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(UsuarioDTO usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }

    public SplitPane getPane() {
        return pane;
    }

    public void setPane(SplitPane pane) {
        this.pane = pane;
    }


    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        ventanaRoot = new VentanaRootVista();
        ventanaRoot.inicioStage(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }



















    public void LaunchVistaAdmin() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("Shared/view/VistaAdmin.fxml"));
        home = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        Scene scene = new Scene(home, 800, 525);
        dialogStage = new Stage();
        dialogStage.setScene(scene);

    }


}
