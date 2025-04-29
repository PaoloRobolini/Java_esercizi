import graphics.*;

public class Main {
    public static void main(String[] args) {
        Canvas canvas = Canvas.getInstance();

        Quadrato q1 = new Quadrato(100, 100, 100, "NERO");
        Quadrato q2 = new Quadrato(100, 100, 100, "ROSSO");
        q2.trasla(400, 400);
        q1.disegna();
        q2.disegna();

        Rettangolo r = new Rettangolo(250, 50, 500, 50, "BLU");
        r.disegna();

        Cerchio c = new Cerchio(250, 400, 50, "GIALLO");
        c.disegna();
    }
}