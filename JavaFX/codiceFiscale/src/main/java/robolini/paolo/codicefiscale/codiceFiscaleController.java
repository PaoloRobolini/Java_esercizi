package robolini.paolo.codicefiscale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
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
        cmbStatoNascita.getItems().add(StatiRepository.getInstance("stati.csv").keySet());
        cmbComuneNascita.getItems().add(ComuniRepository.getInstance("comuni.csv").keySet());
        chbNatoEstero.setSelected(false);
        rdbMaschio.setSelected(true);

        filtraCmb(cmbComuneNascita, ComuniRepository.getInstance("comuni.csv").keySet());
        filtraCmb(cmbStatoNascita, StatiRepository.getInstance("stati.csv").keySet());

        vboxluogonascita.getChildren().remove(cmbStatoNascita);
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
        boolean natoEstero = chbNatoEstero.isSelected();
        LocalDate dataDiNascita = dtpDataDiNascita.getValue();

        String LuogoNascita = (String)cmbComuneNascita.getValue();

        if (natoEstero){
            LuogoNascita = (String)cmbStatoNascita.getValue();
        }

        codiceFiscaleCalcolatore calcolatore = new codiceFiscaleCalcolatore(nome, cognome, dataDiNascita, isMaschio, LuogoNascita, natoEstero,
                "comuni.csv",
                "stati.csv");
        lblCodiceCalcolato.setText(calcolatore.calcolaCodiceFiscaleCompleto());
    }

    public void onNascitaEsteroClick(){
        natoEstero = !natoEstero;
        if (chbNatoEstero.isSelected()){
            vboxluogonascita.getChildren().remove(cmbComuneNascita);
            vboxluogonascita.getChildren().add(cmbStatoNascita);
        } else {
            vboxluogonascita.getChildren().remove(cmbStatoNascita);
            vboxluogonascita.getChildren().add(cmbComuneNascita);
        }
    }
}