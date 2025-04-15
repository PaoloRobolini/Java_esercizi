import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PseudoAI {
    private HashMap<ArrayList<String>, ArrayList<String>> mappa;
    private final String percorsoFile = "diario_di_un_naturalista_darwin.txt";

    public PseudoAI() {
        try {

            this.mappa = new HashMap<>();

            FileReader fr = new FileReader(percorsoFile);
            BufferedReader br = new BufferedReader(fr);

            StringBuilder sb = new StringBuilder();
            String riga;

            while((riga = br.readLine()) != null){
                sb.append(riga);
            }

            br.close();
            fr.close();

            String s = sb.toString();
            ArrayList<String> parole = new ArrayList<>();
            parole.addAll(List.of(s.split(" ")));

            String parola1, parola2;

            for(int i = 0; i < parole.size() - 3; i++){
                parola1 = parole.get(i);
                parola2 = parole.get(i + 1);

                ArrayList<String> chiave = new ArrayList<>();
                chiave.add(parola1);
                chiave.add(parola2);

                ArrayList<String> valori = new ArrayList<>();
                valori.add(parole.get(i + 2));
                valori.add(parole.get(i + 3));

                try {
                    mappa.get(chiave).addAll(valori);
                } catch (NullPointerException e) {
                    mappa.put(chiave, valori);
                }
                //System.out.println("Chiave: " + chiave + "; Valori: " + valori);
            }
            System.out.println(mappa);
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato (" + e.getMessage() + ")");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void generaN(int n){
        for(int i = 0; i < n; i++){

        }
    }
}
