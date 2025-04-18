package com.pt.a2.ui;

import javax.swing.*;
import java.awt.*;

public class LabeledTextField extends JPanel {
    private final JLabel label;
    private final JTextField textField;

    // Constructor
    public LabeledTextField(String labelText) {
        this.label = new JLabel(labelText);
        this.textField = new JTextField();

        // Set up layout for vertical stacking of label and text field
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add the label and text field to the panel
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the label horizontally
        textField.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the text field horizontally

        add(label);
        add(Box.createVerticalStrut(5)); // Adds some space between label and text field
        add(textField);
    }

    // Getter for the text entered by the user
    public String getText() {
        return textField.getText();
    }

    public String getLabel() {
        return label.getText();
    }
}
