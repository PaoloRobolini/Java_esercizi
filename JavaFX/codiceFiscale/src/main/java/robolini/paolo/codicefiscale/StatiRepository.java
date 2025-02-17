package robolini.paolo.codicefiscale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class StatiRepository {
    static private HashMap<String, String> stati;

    private StatiRepository(){

    }

    static public HashMap<String, String> getInstance(String nomeFile) throws IOException {
        if (stati == null) {
            stati = new HashMap<>();

            FileReader fr = new FileReader(nomeFile);
            BufferedReader br = new BufferedReader(fr);

            String riga;

            while((riga = br.readLine()) != null){
                String[] s = riga.split(",");
                stati.put(s[0].toUpperCase(), s[1].toUpperCase());
            }

        }
        return stati;
    }

    /*
      static public Set<String> getElencoStati(){
        return stati.keySet();
    } */

}
