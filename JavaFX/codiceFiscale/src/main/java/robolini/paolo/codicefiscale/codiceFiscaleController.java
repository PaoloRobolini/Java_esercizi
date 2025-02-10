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
    public ComboBox cmbStati;
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

        chbNatoEstero.setSelected(false);
        selezionaNascitaItalia();
    }

    private void selezionaNascitaItalia(){
        cmbStati.setVisible(false);
        cmbStati.setDisable(true);
        cmbComuni.setDisable(false);
        cmbComuni.setVisible(true);
    }
    
    private void selezionaNascitaEstero(){
        cmbStati.setVisible(true);
        cmbStati.setDisable(false);
        cmbComuni.setDisable(true);
        cmbComuni.setVisible(false);
    }

    @FXML
    protected void onCalcolaButtonClick(ActionEvent actionEvent) throws IOException {

        String nome = txfNome.getText();
        String cognome = txfCognome.getText();
        boolean isMaschio = rdbMaschio.isSelected();
        boolean natoEstero = chbNatoEstero.isSelected();
        LocalDate dataDiNascita = dtpDataDiNascita.getValue();

        String LuogoNascita = "";

        if (natoEstero){
            LuogoNascita = (String)cmbStati.getValue();
        } else {
            LuogoNascita = (String)cmbComuni.getValue();
        }


        codiceFiscaleCalcolatore calcolatore = new codiceFiscaleCalcolatore(nome, cognome, dataDiNascita, isMaschio, LuogoNascita,
                natoEstero,"C:\\Users\\73208584\\Desktop\\JavaFX\\codiceFiscale\\comuni.csv",
                "C:\\Users\\73208584\\Desktop\\JavaFX\\codiceFiscale\\stati.csv");
        lblCodiceCalcolato.setText(calcolatore.calcolaCodiceFiscaleCompleto());
    }

    public void onNascitaEsteroClick(ActionEvent actionEvent) {
        if (!cmbStati.isDisabled()){
            selezionaNascitaItalia();
        } else {
            selezionaNascitaEstero();
        }
    }
}