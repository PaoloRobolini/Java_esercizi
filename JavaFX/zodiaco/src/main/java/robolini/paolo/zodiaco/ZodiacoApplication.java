package robolini.paolo.zodiaco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ZodiacoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZodiacoApplication.class.getResource("zodiaco-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Segno Zodiacale");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}