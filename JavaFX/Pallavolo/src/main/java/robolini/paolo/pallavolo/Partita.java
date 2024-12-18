package robolini.paolo.pallavolo;

public class Partita {

    private int puntiCasa;
    private int puntiTrasferta;
    private int setCasa;
    private int setTrasferta;
    private int MAX;

    public Partita(int MAX){
        this.puntiCasa = 0;
        this.puntiTrasferta = 0;
        this.setCasa = 0;
        this.setTrasferta = 0;
        this.MAX = MAX;
    }

    public void incrementaCasa(){
        puntiCasa++;

        if(puntiCasa == MAX){
            puntiCasa = 0;
            puntiTrasferta = 0;
            setCasa++;
        }

    }
    public void incrementaTrasferta(){
        puntiTrasferta++;

        if(puntiTrasferta == MAX){
            puntiTrasferta = 0;
            puntiCasa = 0;
            setTrasferta++;
        }

    }

    public String getPuntiCasa() {
        return "" + puntiCasa;
    }

    public String getPuntiTrasferta() {
        return "" + puntiTrasferta;
    }

    public String getSetCasa() {
        return "Set: " + setCasa;
    }

    public String getSetTrasferta() {
        return "Set: " + setTrasferta;
    }
}
