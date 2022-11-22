package e.borho.binary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ChoiceFrame {
    private final List<JButton> choiceButtons = new ArrayList<JButton>();
    private JFrame frame = new JFrame("input choice");

    public ChoiceFrame(){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setBackground(Color.GRAY);

        for (int i = 0; i < Calculator.choices.length; i++){
            JButton button = new JButton();
            button.setText(Calculator.choices[i]);
            button.setPreferredSize(new Dimension(100, 30));
            choiceButtons.add(button);
            panel.add(choiceButtons.get(i));
        }

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
    }

    public Calculator.calcChoice getChoice(String choice){
        if(choice == Calculator.choices[0]){
            return Calculator.calcChoice.add;
        }

        if(choice == Calculator.choices[1]){
            return Calculator.calcChoice.subtract;
        }

        if(choice == Calculator.choices[2]){
            return Calculator.calcChoice.multiplicate;
        }

        return null;
    }

    public void exit(){
        frame.dispose();
    }

    public void show(){
        frame.setVisible(true);
    }

    public void setActionListener(ActionListener al){
        for (JButton choiceButton : choiceButtons){
            choiceButton.addActionListener(al);
        }
    }
}
