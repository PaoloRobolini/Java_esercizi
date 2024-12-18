package Robolini.Paolo;

import graphics.Line;

import java.util.ArrayList;

public class LineaSpezzata {

    ArrayList<Punto> punti;
    ArrayList<Line> linee;
    boolean aperta;

    public LineaSpezzata(Punto p1, Punto p2, Punto p3){
        punti = new ArrayList<Punto>();
        linee = new ArrayList<Line>();
        aggiungiPunto(p1);
        aggiungiPunto(p2);
        aggiungiPunto(p3);
        costrusciArrayLine();
        aperta = true;
    }

    public void aggiungiPunto(Punto p){
        punti.add(p);

        if(punti.size() > 1){
            Punto ultimoPunto = punti.get(punti.size()-1);
            if(aperta){
                linee.add(new Line(ultimoPunto.getX(), ultimoPunto.getY(), p.getX(),p.getY()));
            }
        }
    }

    private void costrusciArrayLine(){
        linee = null;
        linee = new ArrayList<Line>();
        if(!aperta){
            linee.add(new Line(punti.get(0).getX(),punti.get(0).getY(),punti.get(1).getX(),punti.get(1).getY()));
        }
        for (int i = 1; i < punti.size()-1; i++) {
            Punto p1 = punti.get(i - 1);
            Punto p2 = punti.get(i);
            linee.add(new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
        }
    }

    public void apri(){
        if(punti.size() > 2 && !aperta){
            linee.remove(linee.size() - 1);
        }
        aperta = true;
    }

    public void chiudi(){
        if(punti.size() > 2 && aperta){
            Punto primo = punti.get(0);
            Punto ultimo = punti.get(punti.size() - 1);
            linee.add(new Line(primo.getX(), primo.getY(), ultimo.getX(), ultimo.getY()));
        }
        aperta = false;
    }

    public void rimuoviPunto(Punto p){
        int pos = punti.indexOf(p);
        if(pos == 0){
            punti.remove(p);
            linee.remove(0);
        }
    }
    public Punto getBaricentro(){
        float mediaX = 0;
        float mediaY = 0;

        if(punti.size() > 0){
            if(punti.size() == 1){
                return punti.get(1);
            } else {
                for(var i : punti){
                    mediaX += i.getX();
                    mediaY += i.getY();
                }
                mediaX /= punti.size();
                mediaY /= punti.size();
            }
        }
        return new Punto(mediaX,mediaY);
    }

    public void ruotaOrigine(int angoloGradi){
        Punto origine = new Punto(0,0);
        for(var i : punti){
            i.ruotaPunto(angoloGradi, origine);
        }
        costrusciArrayLine();
    }

    public void ruotaBaricentro(int angoloGradi){
        for(var i : punti){
            i.ruotaPunto(angoloGradi, getBaricentro());
        }
        costrusciArrayLine();
    }

    public void disegna(){
        for(var i : linee){
            i.draw();
        }
    }
}
