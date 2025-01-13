import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class GaraView extends JFrame {
    private JComboBox<Tren> j_ComboBoxTren = new JComboBox<>();
    private JTextField j_TextFieldTren = new JTextField(20);
    private JButton j_AfiseazaTren = new JButton("Afiseaza");

    private GaraModel garaModel;
    GaraView(GaraModel garaModel) {
        this.garaModel = garaModel;

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(j_ComboBoxTren, BorderLayout.WEST);
        contentPane.add(j_TextFieldTren, BorderLayout.EAST);

        this.setContentPane(contentPane);
        this.pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public String getUserInput() {
        return j_TextFieldTren.getText();
    }

    public void addTrenButtonListener(ActionListener buton) {
        j_AfiseazaTren.addActionListener(buton);
    }


}
