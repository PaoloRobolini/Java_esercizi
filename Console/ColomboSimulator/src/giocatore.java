public class giocatore {
    private final String nome;
    private int punti;

    private int game;

    private int set;
    private int match;
    private boolean vincitore;

    public giocatore (String nome){
        this.nome = nome;
        this.punti = 0;
        this.game = 0;
        this.set = 0;
        this.match = 0;
        this.vincitore = false;
    }

    public void resettaPunti(){
        punti = 0;
    }

    public int getPunti() {
        return punti;
    }

    public int getGame() {
        return game;
    }
    public void aggiungiSet(){
        set++;
        game = 0;
        punti = 0;
    }
    public void aggiungiPunto(){
        punti++;
    }
    public void aggiungiGame(){
        game++;
        punti = 0;
    }
    public void aggiungiMatch(){
        match++;
        punti = 0;
    }
    public void resettaTutto(){
        punti = 0;
        set = 0;
        game = 0;
        match = 0;
        vincitore = false;
    }

    public void resettaSet(){
        punti = 0;
        game = 0;
        set = 0;
    }
    public void resettaGame(){
        punti = 0;
        game = 0;
    }

    public String getNome() {
        return nome;
    }


    public int getSet() {
        return set;
    }

    public boolean isVincitore() {
        return vincitore;
    }

    public int getMatch() {
        return match;
    }
}
