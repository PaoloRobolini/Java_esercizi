package robolini.paolo.codicefiscale;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class codiceFiscaleCalcolatore {

    private String nome;
    private String cognome;
    private final LocalDate dataDiNascita;
    private final boolean isMaschio;
    private final String luogoNascita;
    private final HashMap<String, String> comuni;
    private final HashMap<String, String> stati;
    private final boolean isNatoEstero;


    public codiceFiscaleCalcolatore(String nome, String cognome, LocalDate dataDiNascita, boolean isMaschio,String luogoNascita,
                                    boolean natoEstero, String nomeFileComuni, String nomeFileStati)
            throws IOException {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.isMaschio = isMaschio;
        this.luogoNascita = luogoNascita;
        this.isNatoEstero = natoEstero;
        this.comuni = ComuniRepository.getInstance(nomeFileComuni);
        this.stati = StatiRepository.getInstance(nomeFileStati);
    }

    private String rimuoviSpazi (String s){
        StringBuilder ritorno = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) != ' '){
                ritorno.append(s.charAt(i));
            }
        }
        return  ritorno.toString();
    }

    private boolean isVocale(char c){
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    private String calcolaCognome (){
        StringBuilder ritorno = new StringBuilder();
        cognome = rimuoviSpazi(cognome);
        cognome = cognome.toUpperCase();
        char c;

        ArrayList<Character> consonanti = new ArrayList<>();
        ArrayList<Character> vocali = new ArrayList<>();

        for(int i = 0; i < cognome.length(); ++i){
            c = cognome.charAt(i);
            if(isVocale(c)){
                vocali.add(c);
            } else {
                consonanti.add(c);
            }
        }

        for (Character i : consonanti){
            ritorno.append(i);
        }

        for (Character i: vocali) {
            ritorno.append(i);
        }

        System.out.println("cognome: " + ritorno);

        return ritorno.substring(0,3);

    }

    private String calcolaNome (){
        StringBuilder ritorno = new StringBuilder();
        nome = rimuoviSpazi(nome);
        nome = nome.toUpperCase();
        char c;

        ArrayList<Character> consonanti = new ArrayList<>();
        ArrayList<Character> vocali = new ArrayList<>();

        for(int i = 0; i < nome.length(); ++i){
            c = nome.charAt(i);
            if(isVocale(c)){
                vocali.add(c);
            } else {
                consonanti.add(c);
            }
        }

            ritorno.append(consonanti.get(0));
            ritorno.append(consonanti.get(1));

        try{
            ritorno.append(consonanti.get(3));
        } catch (IndexOutOfBoundsException e){
            try {
                ritorno.append(consonanti.get(2));
            } catch (IndexOutOfBoundsException e2){
              ritorno.append(vocali.get(0));
            }
        }

        System.out.println("Nome: " + ritorno);

        return ritorno.substring(0,3);
    }

    private String calcolaData(){
        int giorno = dataDiNascita.getDayOfMonth();
        int mese = dataDiNascita.getMonthValue();
        String anno = Integer.toString(dataDiNascita.getYear());

        //System.out.println("giorno:" + giorno + " mese: " + mese + " anno:" + anno);

        StringBuilder ritorno = new StringBuilder();
        ritorno.append(anno.charAt(2));
        ritorno.append(anno.charAt(3));
        System.out.println(ritorno);

        String corrispondenzaMeseLettera = "ABCDEHLMPRST";

        ritorno.append(corrispondenzaMeseLettera.charAt(mese - 1));

        //System.out.println("con mese: " + ritorno);

        if (!this.isMaschio){
            giorno += 40;
        } else if (giorno <= 9){
            ritorno.append('0');
        }

        ritorno.append(giorno);

        System.out.println("Data: " + ritorno);

        return ritorno.toString();
    }

    private String calcolaLuogo(){
        if (this.isNatoEstero)
            return stati.get(luogoNascita);
        else
            return comuni.get(luogoNascita);
    }

    public String getCodiceFiscaleParziale(){
        return calcolaCognome() + calcolaNome() + calcolaData() + calcolaLuogo();
    }

    public char calcolaCarattereControllo() {
        String codiceFiscaleSenzaControllo = getCodiceFiscaleParziale();
        if (codiceFiscaleSenzaControllo == null || codiceFiscaleSenzaControllo.length() != 15) {
            throw new IllegalArgumentException("Il codice fiscale deve essere lungo 15 caratteri.");
        }

        String valoriPari = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] valoriDispari = {
                1, 0, 5, 7, 9, 13, 15, 17, 19, 21,
                1, 0, 5, 7, 9, 13, 15, 17, 19, 21,
                1, 0, 5, 7, 9, 13, 15, 17, 19, 21,
                1, 0, 5, 7, 9, 13
        };

        int somma = 0;
        for (int i = 0; i < 15; i++) {
            char c = codiceFiscaleSenzaControllo.charAt(i);
            int valore = valoriPari.indexOf(c);

            if (valore == -1) {
                throw new IllegalArgumentException("Carattere non valido nel codice fiscale.");
            }

            if (i % 2 == 0) {
                somma += valoriDispari[valore];
            } else {
                somma += valore;
            }
        }

        int resto = somma % 26;
        return (char) ('A' + resto);
    }

    public String calcolaCodiceFiscaleCompleto(){
        return getCodiceFiscaleParziale() + calcolaCarattereControllo();
    }

    public Set<String> getElencoComuni (){
        return this.comuni.keySet();
    }

    public Set<String> getStati() {
        return stati.keySet();
    }
}
