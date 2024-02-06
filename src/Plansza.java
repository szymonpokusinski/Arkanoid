import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

class Plansza extends JPanel implements MouseMotionListener
{
    static Belka b;
    Kulka a;
    SilnikKulki s;
    Brick brick = new Brick(0,0);
    int Punkty;

    Plansza()
    {
        super();
        addMouseMotionListener(this);
        b=new Belka(100);
        a=new Kulka(this,100,100,1,1);
        s=new SilnikKulki(a);
        brick.tworzenieListy();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.fill(a);
        g2d.fill(b);
        for (Brick brick1: brick.bricks){
            if (brick1 != null){
                g2d.fill(brick1);
            }
        }

    }

    public void mouseMoved(MouseEvent e)
    {
        b.setX(e.getX()-50);
        repaint();
    }

    public void mouseDragged(MouseEvent e)
    {

    }
    public void obliczaniePunktow(){

    }
}