public class partita {
    private giocatore G1;
    private giocatore G2;

    public partita(giocatore giocatore1, giocatore giocatore2){
        G1 = giocatore1;
        G2 = giocatore2;
    }
    public void aggiungiPunto(String nome_giocatore){
        if(nome_giocatore.equals(G1.getNome())){
            G1.aggiungiPunto();
        } else if(nome_giocatore.equals(G2.getNome())){
            G2.aggiungiPunto();
        }
        aggiornaSet();
    }
    /* CONVERSIONE PUNTI
    0 = 0
    1 = 15
    2 = 30
    3 = 40
    4 = VANTAGGIO
     */

    private int ChihaVintoGame(){ //0 = nessuno, 1 = G1, 2 = G2
        if(G1.getPunti() >= 4 && G2.getPunti() < 4){
            return 1;
        } else if(G1.getPunti() > G2.getPunti() + 1){
            return 1;
        } else if(G2.getPunti() >= 4 && G1.getPunti() < 4){
            return 2;
        } else if(G2.getPunti() > G1.getPunti() + 1){
            return 2;
        }
        return 0;
    }

    private int ChihaVintoSet(){ //0 = nessuno, 1 = G1, 2 = G2
        if(G1.getGame() > 5 && G2.getGame() < 5){
            return 1;
        } else if (G1.getGame() > 6 && G2.getGame() == 5){
            return 1;
        } else if (G1.getGame() == 6 && G2.getGame() == 6){
            if(G1.getPunti() > G2.getPunti() + 1){
                return 1;
            } else if (G2.getPunti() > G1.getPunti() + 1){
                return 2;
            }
        } else if(G2.getGame() > 5 && G1.getGame() < 5){
            return 2;
        } else if (G2.getGame() > 6 && G1.getGame() == 5){
            return 2;
        }
        return 0;
    }

    private void aggiornaSet(){
        if(ChihaVintoGame() == 1){
            G1.aggiungiGame();
            G2.resettaPunti();
        } else if (ChihaVintoGame() == 2){
            G2.aggiungiGame();
            G1.resettaPunti();
        }
    }
    private void aggiornaPartita(){
        if(G1.getSet() > 5 && G2.getSet() < 5){
            G1.aggiungiSet();
            G2.resettaSet();
        } else if(G2.getSet() > 5 && G1.getSet() < 5){
            G2.aggiungiSet();
            G1.resettaSet();
        }
    }
}

