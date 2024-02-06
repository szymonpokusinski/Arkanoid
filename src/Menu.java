import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    Plansza plansza;
    JPanel gra;
    public Menu(){
        plansza = new Plansza();
        gra = new JPanel();
        gra.setBounds(0,0,400,370);
        gra.add(plansza);
        add(gra);
        setSize(550,370);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main (String[] args){
        Menu menu = new Menu();
    }
}
