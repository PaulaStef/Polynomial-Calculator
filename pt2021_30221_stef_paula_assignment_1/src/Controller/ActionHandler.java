package Controller;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton btn = (JButton) source;
            try {
                String value = btn.getText();
                Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                if (comp instanceof JTextComponent) {
                    JTextComponent tc = (JTextComponent) comp;
                    if (value.equals("Del") && !tc.getText().isEmpty()) {
                        tc.setText(tc.getText().substring(0, tc.getText().length() - 1));
                    } else if(!value.equals("Del")){
                        tc.setText(tc.getText() + value);
                    }
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
    }
}