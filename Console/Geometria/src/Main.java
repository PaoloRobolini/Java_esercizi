import Robolini.Paolo.Punto;
import Robolini.Paolo.Segmento;
import graphics.Color;
import graphics.Line;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Line ASCISSE = new Line(0,500,1900,500);
        final Line ORDINATE = new Line(950,0, 950,1000);
        ASCISSE.draw();
        ORDINATE.draw();

        Segmento s = new Segmento(new Punto(20,20), new Punto(500,500));
        Segmento s1 = new Segmento(new Punto(0,0), new Punto(500,400));
        s.disegna();
        Scanner in = new Scanner(System.in);
        String str;
        str = in.next();
        System.out.println(s.getPunto1().toString() + s.getPunto2().toString());
        s.setColore(new Color(255,0,0));
        s.ruotaSegmentoEstremo(15,s.getPunto2());
        System.out.println(s.getPunto1().toString() + s.getPunto2().toString());
        s.disegna();
    }
}
