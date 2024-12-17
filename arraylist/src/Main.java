import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Lampadina> v; //array di lampadine
        v = new ArrayList<>(); //creazione dell'oggetto di tipo ArrayList
        //da questo momento nell'heap esiste un oggetto che rappresenta un vettore di lampadine, al momento vuoto
        Lampadina l = new Lampadina("prova1","colore1");

        v.add(l);
        v.add(new Lampadina("prova2","colore2"));

        for (var i : v) {
            i.accendi();
        }
        for(var i : v){
            System.out.println(i);
        }


        System.out.println("_____________________________________________________\n");

        l.spegni();
        for(var i : v){
            System.out.println(i);
        }

        System.out.println("_____________________________________________________\n");

        for (Lampadina L1: v) {
            System.out.println(L1);
        }

        for (Lampadina L1:
             v) {
            L1.spegni();
        }



        System.out.println("_____________________________________________________\n");

        System.out.println(v); //ogni arraylist ha il proprio metodo toString che stampa nella forma "[elemento0], [elemento1[], ecc."

        //ArrayList<int> arrayList; NON ESISTE. le arraylist non contengono tipi di dati primitivi, ma solamente oggetti
        //perciò:
        ArrayList<Integer> vi = new ArrayList<>();
        Integer integer = 5;
        //classe wrapper "involtino" che svolge le stesse funzioni
        
        for(int i = 0; i < 10; ++i) {
            vi.add(i);
        }

        //fine main
    }
}