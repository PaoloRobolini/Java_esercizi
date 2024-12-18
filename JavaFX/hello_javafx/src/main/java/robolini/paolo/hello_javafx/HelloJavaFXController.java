package robolini.paolo.hello_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloJavaFXController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("HAI CLICCATO IL PULSANTE [EPICO]");
    }
}