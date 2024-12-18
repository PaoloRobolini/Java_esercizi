public class orologioDigitale {
    private int oreSveglia, minutiSveglia;
    private int oreOrario, minutiOrario;
    private int stato; //0 = visualizza ora, 1 = imposta orario, 2 = imposta sveglia

    public orologioDigitale(){
        this.oreOrario = 0;
        this.minutiOrario = 0;
        this.stato = 0;
        this.minutiSveglia = 0;
        this.oreSveglia = 0;
    }

    public orologioDigitale (int ore, int minuti){
        this();
        this.minutiOrario = minuti;
        this.oreOrario = ore;
    }

    public void impostaOrario(){
        if(stato != 1){
            stato = 1;
        } else {
            stato = 0;
        }
    }

    public void impostaSveglia(){
        if(stato != 2){
            stato = 2;
        } else {
            stato = 0;
        }
    }

    private void correggiRiporto(){
        if(minutiSveglia >= 60){
            minutiSveglia %= 60;
            oreSveglia++;
        }
        if(minutiOrario>= 60){
            minutiOrario %= 60;
            oreOrario++;
        }
        oreOrario %= 24;
        oreSveglia %= 24;
    }

    public void setOre(){
        if(stato == 1){
            oreOrario++;
        } else if(stato == 2){
            oreSveglia++;
        }
        this.correggiRiporto();
    }

    public void setMinuti(){
        if(stato == 1){
            minutiOrario++;
        } else if(stato == 2){
            minutiSveglia++;
        }
        this.correggiRiporto();
    }

    private String modeToString(){
        String ritorno = "L'orologio e' settato in modalita' ";
        if(stato == 1){
            ritorno+= "visualizza orario";
        } else if (stato == 2){
            ritorno+= "imposta sveglia";
        } else {
            ritorno+= "normale";
        }
        return ritorno + "\n";
    }

    private String orarioToString(){
        String ritorno = "Sono le ore ";
        if(oreOrario < 10){
            ritorno+='0';
        }
        ritorno+= oreOrario + ":";
        if(minutiOrario < 10){
            ritorno+='0';
        }
        return ritorno + minutiOrario + "\n";
    }

    private String svegliaToString(){
        String ritorno = "Sveglia impostata per le ore ";
        if(oreSveglia < 10){
            ritorno+='0';
        }
        ritorno+= oreSveglia + ":";
        if(minutiSveglia < 10){
            ritorno+='0';
        }
        return ritorno + minutiSveglia + "\n";
    }

    @Override
    public String toString(){
        return modeToString() + orarioToString() + svegliaToString();
    }
    //setSveglia è un metodo utilizzato puramente per scopo di testing
    public void setSveglia(int ore, int minuti){
        oreSveglia = ore;
        minutiSveglia = minuti;
        correggiRiporto();
    }

}
