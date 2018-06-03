package ru.JavaOOP.stv.TemperaturesControl;

import ru.JavaOOP.stv.TemperaturesModel.TemperaturesModel;
import ru.JavaOOP.stv.TemperaturesView.TemperaturesView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperaturesControl {
    private TemperaturesView temperaturesView;
    private TemperaturesModel temperaturesModel;


    public TemperaturesControl(TemperaturesModel model, TemperaturesView view) {
        temperaturesModel = model;
        temperaturesView = view;
        temperaturesView.addButtonListener(new ButtonListener());

    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String input = temperaturesView.getInputField().getText();
                temperaturesModel.setInputTemperature(Double.parseDouble(input));
                temperaturesModel.setInputUnit((String) temperaturesView.getInputBox().getSelectedItem());
                temperaturesModel.setOutputUnit((String) temperaturesView.getOutputBox().getSelectedItem());
                String result = temperaturesModel.getOutputTemperature();
                temperaturesView.getOutputField().setText(result);
            } catch (NumberFormatException e2) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "неверный формат ввода");
            }
        }


    }

}
