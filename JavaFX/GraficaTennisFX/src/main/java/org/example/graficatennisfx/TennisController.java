package org.example.graficatennisfx;

import javafx.fxml.FXML;
import java.awt.event.ActionEvent;
import javafx.scene.control.Label;

public class TennisController {

    public GestisciGame gestisciGame;
    public GestisciMatch gestisciMatch;
    public GestisciSet gestisciSet;

    @FXML
    public Label lblMatchG1;
    public Label lblMatchG2;
    public Label lblSetG2;
    public Label lblSetG1;
    public Label lblGameG1;
    public Label lblGameG2;

    @FXML
    public void initialize() {
        gestisciGame = new GestisciGame();
        gestisciSet = new GestisciSet();
        gestisciMatch = new GestisciMatch();
    }

    private void aggiornaPunteggi(){
        if(gestisciGame.getStatoGame().equals("G1")){
            gestisciGame.resettaPunti();
            gestisciSet.aggiungiPuntoG1();
            gestisciMatch.aggiungiParziale(gestisciSet.toString());
        } else if(gestisciGame.getStatoGame().equals("G2")){
            gestisciGame.resettaPunti();
            gestisciSet.aggiungiPuntoG2();
            gestisciMatch.aggiungiParziale(gestisciSet.toString());
        }
        gestisciSet.aggiornaPunti();
        if(gestisciSet.assegnaVittoria().equals("G1")){
            lblMatchG1.setText("VITTORIA");
            lblMatchG2.setText("SCONFITTA");
            System.out.println(gestisciMatch.toString());
            gestisciMatch.reset();
        } else if (gestisciSet.assegnaVittoria().equals("G2")){
            lblMatchG2.setText("VITTORIA");
            lblMatchG1.setText("SCONFITTA");
            System.out.println(gestisciMatch.toString());
            gestisciMatch.reset();
        }
        lblGameG1.setText(gestisciGame.convertiPuntiG1());
        lblGameG2.setText(gestisciGame.convertiPuntiG2());
        lblSetG1.setText(gestisciSet.getSetG1());
        lblSetG2.setText(gestisciSet.getSetG2());
    }

    public void btnAggiungiPuntoG1(javafx.event.ActionEvent actionEvent) {
        gestisciGame.aggiungiGame1();
        aggiornaPunteggi();
    }

    public void btnAggiungiPuntoG2(javafx.event.ActionEvent actionEvent) {
        gestisciGame.aggiungiGame2();
        aggiornaPunteggi();
    }
}