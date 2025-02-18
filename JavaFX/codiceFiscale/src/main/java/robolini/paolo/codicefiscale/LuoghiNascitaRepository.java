package robolini.paolo.codicefiscale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LuoghiNascitaRepository {

    static private HashMap<String, String> comuni;
    static private HashMap<String, String> stati;

    private LuoghiNascitaRepository() {

    }

    static public HashMap<String, String> getInstanceComuni(String nomeFile) throws IOException {
        if (comuni == null) {
            comuni = new HashMap<>();

            FileReader fr = new FileReader(nomeFile);
            BufferedReader br = new BufferedReader(fr);

            String riga;

            while ((riga = br.readLine()) != null) {
                String[] s = riga.split(";");
                comuni.put(s[0].toUpperCase(), s[1].toUpperCase());
            }

        }
        return comuni;
    }

    static public HashMap<String, String> getInstanceStati(String nomeFile) throws IOException {
        if (stati == null) {
            stati = new HashMap<>();

            FileReader fr = new FileReader(nomeFile);
            BufferedReader br = new BufferedReader(fr);

            String riga;

            while ((riga = br.readLine()) != null) {
                String[] s = riga.split(";");
                stati.put(s[0].toUpperCase(), s[1].toUpperCase());
            }

        }
        return stati;
    }

}
