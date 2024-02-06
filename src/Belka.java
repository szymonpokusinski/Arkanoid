import java.awt.geom.Rectangle2D;

class Belka extends Rectangle2D.Float {

    static int x;
    Belka(int x)
    {
        //this.x=x;
        this.y=250;
        this.width=60;
        this.height=10;
    }

    void setX(int x)
    {
        Belka.x =x;
    }

    @Override
    public double getX() {
        return x;
    }
}