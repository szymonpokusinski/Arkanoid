import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Menu extends JPanel {
    static JPanel scorePanel;
    static JPanel lifePanel;
    static JLabel lifeLabel;
    static JLabel socreLabel;
    static JLabel numberOfLife;
    static JLabel numberOfScore;
    String df;
    Menu(String df){

    Font font = new Font("Arial", Font.BOLD, 24);
    setBackground(Color.decode("#2C2C2E"));
    setBounds(0,300, 400, 200 );
    setLayout(null);
    setBorder(new LineBorder(Color.decode("#2AA146")));



    lifeLabel = new JLabel("LIFE");
    lifeLabel.setForeground(Color.decode("#2AA146"));
    lifeLabel.setFont(font);

    numberOfLife = new JLabel(df);
    numberOfLife.setFont(font);
    numberOfLife.setForeground(Color.decode("#2AA146"));

    JPanel firstLifePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    firstLifePanel.setBackground(Color.decode("#2C2C2E"));
    firstLifePanel.add(lifeLabel);
    JPanel secoundLifePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    secoundLifePanel.setBackground(Color.decode("#2C2C2E"));
    secoundLifePanel.add(numberOfLife);
    JPanel thridLifePnael = new JPanel(new FlowLayout(FlowLayout.CENTER));
    thridLifePnael.setBackground(Color.decode("#2C2C2E"));

    lifePanel = new JPanel();
    lifePanel.setLayout(new GridLayout(3,1));
    lifePanel.setBackground(Color.decode("#2C2C2E"));
    lifePanel.setBounds(0,0,200, 200);
    lifePanel.setBorder(new LineBorder(Color.decode("#2AA146")));

    lifePanel.add(firstLifePanel);
    lifePanel.add(secoundLifePanel);
    lifePanel.add(thridLifePnael);

    socreLabel = new JLabel("SCORE");
    socreLabel.setForeground(Color.decode("#2AA146"));
    socreLabel.setFont(font);

    numberOfScore = new JLabel("0");
    numberOfScore.setForeground(Color.decode("#2AA146"));
    numberOfScore.setFont(font);

    scorePanel = new JPanel();
    scorePanel.setLayout(new GridLayout(3,1));
    scorePanel.setBackground(Color.decode("#2C2C2E"));
    scorePanel.setBounds(200, 0, 200,200);
    scorePanel.setBorder(new LineBorder(Color.BLACK));
    JPanel firstScorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    firstScorePanel.setBackground(Color.decode("#2C2C2E"));
    firstScorePanel.add(socreLabel);
    JPanel secondScorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    secondScorePanel.setBackground(Color.decode("#2C2C2E"));
    secondScorePanel.add(numberOfScore);
    scorePanel.add(firstScorePanel);
    scorePanel.add(secondScorePanel);

    add(lifePanel);
    add(scorePanel);

    }
}
