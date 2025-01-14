package robolini.paolo.zodiaco;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class ZodiacoController {

    @FXML
    private DatePicker datNascita;
    @FXML
    private Label welcomeText;

    private ZodiacoConverter convertitore;
    private String dataDiNascita;

    @FXML
    protected void onHelloButtonClick() {
        LocalDate data = datNascita.getValue();
        convertitore = new ZodiacoConverter(data);
        welcomeText.setText("Il tuo segno è " + convertitore.getSegno()
                //+ ", quello ascendente " + convertitore.getSegnoAscendente()+
        );
    }
}