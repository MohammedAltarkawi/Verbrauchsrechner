package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import klassen.Tank;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaendeController implements Initializable {

    private int pos = 0;
    private static ArrayList<Tank> tanks = App.v.getTanks();

    @SuppressWarnings("exports")
    @FXML
    public Button previous;
    @SuppressWarnings("exports")
    @FXML
    public Button next;
    @SuppressWarnings("exports")
    @FXML
    public Button fuckIt;
    @SuppressWarnings("exports")
    @FXML
    public Label altKiloLabel;
    @SuppressWarnings("exports")
    @FXML
    public Label neuKiloLabel;
    @SuppressWarnings("exports")
    @FXML
    public Label literLabel;
    @SuppressWarnings("exports")
    @FXML
    public Label verbrauchLabel;
    @SuppressWarnings("exports")
    @FXML
    public Label altKilo;
    @SuppressWarnings("exports")
    @FXML
    public Label neuKilo;
    @SuppressWarnings("exports")
    @FXML
    public Label liter;
    @SuppressWarnings("exports")
    @FXML
    public Label verbrauch;

    // ----- Start Methoden -----
    @FXML
    public void close() throws IOException {
        App.setRoot("TankBerechnen");
        pos = 0;
    }

    @FXML
    public void next() {
        if (pos + 1 != tanks.size()) {
            pos++;
            fillValues();
        }
    }

    @FXML
    public void previous() {
        if (pos - 1 >= 0) {
            pos--;
            fillValues();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillValues();
    }

    private void fillValues() {
        if (tanks != null && tanks.size() > 0) {
            altKilo.setText(tanks.get(pos).getAltStand() + "");
            neuKilo.setText(tanks.get(pos).getNeuStand() + "");
            liter.setText(tanks.get(pos).getGetankt() + "");
            verbrauch.setText(tanks.get(pos).getVerbrauchMitVariablenNachkommaStellen(2) + "");
        }
    }
}
