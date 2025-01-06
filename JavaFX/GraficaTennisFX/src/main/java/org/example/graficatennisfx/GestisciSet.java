package org.example.graficatennisfx;

import org.example.graficatennisfx.GestisciGame;

public class GestisciSet {
    private int setG1;
    private int setG2;
    private int puntiG1;
    private int puntiG2;

    public GestisciSet(){
        setG1 = 0;
        setG2 = 0;
        puntiG1 = 0;
        puntiG2 = 0;
    }

    public void aggiungiPuntoG1(){
        puntiG1++;
    }

    public void aggiungiPuntoG2(){
        puntiG2++;
    }

    public String assegnaVittoria(){
        if(this.setG1 >= 2){
            return "G1";
        } else if (this.setG2 >= 2){
            return "G2";
        }
        return "";
    }

    public void aggiornaPunti(){
        String vincitoreSet = "";
        if(puntiG1 == 6){
            if (puntiG2 < 5){
                vincitoreSet = "G1";
            }
        } else if (puntiG2 == 6){
            if (puntiG1 < 5){
                vincitoreSet = "G2";
            }
        } else if (puntiG1 > 6 && puntiG2 > 6){
            if(puntiG1 > puntiG2 + 1){
                vincitoreSet = "G1";
            } else if (puntiG2 > puntiG1 + 1){
                vincitoreSet = "G2";
            }
        }
        if(!vincitoreSet.isEmpty()){
            puntiG1 = 0;
            puntiG2 = 0;
            if(vincitoreSet.equals("G1")){
                setG1++;
            } else {
                setG2++;
            }
        }
    }

    public String getSetG1(){
        return "Set: " + setG1 + ", Punti: " + puntiG1;
    }

    public String getSetG2(){
        return "Set: " + setG2 + ", Punti: " + puntiG2;
    }

    @Override
    public String toString() {
        return getSetG1() + "; " + getSetG2();
        }

}
