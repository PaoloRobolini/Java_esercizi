package robolini.paolo.codicefiscale;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe che calcola il codice fiscale
 */
public class codiceFiscaleCalcolatore {

    private String nome;
    private String cognome;
    private final LocalDate dataDiNascita;
    private final boolean isMaschio;
    private final String luogoNascita;
    private final HashMap<String, String> luoghiNascitaRepository;

    /**
     * Costruttore del codice fiscale
     * @param nome Nome della persona
     * @param cognome Cognome della persona
     * @param dataDiNascita Data di nascita della persona in formato GG/MM/AAAA
     * @param isMaschio Il sesso della persona
     * @param luogoNascita Dove è nata la persona
     * @param nomeFile Il nome del file da cui prende il "codice di nascita"
     * @throws IOException Eccezione lanciata se non trova il file csv da cui prende il "codice di nascita"
     */
    public codiceFiscaleCalcolatore(String nome, String cognome, LocalDate dataDiNascita, boolean isMaschio,
                                    String luogoNascita, String nomeFile, boolean isNatoEstero)
            throws IOException {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.isMaschio = isMaschio;
        this.luogoNascita = luogoNascita;
        if (isNatoEstero){
            this.luoghiNascitaRepository = LuoghiNascitaRepository.getInstanceStati(nomeFile);
        } else {
            this.luoghiNascitaRepository = LuoghiNascitaRepository.getInstanceComuni(nomeFile);
        }

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

    private Map<String,ArrayList<Character>> dividiVocaliConsonanti(String s){
        StringBuilder stringBuilder
                = new StringBuilder();
        s = rimuoviSpazi(s);
        s = s.toUpperCase();
        char c;
        Map<String,ArrayList<Character>> ritorno = new HashMap<>();
        ArrayList<Character> consonanti = new ArrayList<>();
        ArrayList<Character> vocali = new ArrayList<>();

        for(int i = 0; i < s.length(); ++i){
            c = s.charAt(i);
            if(isVocale(c)){
                vocali.add(c);
            } else {
                consonanti.add(c);
            }
        }
        ritorno.put("consonanti", consonanti);
        ritorno.put("vocali", vocali);
        return ritorno;
    }

    private String calcolaCognome (){

        Map<String,ArrayList<Character>> temp = dividiVocaliConsonanti(cognome);

        ArrayList<Character> consonanti = temp.get("consonanti");
        ArrayList<Character> vocali = temp.get("vocali");

        StringBuilder ritorno = new StringBuilder();

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

        Map<String,ArrayList<Character>> temp = dividiVocaliConsonanti(nome);

        ArrayList<Character> consonanti = temp.get("consonanti");
        ArrayList<Character> vocali = temp.get("vocali");

        StringBuilder ritorno = new StringBuilder();

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

    private String calcolaLuogoNascita(){
            return luoghiNascitaRepository.get(luogoNascita);
    }

    public String getCodiceFiscaleParziale(){
        return calcolaCognome() + calcolaNome() + calcolaData() + calcolaLuogoNascita();
    }

    public char calcolaCarattereControllo() {
        String codiceFiscaleParziale = getCodiceFiscaleParziale();
        System.out.println("codice parziale: " + codiceFiscaleParziale);

        // Mappatura dei valori per posizioni dispari
        int[] valoriDispari = {1, 0, 5, 7, 9, 13, 15, 17, 19, 21,
                1, 0, 5, 7, 9, 13, 15, 17, 19, 21,
                1, 0, 5, 7, 9, 13, 15, 17, 19, 21,
                1, 0, 5, 7, 9, 13, 15, 17, 19, 21};

        // Mappatura dei valori per posizioni pari
        int[] valoriPari = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25};

        int somma = 0;
        for (int i = 0; i < codiceFiscaleParziale.length(); i++) {
            char carattere = codiceFiscaleParziale.charAt(i);
            int valore;
            if (Character.isDigit(carattere)) {
                valore = carattere - '0'; // Converti in numero
            } else {
                valore = carattere - 'A'; // Converti in indice (A=0, ..., Z=25)
            }

            if ((i + 1) % 2 == 0) { // Posizione pari (1-based)
                somma += valoriPari[valore];
            } else { // Posizione dispari (1-based)
                somma += valoriDispari[valore];
            }
        }
        int resto = somma % 26;
        return (char) ('A' + resto);
    }

    public String calcolaCodiceFiscaleCompleto(){
        return getCodiceFiscaleParziale() + calcolaCarattereControllo();
    }


}
