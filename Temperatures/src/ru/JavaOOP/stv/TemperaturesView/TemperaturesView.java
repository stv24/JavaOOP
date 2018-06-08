package ru.JavaOOP.stv.TemperaturesView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class TemperaturesView {
    private JTextField inputField;
    private JTextField outputField;
    private JComboBox<String> inputUnits;
    private JComboBox<String> outputUnits;
    private JButton convertButton;


    public TemperaturesView() {
        inputField = new JTextField(6);
        outputField = new JTextField(7);
        outputField.setText("");
        outputField.setEditable(false);
        inputUnits = new JComboBox<>();
        outputUnits = new JComboBox<>();
        convertButton = new JButton();
    }

    public void setScales(String[] scales) {
        for (String scale : scales) {
            inputUnits.addItem(scale);
            outputUnits.addItem(scale);
        }

    }

    private JFrame CreateView() {
        JFrame frame = new JFrame("Перевод температур");
        frame.setSize(440, 180);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(boxLayout);
        return frame;
    }

    private JPanel CreatePanel() {
        JPanel panel = new JPanel();
        JLabel label2 = new JLabel("Единицы ввода");
        JLabel label3 = new JLabel("Единицы вывода");
        convertButton.setText("Применить");
        panel.add(label2);
        panel.add(inputUnits);
        panel.add(label3);
        panel.add(outputUnits);
        panel.add(convertButton);
        panel.setBorder(new EmptyBorder(2, 2, 2, 2));
        return panel;
    }

    public void createUI() {
        JFrame frame = CreateView();
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel userInputRequest = new JLabel("Температура");
        inputPanel.add(userInputRequest);
        inputField.setMaximumSize(new Dimension(400, 50));
        inputPanel.add(inputField);
        inputField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        inputPanel.add(CreatePanel());
        JLabel result = new JLabel("Результат");
        inputPanel.add(result);
        userInputRequest.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        result.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        frame.add(inputPanel);
        outputField.setMaximumSize(new Dimension(400, 50));
        frame.add(outputField);
        outputField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
    }

    public void addButtonListener(ActionListener listener) {
        convertButton.addActionListener(listener);
    }


    public JTextField getOutputField() {
        return outputField;
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JComboBox getInputUnits() {
        return inputUnits;
    }

    public JComboBox getOutputUnits() {
        return outputUnits;
    }

}
