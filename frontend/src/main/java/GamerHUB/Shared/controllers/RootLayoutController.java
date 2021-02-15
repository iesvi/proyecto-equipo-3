package GamerHUB.Shared.controllers;

import GamerHUB.MainApp;
import javafx.fxml.FXML;

public class RootLayoutController {

    // Reference to the main application
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }



    /**
     * Saves the file to the person file that is currently open. If there is no open
     * file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave() {

    }


    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
