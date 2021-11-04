package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import klassen.Verwaltung;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    @SuppressWarnings("exports")
    public static Verwaltung v = new Verwaltung();

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("TankBerechnen"), 300, 300);
        stage.setScene(scene);
        stage.setTitle("Verbrauchsrechner");
        stage.setResizable(false);
        stage.getIcons().clear();
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}