import javax.swing.*;
import java.awt.*;

public class MainApp {
    public static void main(String[] args) throws FontFormatException {
        StartFrame startFrame = new StartFrame();
        while (startFrame.level == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        String level = startFrame.level;
        System.out.println(level);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                Plansza p;
                p=new Plansza(level);
                int n  = p.NumberOfLives(level);
                System.out.println(n);
                Kulka.life = n;
                String s = Integer.toString(n);
                p.setBounds(0,0,400,300);
                Menu menu = new Menu(s);
                menu.setBounds(0,300, 400, 200 );
                JFrame jf = new JFrame();
                jf.setLayout(null);

                jf.add(p);
                jf.add(menu);
                jf.setResizable(false);
                jf.setTitle("Arkanoid");
                jf.setSize(400,500);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setVisible(true);
            }
        });

    }
}
