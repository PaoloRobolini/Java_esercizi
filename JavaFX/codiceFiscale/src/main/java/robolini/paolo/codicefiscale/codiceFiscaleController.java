package robolini.paolo.codicefiscale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

public class codiceFiscaleController {
    public TextField txfNome;
    public TextField txfCognome;
    public RadioButton rdbMaschio;
    public RadioButton rdbFemmina;
    public DatePicker dtpDataDiNascita;
    public CheckBox chbNatoEstero;
    public TextField txfLuogoNascita;
    public ComboBox cmbComuni;
    @FXML
    private Label lblCodiceCalcolato;
    @FXML
    private TextField txfTesto;

    private ObservableList<String> listaOsservabile;
    private FilteredList<String> filtroCose;

    @FXML
    public void initialize() throws IOException {
        listaOsservabile = FXCollections.observableArrayList(ComuniRepository.getInstance("C:\\Users\\73208584\\Desktop\\JavaFX\\codiceFiscale\\comuni.csv").keySet());
        filtroCose = new FilteredList<>(listaOsservabile, p -> true);
        cmbComuni.setItems(filtroCose);
        cmbComuni.setEditable(true);
        TextField editor = cmbComuni.getEditor();
        editor.textProperty().addListener((obs, oldValue, newValue) -> {
            filtroCose.setPredicate(comune -> comune.toLowerCase().contains(newValue.toLowerCase()));
            if (!filtroCose.isEmpty()) {
                cmbComuni.show();
            }
        });
    }

    @FXML
    protected void onCalcolaButtonClick(ActionEvent actionEvent) throws IOException {

        String nome = txfNome.getText();
        String cognome = txfCognome.getText();
        boolean is_maschio = rdbMaschio.isSelected();
        boolean natoEstero = chbNatoEstero.isSelected();
        LocalDate dataDiNascita = dtpDataDiNascita.getValue();

        String nomeComune = "Moldavia";

        codiceFiscaleCalcolatore calcolatore = new codiceFiscaleCalcolatore(nome, cognome, dataDiNascita, is_maschio, nomeComune,
                natoEstero,"C:\\Users\\73208584\\Desktop\\JavaFX\\codiceFiscale\\comuni.csv",
                "C:\\Users\\73208584\\Desktop\\JavaFX\\codiceFiscale\\stati.csv");
        lblCodiceCalcolato.setText(calcolatore.getCodiceFiscale());
    }

    public void onNascitaEsteroClick(ActionEvent actionEvent) {
        
    }
}