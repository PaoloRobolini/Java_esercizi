package robolini.paolo.radiobutton;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class DadiController {

    @FXML
    public RadioButton rdbUno;
    public RadioButton rdbDue;
    public RadioButton rdbTre;

    @FXML
    private Label lblRisultatoDadi;

    private final LanciatoreDadi dadi = new LanciatoreDadi(6);

    @FXML
    private void initialize(){

    }

    @FXML
    protected void onTiraButtonClick() {

        int quanti_dadi = 1;

        if (rdbDue.isSelected()){
            quanti_dadi = 2;
        } else if (rdbTre.isSelected()){
            quanti_dadi = 3;
        }

        lblRisultatoDadi.setText(dadi.lancia(quanti_dadi));

    }
}