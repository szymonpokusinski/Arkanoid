import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class StartFrame extends JFrame {

    public static ArrayList<JCheckBox> jCheckBoxes = new ArrayList<>();
    public String level;

    StartFrame() throws FontFormatException {
        level = null;
        Font font = new Font("Arial", Font.BOLD, 24);
        Font boxFont = new Font("Arial", Font.BOLD, 18);
        JLabel title = new JLabel("Arkanoid");
        title.setForeground(Color.decode("#2C2C2E"));
        title.setFont(font);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.decode("#B3B4B6"));
        titlePanel.setBounds(0, 0, 300, 50);
        titlePanel.add(title, BorderLayout.CENTER);

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setBackground(Color.decode("#2C2C2E"));
        checkBoxPanel.setBounds(0, 50, 300, 220);
        checkBoxPanel.setLayout(null);

        JCheckBox easy = new JCheckBox("Easy");
        easy.setBounds(110,5,100,50);
        easy.setForeground(Color.decode("#2AA146"));
        easy.setOpaque(false);
        easy.setFont(boxFont);
        jCheckBoxes.add(easy);
        checkBoxPanel.add(easy);

        JCheckBox medium = new JCheckBox("Medium");
        medium.setBounds(110,45,100,50);
        medium.setForeground(Color.decode("#2AA146"));
        medium.setOpaque(false);
        medium.setFont(boxFont);
        jCheckBoxes.add(medium);
        checkBoxPanel.add(medium);

        JCheckBox hard = new JCheckBox("Hard");
        hard.setBounds(110,85,100,50);
        hard.setForeground(Color.decode("#2AA146"));
        hard.setBackground(Color.decode("#2C2C2E"));
        hard.setOpaque(false);
        hard.setFont(boxFont);
        jCheckBoxes.add(hard);
        checkBoxPanel.add(hard);

        GradientLabel start = new GradientLabel("START");
        start.setForeground(Color.decode("#2AA146").darker());
        start.setFont(font);
        start.setBounds(110, 125,100,70);
        start.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for(JCheckBox checkBox: jCheckBoxes){
                    if (checkBox.isSelected()){
                        System.out.println(checkBox.getText());
                        level = checkBox.getText();
                        dispose();
                        break;
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        checkBoxPanel.add(start);

        ActionListener checkBoxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox selectedCheckBox = (JCheckBox) e.getSource();
                for (JCheckBox checkBox : jCheckBoxes) {
                    if (checkBox != selectedCheckBox) {
                        checkBox.setSelected(false);
                    }
                }
            }
        };

        easy.addActionListener(checkBoxListener);
        medium.addActionListener(checkBoxListener);
        hard.addActionListener(checkBoxListener);

        setSize(300, 270);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(titlePanel);
        add(checkBoxPanel);
    }

    public static void main(String[] args) throws FontFormatException {
        StartFrame startFrame = new StartFrame();
    }
}
class GradientLabel extends JLabel {
    private boolean isMouseOver = false;
    public GradientLabel(String text) {
        super(text);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseOver = true;
                setForeground(Color.BLACK);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseOver = false;
                setForeground(Color.decode("#2AA146"));
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        int width = getWidth();
        int height = getHeight();

        if (isMouseOver) {
            Point2D center = new Point2D.Float(width / 2, height / 2);
            float radius = width / 2;
            float[] dist = {0.0f, 1.0f};
            Color[] colors = {Color.decode("#2AA146"), Color.decode("#2C2C2E")};
            RadialGradientPaint rgp = new RadialGradientPaint(center, radius, dist, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE);
            g2d.setPaint(rgp);
            g2d.fillRect(0, 0, width, height);
        } else {
            g2d.setColor(Color.decode("#2C2C2E"));
            g2d.fillRect(0, 0, width, height);
        }
        super.paintComponent(g2d);

        g2d.dispose();
    }
}

