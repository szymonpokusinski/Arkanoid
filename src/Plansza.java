import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Plansza extends JPanel implements MouseMotionListener
{
    static Belka b;
    static Kulka a;
    SilnikKulki s;
    Brick brick = new Brick(0,0);
    String level;

    Plansza(String level)
    {
        super();
        this.level = level;
        int numberOfLives = NumberOfLives(level);
        addMouseMotionListener(this);
        b=new Belka(100);
        a = new Kulka(this,100,100,1,1, numberOfLives);
        s = new SilnikKulki(a);
        brick.tworzenieListy();
        setBackground(Color.decode("#B3B4B6"));
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
    public int NumberOfLives (String level){
        int numberOfLives;
        switch (level) {
            case "Easy" -> {
                return numberOfLives = 3;
            }
            case "Medium" -> {
                return numberOfLives = 2;
            }
            case "Hard" -> {
                return numberOfLives = 1;
            }
        }

        return numberOfLives = 0;
    }
}