import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button1Listener implements ActionListener {
    private int count = 0;
    private JLabel label;
    public void actionPerformed(ActionEvent e){
        //fa ceva cand se apasa butonul, de exemplu
        ++count;
        label.setText("" + count);
        //tf.setText(count + "");
    }

    public Button1Listener(JLabel label) {
        this.label = label;
    }
}