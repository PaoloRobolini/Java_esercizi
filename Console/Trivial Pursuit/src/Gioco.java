import java.io.*;
import java.util.ArrayList;

public class Gioco  {

    ArrayList<Scheda> schede;

    public Gioco(String percorsoFile) throws IOException, FileNonValido{
        schede = new ArrayList<>();
        FileReader fr = new FileReader(percorsoFile);
        BufferedReader br = new BufferedReader(fr);
        String riga = br.readLine();
        if(riga.equals("INIZIAMO")){
            riga = br.readLine();
            int nSchede = Integer.parseInt(riga);
            for (int i = 0; i < nSchede; i++) {
                String riga1 = br.readLine();
                String riga2 = br.readLine();
                schede.add(new Scheda(riga1,riga2));
            }
        } else {
            throw new FileNonValido();
        }
    }

    public int random(){
        return (int)(Math.random()* schede.size());
    }

    public boolean is_tutto_usato(){
        for(var i : schede){
            if(!i.is_usata()){
                return false;
            }
        }
        return true;
    }

    public Scheda estrai(){

        Scheda ritorno = schede.get(random());

        while(ritorno.is_usata()){
            if(is_tutto_usato()){
                resetGioco();
            }
           ritorno = schede.get(random());
        }
        return ritorno;
    }

    public void resetGioco(){
        for(var i : schede){
            i.reset();
        }
    }
}
