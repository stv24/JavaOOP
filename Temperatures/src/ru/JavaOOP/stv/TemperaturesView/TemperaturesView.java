package ru.JavaOOP.stv.TemperaturesView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TemperaturesView {
    private JTextField inputField;
    private JTextField outputField;
    private JComboBox<String> inputBox;
    private JComboBox<String> outputBox;
    private JButton button;


    public TemperaturesView() {
        inputField = new JTextField(6);
        outputField = new JTextField(7);
        outputField.setText("");
        outputField.setEditable(false);
        String[] units = {"F", "C", "K"};
        inputBox = new JComboBox<>(units);
        outputBox = new JComboBox<>(units);
        button = new JButton();
    }

    private JFrame CreateView() {
        JFrame frame = new JFrame("Перевод температур");
        frame.setSize(500, 150);
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
        JLabel label2 = new JLabel("Выберите единицы ввода");
        JLabel label3 = new JLabel("Единицы вывода");
        button.setText("Применить");
        panel.add(label2);
        panel.add(inputBox);
        panel.add(label3);
        panel.add(outputBox);
        panel.add(button);
        return panel;
    }


    public void getUI() {
        JFrame frame = CreateView();
        frame.add(new JLabel("Введите температуру"));
        inputField.setMaximumSize(new Dimension(400, 50));
        frame.add(inputField);
        frame.add(CreatePanel());
        frame.add(new JLabel("Результат"));
        outputField.setMaximumSize(new Dimension(400, 50));
        frame.add(outputField);
    }

    public void addButtonListener(ActionListener listener) {
        button.addActionListener(listener);
    }


    public JTextField getOutputField() {
        return outputField;
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JComboBox getInputBox() {
        return inputBox;
    }

    public JComboBox getOutputBox() {
        return outputBox;
    }

}
