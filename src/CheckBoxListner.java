import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckBoxListner implements ActionListener {
    ArrayList<JCheckBox> jCheckBoxes;
    CheckBoxListner(ArrayList<JCheckBox> jCheckBoxes){
        this.jCheckBoxes = jCheckBoxes;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        while(true){
        JCheckBox checkBox = (JCheckBox) e.getSource();
        if (checkBox.isSelected()){
            for (JCheckBox box : jCheckBoxes){
                if(checkBox != box){
                    box.setSelected(false);
                }
            }
        }
    }
    }
}
