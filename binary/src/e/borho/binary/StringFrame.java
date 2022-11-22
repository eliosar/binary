package e.borho.binary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class StringFrame {
    private JTextField textField = new JTextField();
    private JTextField basisField = new JTextField("please state your basis");
    private JFrame frame = new JFrame("binary");
    private JButton newCalcButton = new JButton("new calculation");
    private JPanel panel = new JPanel();

    public StringFrame(){
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setBackground(Color.GRAY);

        basisField.setFocusable(false);

        textField.setPreferredSize(new Dimension(100, 20));

        newCalcButton.setVisible(false);

        panel.add(basisField);
        panel.add(textField);
        panel.add(newCalcButton);

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
    }

    public void setBasisFieldText(String text){
        basisField.setText(text);
        show();
    }

    public void setTextFieldVisible(boolean visible){
        textField.setVisible(visible);
        show();
    }

    public void setNewCalcButtonVisible(){
        newCalcButton.setVisible(true);
    }

    public void setTextFieldText(String s){
        textField.setText(s);
    }

    public void setNewCalcButtonActionListener(ActionListener al){
        newCalcButton.addActionListener(al);
    }

    public void setTextFieldActionListener(ActionListener al){
        textField.addActionListener(al);
    }

    public String getTextFieldText(){
        return textField.getText();
    }

    public void show(){
        frame.setVisible(true);
    }

    public void exit(){
        frame.dispose();
    }
}
