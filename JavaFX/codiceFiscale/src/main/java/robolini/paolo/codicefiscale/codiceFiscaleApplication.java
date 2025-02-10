package robolini.paolo.codicefiscale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class codiceFiscaleApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(codiceFiscaleApplication.class.getResource("codice-fiscale-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Calcola il tuo codice fiscale");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}