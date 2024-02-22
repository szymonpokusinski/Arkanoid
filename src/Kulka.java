import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Iterator;

class Kulka extends Ellipse2D.Float {
    Plansza p;
    int dx, dy;
    Belka belka = Plansza.b;
    Menu menu;
    public int score;
    public static int life;
    Kulka(Plansza p, int x, int y, int dx, int dy, int life) {
        
        this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 10;

        this.p = p;
        this.dx = dx;
        this.dy = dy;



    }
    void nextKrok() throws InterruptedException, FontFormatException {
        x += dx;
        y += dy;

        if (getMinX() < 0 || getMaxX() > p.getWidth()) {
            dx = -dx;
        }
        if (getMinY() < 0 || getMaxY() > p.getHeight()) {
            dy = -dy;
        }
        if (intersects(belka)) {
            dy = -dy;
        }
        if (getMaxY() == p.getHeight()) {
            System.out.println("Straciłeś zycie");
            changeLifeNumber();
            changeScoreNumber(false);
            life -= 1;
            System.out.println(life);
            x = 100;
            y = 100;
            dx = 1;
            dy = 1;
            Thread.sleep(3000);

        }
        Iterator<Brick> iterator = Brick.bricks.iterator();
        while (iterator.hasNext()) {
            Brick brick = iterator.next();
            if (brick == null){
                continue;
            }
            else if (intersects(brick)) {
                changeScoreNumber(true);
                checkingBrickList();
                System.out.println(Brick.bricks);
                iterator.remove();
                dy = -dy;
            }
        }
        p.repaint();
        Toolkit.getDefaultToolkit().sync();
    }
    private void changeLifeNumber (){
        String numberOfLife = Menu.numberOfLife.getText();
        int number = Integer.parseInt(numberOfLife);
        number -= 1;
        Menu.numberOfLife.setText(String.valueOf(number));
    }
    private void changeScoreNumber(Boolean b){
        String s  = Menu.numberOfScore.getText();
        int number = Integer.parseInt(s);
        if (b){
            number += 10;
            Menu.numberOfScore.setText(String.valueOf(number));
        } else {
            number -= 10;
            Menu.numberOfScore.setText(String.valueOf(number));
        }
    }
    private void checkingBrickList(){
        boolean allNull = true;
        for(Object object: Brick.bricks){
            if (object != null){
                allNull = false;
                break;
            }
        }
        if (allNull){
            System.out.println("są");
        } else {
            System.out.println("nie sa");
        }

    }

    public static int getLife() {
        return life;
    }
}
