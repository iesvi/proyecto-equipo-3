package Shared.controllers;

import GestionUsuarios.model.dto.UsuarioDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VistaInicioControlador {

   // private MainApp mainApp = new MainApp();

    @FXML
    private TextField dniField;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidosField;
    @FXML
    private TextField direccionField;
    @FXML
    private TextField localidadField;


    public VistaInicioControlador(){
    }

    private Stage dialogStage;
    private UsuarioDTO usuarioDTO;
    private boolean okClicked = false;







}
