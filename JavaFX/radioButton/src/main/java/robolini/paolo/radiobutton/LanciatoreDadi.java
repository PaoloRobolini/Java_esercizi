package robolini.paolo.radiobutton;

public class LanciatoreDadi {

    private final int FACCE;
    public LanciatoreDadi(int n_facce){
        FACCE = n_facce;
    }

    public String lancia(int quantiDadi){
        int risultato = 0;

        for(int i = 0; i < quantiDadi; ++i){
            risultato += (int) (Math.random() * FACCE) + 1;
        }
        return Integer.toString(risultato);
    }
}
