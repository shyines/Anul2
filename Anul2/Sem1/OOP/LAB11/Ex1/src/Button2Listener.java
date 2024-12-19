import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button2Listener implements ActionListener {
    private JLabel label;
    private JTextField textField;
    public void actionPerformed(ActionEvent e){
        //fa ceva cand se apasa butonul, de exemplu
        label.setText(textField.getText());
        //tf.setText(count + "");
    }

    public Button2Listener(JTextField text, JLabel label){
        this.label = label;
        this.textField = text;
    }
}
