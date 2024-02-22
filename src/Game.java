import javax.swing.*;

public class Game
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Plansza p;
                p=new Plansza("Medium");
                p.setBounds(0,0,400,300);

                Menu menu = new Menu("3");
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