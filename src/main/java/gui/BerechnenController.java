package gui;

import exceptions.AltNeuException;
import exceptions.NegativeNumberException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import klassen.Tank;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URISyntaxException;

public class BerechnenController {

    @SuppressWarnings("exports")
    @FXML
    public Label labelAltKilo;
    @SuppressWarnings("exports")
    @FXML
    public Label labelNeuKilo;
    @SuppressWarnings("exports")
    @FXML
    public Label labelLiter;
    @SuppressWarnings("exports")
    @FXML
    public Label verbrauchLabel;
    @SuppressWarnings("exports")
    @FXML
    public Label verbrauch;
    @SuppressWarnings("exports")
    @FXML
    public TextField neuKilo;
    @SuppressWarnings("exports")
    @FXML
    public TextField altKilo;
    @SuppressWarnings("exports")
    @FXML
    public TextField liter;
    @SuppressWarnings("exports")
    @FXML
    public Button berechnen;

    @FXML
    private void berechnen() throws URISyntaxException, UnsupportedAudioFileException, IOException {
        try {
            Tank tank = new Tank(liter.getText(), altKilo.getText(), neuKilo.getText());
            gui.App.v.addTank(tank);

            neuKilo.setText("");
            altKilo.setText("");
            liter.setText("");
            verbrauch.setText(tank.getVerbrauchMitVariablenNachkommaStellen(2) + "");

        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Eingabe ist nicht Nummerisch!");
            alert.showAndWait();

        } catch (AltNeuException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Der neue Stand ist kleiner als der alte!");
            alert.showAndWait();

        } catch (NegativeNumberException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Einer der eingegebenen Werte ist negativ!");
            alert.showAndWait();
        }
    }

    @FXML
    private void showUeber() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(gui.App.class.getResource("/Info.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void showTank() throws IOException {
        gui.App.setRoot("TankStaende");
    }

    @SuppressWarnings("exports")
    @FXML
    public void close(ActionEvent event) {
        System.exit(0);
    }
}
