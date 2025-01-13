package robolini.paolo.testivari;

public class CodiceFiscale {
    private String nome;
    private String cognome;

    public CodiceFiscale(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }

    private String codificaNome(){
        return "" + nome.charAt(0) + nome.charAt(1) + nome.charAt(3);
    }

    public String calcola(){
        return codificaNome();
    }
}
