package Robolini.Paolo;

public class Punto {
    private float x;
    private float y;


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float X) {
        this.x = X;
    }

    public void setY(float Y) {
        this.y = Y;
    }

    public float getDistanza (Punto p){
        float catetoX = this.x - p.getX();
        float catetoY = this.y - p.getY();
        double ipotenusa_quadrato = Math.pow(catetoX,2) +
                Math.pow(catetoY,2);
        return (float)Math.sqrt(ipotenusa_quadrato);
    }

    public int calcolaAngolo(){
        double radianti = Math.acos(this.y/this.x);
        return (int) Math.toDegrees(radianti);
    }

    public Punto (float x, float y){
        this.x = x;
        this.y = y;
    }

    public Punto getPuntoMedio(Punto p){
        float x_ritorno = (this.x + p.getX())/2;
        float y_ritorno = (this.y + p.getY())/2;
        return new Punto(x_ritorno,y_ritorno);
    }

    public void ruotaPunto(int angoloGradi, Punto riferimento){
        double angoloRadianti = Math.toRadians(angoloGradi);
        float ipotenusa = this.getDistanza(riferimento);

        this.setX((float) (ipotenusa*Math.cos(angoloRadianti)));
        this.setY((float) (ipotenusa*Math.sin(angoloRadianti)));
    }

    @Override
    public String toString(){
        return "X = "+ this.x + "; Y = " + this.y;
    }

}
