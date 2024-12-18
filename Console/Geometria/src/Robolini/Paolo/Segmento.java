package Robolini.Paolo;

import graphics.Color;
import graphics.Line;

public class Segmento {
    private Punto punto1;
    private Punto punto2;
    private Line linea;


    public Segmento (Punto p1, Punto p2){
        this.punto1 = p1;
        this.punto2 = p2;
        linea = new Line(p1.getX(),p1.getY(),p2.getX(),p2.getY());
    }


    public Segmento(Segmento s){
        this(s.getPunto1(),s.getPunto2());
    }

    public void disegna(){

        Line disegnata = new Line(punto1.getX() + 950, 500 - punto1.getY(),punto2.getX() + 950, 500 - punto2.getY());
        disegnata.draw();
    }

    public void setColore(Color colore){
        linea.setColor(colore);
    }

    public Punto getPunto1(){
        return punto1;
    }

    public Punto getPunto2(){
        return punto2;
    }

    //grazie chatGPT
    public boolean controllaIntersezione(Segmento segmento){
        double x1 = punto1.getX();
        double y1 = punto1.getY();
        double x2 = punto2.getX();
        double y2 = punto2.getY();
        double x3 = segmento.getPunto1().getX();
        double y3 = segmento.getPunto1().getY();
        double x4 = segmento.getPunto2().getX();
        double y4 = segmento.getPunto2().getY();

        double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
        if (denom == 0) {
            return false;
        }

        double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / denom;
        double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / denom;

        return (ua >= 0 && ua <= 1) && (ub >= 0 && ub <= 1);
    }

    public void traslaOrizzontale (float distanza){
        punto1.setX(punto1.getX() + distanza);
        punto2.setX(punto2.getX() + distanza);
        linea.translate(distanza,0);
    }

    public void traslaVerticale (float distanza){
        punto1.setY(punto1.getY() + distanza);
        punto2.setY(punto2.getY() + distanza);
        linea.translate(0,distanza);
    }

    public void ruotaSegmentoOrigine(int angoloGradi){
        int differenza = punto2.calcolaAngolo() - punto1.calcolaAngolo();
        Punto origine = new Punto(0,0);
        this.punto1.ruotaPunto(angoloGradi,origine);
        this.punto2.ruotaPunto(differenza + angoloGradi,origine);
        this.linea = null;
        this.linea = new Line(punto1.getX(),punto1.getY(),punto2.getX(),punto2.getY());
    }

    public void ruotaSegmentoEstremo(int angoloGradi, Punto p){
        if(p.equals(punto1)){
            this.punto2.ruotaPunto(angoloGradi,p);
        } else if (p.equals(punto2)){
            this.punto1.ruotaPunto(angoloGradi,p);
        }
        this.linea = null;
        this.linea = new Line(punto1.getX(),punto1.getY(),punto2.getX(),punto2.getY());
    }

}
