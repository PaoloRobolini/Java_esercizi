package robolini.paolo.codicefiscale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

public class codiceFiscaleController {
    public TextField txfNome;
    public TextField txfCognome;
    public RadioButton rdbMaschio;
    public RadioButton rdbFemmina;
    public DatePicker dtpDataDiNascita;
    public CheckBox chbNatoEstero;
    public ComboBox cmbStatoNascita;
    public ComboBox cmbComuneNascita;
    public VBox vboxluogonascita;
    @FXML
    private Label lblCodiceCalcolato;
    @FXML
    boolean natoEstero = false;

    @FXML
    public void initialize() throws IOException {
        chbNatoEstero.setSelected(false);
        rdbMaschio.setSelected(true);

        filtraCmb(cmbComuneNascita, LuoghiNascitaRepository.getInstanceComuni("comuni.csv").keySet());
        filtraCmb(cmbStatoNascita, LuoghiNascitaRepository.getInstanceStati("stati.csv").keySet());

        vboxluogonascita.getChildren().remove(cmbStatoNascita);
    }

    private String getEventualError(String nome, String cognome, LocalDate dataDiNascita, String LuogoNascita){
        if (nome.isEmpty()){
            return "ERRORE: NOME VUOTO";
        } else if (cognome.isEmpty()){
            return "ERRORE: COGNOME VUOTO";
        } else if (dataDiNascita == null){
            return "ERRORE: DATA DI NASCITA NON VALIDA";
        } else if (LuogoNascita == null){
            return "ERRORE: LUOGO DI NASCITA NON VALIDO";
        }
        return "";
    }

    @FXML
    private void filtraCmb(ComboBox<String> cmb, Set<String> elenco) {
        ObservableList<String> osservabile = FXCollections.observableArrayList(elenco);

        FilteredList<String> filtrata = new FilteredList<>(osservabile, p -> true);

        cmb.setItems(filtrata);

        cmb.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            final TextField editor = cmb.getEditor();
            final String selected = cmb.getSelectionModel().getSelectedItem();

            if (selected == null || !selected.equals(editor.getText())) {
                filtrata.setPredicate(comune -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    return comune.toLowerCase().contains(lowerCaseFilter);
                });

                cmb.show();
            }
        });

    }

    @FXML
    protected void onCalcolaButtonClick() throws IOException {

        String nome = txfNome.getText();
        String cognome = txfCognome.getText();
        boolean isMaschio = rdbMaschio.isSelected();
        boolean isNatoEstero = chbNatoEstero.isSelected();
        LocalDate dataDiNascita = dtpDataDiNascita.getValue();

        String luogoNascita = (String)cmbComuneNascita.getValue();
        String nomeFile = "comuni.csv";

        if (isNatoEstero){
            luogoNascita = (String)cmbStatoNascita.getValue();
            nomeFile = "stati.csv";
        }

        codiceFiscaleCalcolatore calcolatore =
        new codiceFiscaleCalcolatore(nome, cognome, dataDiNascita, isMaschio, luogoNascita, nomeFile, isNatoEstero);


        String eventualError = getEventualError(nome, cognome, dataDiNascita, luogoNascita);
        if (eventualError.isEmpty()){
            lblCodiceCalcolato.setText(calcolatore.calcolaCodiceFiscaleCompleto());
            lblCodiceCalcolato.setStyle("-fx-text-fill: black; -fx-font-weight: normal;");
        } else {
            lblCodiceCalcolato.setText(eventualError);
            lblCodiceCalcolato.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }

    public void onNascitaEsteroClick(){
        System.out.println("nato all'estero:" + natoEstero);
        natoEstero = !natoEstero;
        if (chbNatoEstero.isSelected()){
            System.out.println("Aggiunti gli stati");
            vboxluogonascita.getChildren().remove(cmbComuneNascita);
            vboxluogonascita.getChildren().add(cmbStatoNascita);
        } else {
            System.out.println("Aggiunti i comuni");
            vboxluogonascita.getChildren().remove(cmbStatoNascita);
            vboxluogonascita.getChildren().add(cmbComuneNascita);
        }
    }
}