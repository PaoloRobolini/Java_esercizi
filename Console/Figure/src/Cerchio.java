import graphics.Color;
import graphics.Ellipse;

public class Cerchio extends Figura {
    private double raggio;
    public Cerchio(double raggio, double posX, double posY, String colore){
        super(posX, posY, colore);
        this.raggio = raggio;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRaggio: " + raggio;
    }

    @Override
    public void disegna() {
        Ellipse e = new Ellipse(getPosX(), getPosY(), this.raggio, this.raggio);
        e.setColor(convertiColore());
        e.draw();
        e.fill();
    }

    @Override
    public double getPerimetro() {
        return 2*raggio*Math.PI;
    }

    @Override
    public double getArea() {
        return Math.PI*raggio*raggio;
    }
}
