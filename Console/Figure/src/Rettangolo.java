import graphics.Ellipse;
import graphics.Rectangle;

public class Rettangolo extends Figura {

    private double base;
    private double altezza;


    public Rettangolo(double base, double altezza, double posX, double posY, String colore) {
        super(posY, posX, colore);
        this.base = base;
        this.altezza = altezza;
    }

    @Override
    public String toString() {
        return super.toString() + "\nbase: " + base + "\naltezza: " + altezza;
    }

    @Override
    public void disegna() {
        Rectangle r = new Rectangle(getPosX(), getPosY(), this.base, this.altezza);
        r.setColor(convertiColore());
        r.draw();
        r.fill();
    }

    @Override
    public double getPerimetro() {
        return 2*(base+altezza);
    }

    @Override
    public double getArea() {
        return base * altezza;
    }
}
