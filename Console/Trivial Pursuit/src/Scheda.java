import java.io.*;
import java.util.ArrayList;

public class Scheda {

    private String domanda;
    private ArrayList<String> risposte;
    private boolean is_usata;
    private int corretta;
    //La risposta corretta non è l'indice della stringa risposta nell'arraylist, ma il numero della posizione secondo l'utente (1,2,3,4)

    public Scheda (String riga1, String riga2) throws FileNonValido {
        if(riga1.charAt(riga1.length() - 1) == '?'){
            domanda = riga1;
            String[] v = riga2.split(";");
            risposte = new ArrayList<>();
            if(v.length != 5){
                throw new FileNonValido();
            } else {
                for (int i = 0; i < v.length - 1; i++) {
                    risposte.add(v[i]);
                }
                corretta = Integer.parseInt(v[4]);
                is_usata = false;
            }
        } else {
            throw new FileNonValido();
        }
    }

    public boolean is_usata() {
        return is_usata;
    }

    public boolean isCorretta(int risposta){
        this.is_usata = true;
        if(risposta != corretta){
            System.out.println("Hai sbagliato! La risposta giusta era " + corretta + ") " + risposte.get(corretta - 1));
            return false;
        } else {
            System.out.println("Risposta esatta!");
            return true;
        }
    }

    public void reset(){
        this.is_usata = false;
    }

    public String toString(int indice){
        String ritorno = "Domanda numero " + indice + ": " + domanda + '\n';
        for (int i = 0; i < risposte.size(); i++) {
            ritorno += (i + 1) + ") " + risposte.get(i);
            if(i != risposte.size() - 1){
                ritorno += '\n';
            }
        }
        return ritorno;
    }
}
