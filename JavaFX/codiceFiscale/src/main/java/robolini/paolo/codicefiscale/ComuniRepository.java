package robolini.paolo.codicefiscale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class ComuniRepository {
    static private HashMap<String, String> comuni;

    private ComuniRepository(){

    }

    static public HashMap<String, String> getInstance(String nomeFile) throws IOException {
        if (comuni == null) {
            comuni = new HashMap<>();

            FileReader fr = new FileReader(nomeFile);
            BufferedReader br = new BufferedReader(fr);

            String riga;

            while((riga = br.readLine()) != null){
                String[] s = riga.split(";");
                comuni.put(s[0], s[1]);
            }

        }
        return comuni;
    }
    static public Set<String> getElencoComuni(){
        return comuni.keySet();
    }
}
