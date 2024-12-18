package robolini.paolo.pallavolo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PallavoloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PallavoloApplication.class.getResource("Pallavolo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tabellone Pallavolo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}