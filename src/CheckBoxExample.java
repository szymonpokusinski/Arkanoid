import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckBoxExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CheckBoxFrame().setVisible(true);
            }
        });
    }
}

class CheckBoxFrame extends JFrame {
    private ArrayList<JCheckBox> checkBoxes;

    public CheckBoxFrame() {
        setTitle("Checkbox Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        checkBoxes = new ArrayList<>();

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(3, 1));

        JCheckBox checkBox1 = new JCheckBox("Option 1");
        JCheckBox checkBox2 = new JCheckBox("Option 2");
        JCheckBox checkBox3 = new JCheckBox("Option 3");

        checkBoxPanel.add(checkBox1);
        checkBoxPanel.add(checkBox2);
        checkBoxPanel.add(checkBox3);

        checkBoxes.add(checkBox1);
        checkBoxes.add(checkBox2);
        checkBoxes.add(checkBox3);

        JButton button = new JButton("Show Selection");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JCheckBox checkBox : checkBoxes) {
                    if (checkBox.isSelected()) {
                        showSelection(checkBox.getText());
                        break;
                    }
                }
            }
        });

        setLayout(new BorderLayout());
        add(checkBoxPanel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }

    private void showSelection(String selectedOption) {
        JFrame selectionFrame = new JFrame("Selection");
        selectionFrame.setSize(300, 200);
        selectionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Selected Option: " + selectedOption);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        selectionFrame.add(label);

        selectionFrame.setLocationRelativeTo(null); // Wyśrodkowanie ramki na ekranie
        selectionFrame.setVisible(true);
    }
}
