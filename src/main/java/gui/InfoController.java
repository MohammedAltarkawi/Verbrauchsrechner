package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InfoController {

    @SuppressWarnings("exports")
    @FXML
    public Button closeButton;

    @SuppressWarnings("exports")
    @FXML
    public void close(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
