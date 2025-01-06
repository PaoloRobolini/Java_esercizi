package org.example.graficatennisfx;

public class GestisciGame {

    int max;

    int gameG1;
    int gameG2;

    public GestisciGame() {
        this.gameG1 = 0;
        this.gameG2 = 0;
        this.max = 5;
    }

    public void aggiungiGame1(){
        this.gameG1++;
    }

    public void aggiungiGame2(){
        this.gameG2++;
    }

    public void resettaPunti(){
        this.gameG1 = 0;
        this.gameG2 = 0;
        this.max = 5;
    }

    //PUNTI: 0 = 0, = 15, 2 = 30, 3 = 40, 4 = vittoria, da 5 in poi vantaggi
    public String getStatoGame(){
        if(max == 5){       //se non ci sono ancora i vantaggi
            if(this.gameG1 >= 4){
                if(this.gameG2 < 3){
                    return "G1";
                } else {
                    max++;
                }
            } else if (this.gameG2 >= 4){
                if(this.gameG1 < 3){
                    return "G2";
                } else{
                     max++;
                }
            }
            return "in corso";
        } else {
            if (this.gameG1 > this.gameG2 + 1){
                return "G1";
            } else if (this.gameG2 > this.gameG1 + 1){
                return "G2";
            } else if (this.gameG1 == this.gameG2){
                max++;
            }
        }
        return "spareggio";
    }

    public String convertiPuntiG1(){
        String stato = this.getStatoGame();
        String punti;
        if(stato.equals("in corso")){ //no vantaggi
            punti = switch (this.gameG1) {
                case 1 -> "15";
                case 2 -> "30";
                case 3 -> "40";
                default -> "0";
            };
            if(this.gameG1 == 3 && this.gameG2 == 3){
                return "Pareggio";
            } else {
                return "Game: " + punti;
            }
        } else if(this.gameG1 == this.gameG2){  //vantaggi
            return "Pareggio";
        } else {
            if(this.gameG1 > this.gameG2){
                return "Vantaggio";
            } else {
                return "Svantaggio";
            }
        }
    }

    public String convertiPuntiG2(){
        String stato = this.getStatoGame();
        String punti;
        if(stato.equals("in corso")){ //no vantaggi
            punti = switch (this.gameG2) {
                case 1 -> "15";
                case 2 -> "30";
                case 3 -> "40";
                default -> "0";
            };
            if(this.gameG1 == 3 && this.gameG2 == 3){
                return "Pareggio";
            } else {
                return "Game: " + punti;
            }
        } else if(this.gameG1 == this.gameG2){  //vantaggi
                return "Pareggio";
            } else {
                if(this.gameG1 > this.gameG2){
                    return "Svantaggio";
                } else {
                    return "Vantaggio";
                }
            }
        }

    //PUNTI: 0 = 0, 1 = 15, 2 = 30, 3 = 40, 4 = vittoria, da 5 in poi vantaggi

    @Override
    public String toString() {
        String puntiG1 = "0";
        String puntiG2 = "0";
        String stato = this.getStatoGame();
        if(stato.equals("in corso")){ //no vantaggi
            puntiG1 = switch (this.gameG1) {
                case 1 -> "15";
                case 2 -> "30";
                case 3 -> "40";
                case 4 -> "G1";
                default -> puntiG1;
            };
            puntiG2 = switch (this.gameG2) {
                case 1 -> "15";
                case 2 -> "30";
                case 3 -> "40";
                case 4 -> "G2";
                default -> puntiG2;
            };
            return puntiG1 + " - " + puntiG2;
        } else if (stato.equals("G1")){ //vittoria g1
            return "G1";
        } else if (stato.equals("G2")){ //vittoria g2
            return "G2";
        } else {
            if(this.gameG1 == this.gameG2){  //vantaggi
                return "Vantaggio 0";
            } else {
                if(this.gameG1 > this.gameG2){
                    return "Vantaggio G1";
                } else {
                    return "Vantaggio G2";
                }

            }
        }
    }
}
