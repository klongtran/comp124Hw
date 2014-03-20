import acm.program.ConsoleProgram;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Khanh-Long on 3/19/14.
 */
public class HitchhikerButton extends ConsoleProgram {

    public void init() {
        add(new JButton("Red"), SOUTH);
        addActionListeners();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Red")) {
            println("Please do not press this button again.");
        }
    }
}
