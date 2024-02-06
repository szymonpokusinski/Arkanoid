import java.awt.*;
import java.awt.geom.*;
import java.util.Iterator;

class Kulka extends Ellipse2D.Float {
    Plansza p;

    int dx, dy;
    Belka belka = Plansza.b;
    public int score;
    Kulka(Plansza p, int x, int y, int dx, int dy) {
        
        this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 10;

        this.p = p;
        this.dx = dx;
        this.dy = dy;
    }
    void nextKrok() throws InterruptedException {
        x += dx;
        y += dy;

        if (getMinX() < 0 || getMaxX() > p.getWidth()) {
            dx = -dx;
        }
        if (getMinY() < 0 || getMaxY() > p.getHeight()) {
            dy = -dy;
        }
        if (intersects(belka)) {
            //dx = -dx;
            dy = -dy;
        }
        if (getMaxY() == p.getHeight()) {
            System.out.println("Straciłeś zycie");
            x = 100;
            y = 100;
            dx = 1;
            dy = 1;
            Thread.sleep(3000);
        }
        Iterator<Brick> iterator = p.brick.bricks.iterator();
        while (iterator.hasNext()) {
            Brick brick = iterator.next();
            if (brick == null){
                continue;
            }
            else if (intersects(brick)) {
                iterator.remove();
                dy = -dy;
            }
        }
        p.repaint();
        Toolkit.getDefaultToolkit().sync();
    }


    }
