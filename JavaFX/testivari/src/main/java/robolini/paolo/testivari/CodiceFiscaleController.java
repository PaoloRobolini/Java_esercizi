package robolini.paolo.testivari;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CodiceFiscaleController {

    @FXML
    private TextField txtNome;
    @FXML
    private Label lblCodiceFiscale;
    @FXML
    private TextField txtCognome;

    private CodiceFiscale codiceFiscale;

    @FXML
    protected void onCalcolaButtonClick() {
        String cognome = txtCognome.getText();
        String nome = txtNome.getText();
        codiceFiscale = new CodiceFiscale(nome, cognome);
        lblCodiceFiscale.setText(codiceFiscale.calcola());
    }
}