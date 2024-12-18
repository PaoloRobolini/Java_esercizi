package robolini.paolo.pallavolo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PallavoloController {

   public Partita partita;
    public Label lblTrasferta, lblCasa;
    public Label lblSetTrasferta, lblSetCasa;

    @FXML
    public void initialize(){
        partita = new Partita(5);
    }

    private void aggiornaLabel(){
        lblCasa.setText(partita.getPuntiCasa());
        lblSetCasa.setText(partita.getSetCasa());
        lblTrasferta.setText(partita.getPuntiTrasferta());
        lblSetTrasferta.setText(partita.getSetTrasferta());
    }

    public void btnTrasfertaOnClick(ActionEvent actionEvent) {
        partita.incrementaTrasferta();
        aggiornaLabel();
    }

    public void btnCasaOnClick(ActionEvent actionEvent) {
        partita.incrementaCasa();
       aggiornaLabel();
    }

}