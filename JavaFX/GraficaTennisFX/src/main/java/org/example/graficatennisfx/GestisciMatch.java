package org.example.graficatennisfx;

import java.util.ArrayList;

public class GestisciMatch {
    private ArrayList<String> parziali;
    //si presuppone una partita al meglio delle 3

    public GestisciMatch() {
        this.parziali = new ArrayList<>();
        this.parziali.add("Punteggi Parziali:");
    }

    public void aggiungiParziale(String punteggio){
        parziali.add(punteggio);
    }

    public void reset(){
        parziali.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String i : parziali){
            sb.append(i).append("\n");
        }
        return sb.toString();
    }
}
