import graphics.Color;

import java.util.Objects;

public abstract class Figura {
    private double posX, posY;
    private String colore;

    public Figura(double posX, double posY, String colore) {
        this.posX = posX;
        this.posY = posY;
        this.colore = colore;
    }


    @Override
    public String toString() {
        return "Posizione X: " + posX + "\nPosizione Y: " + posY + "\nColore: " + colore;
    }

    public double getPosX() {
        return posX;
    }

    public String getColore() {
        return colore;
    }

    public double getPosY() {
        return posY;
    }

    public Color convertiColore(){
        if(Objects.equals(getColore(), "NERO")){
            return Color.BLACK;
        } else if(getColore().equals("VERDE")){
            return Color.GREEN;
        } else if(getColore().equals("BLU")){
            return Color.BLUE;
        } else if (getColore().equals("ROSSO")){
            return Color.RED;
        } else if (getColore().equals("BIANCO")){
            return Color.WHITE;
        } else if (getColore().equals("GIALLO")){
            return Color.YELLOW;
        }
        return Color.BLACK;
    }

    public void trasla(double dx, double dy){
        posX += dx;
        posY += dy;
    };

    public abstract void disegna();

    public abstract double getPerimetro();

    public abstract double getArea();
}
