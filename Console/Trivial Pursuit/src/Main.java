import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int N = 5;
        boolean vuoiRigiocare = true;
        Scanner in = new Scanner(System.in);

        try{
            Gioco gioco = new Gioco("src\\gioco.txt");

            while(vuoiRigiocare){
                System.out.println("BENVENUTO NEL GIOCO! BUONA FORTUNA E BUON DIVERTIMENTO! \n");

                int risposte_corrette = 0;

                for (int i = 1; i <= N; i++) {

                    Scheda domanda = gioco.estrai();

                    System.out.println(domanda.toString(i));

                    int risposta = in.nextInt();

                    if(domanda.isCorretta(risposta)){
                        risposte_corrette++;
                        System.out.println("ora ne hai indovinate " + risposte_corrette);
                    }
                }

                System.out.println("IL GIOCO È TERMINATO! Hai indovinato " + risposte_corrette + " domande su " + N);

                System.out.println("Vuoi rigiocare? (SI/NO)");

                vuoiRigiocare = in.next().equals("SI");
            }
        } catch (FileNonValido e) {

            System.out.println("Il formato del file non è valido. Controllare il suo contenuto");

        } catch (IOException e){

            System.out.println("Il file non è stato trovato.");

        }
        if(!vuoiRigiocare){
            System.out.println("Buonasera e arrivederci!");
        }
    }
}
