package ru.JavaOOP.stv.TemperaturesControl;

import ru.JavaOOP.stv.TemperaturesModel.*;
import ru.JavaOOP.stv.TemperaturesView.TemperaturesView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class TemperaturesControl {
    private TemperaturesView temperaturesView;
    private HashMap<String, TemperaturesConverter> scales;

    public void printScales() {
        for (String k : scales.keySet()) {
            System.out.println(k);
        }

    }

    public void addScale(String scaleName, TemperaturesConverter temperatureClass) {
        scales.putIfAbsent(scaleName, temperatureClass);
    }


    public TemperaturesControl(TemperaturesView view) {
        temperaturesView = view;
        temperaturesView.addButtonListener(new ButtonListener());
        scales = new HashMap<>();
        scales.put("K", new KelvinConverter());
        scales.put("F", new FahrenheitConverter());
        scales.put("C", new CelsiusConverter());
        String[] tempUnits = new String[scales.size()];
        String[] units = scales.keySet().toArray(tempUnits);
        temperaturesView.setScales(units);
    }


    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String input = temperaturesView.getInputField().getText();
                String inputUnit = (String) temperaturesView.getInputUnits().getSelectedItem();
                String outputUnit = (String) temperaturesView.getOutputUnits().getSelectedItem();
                TemperaturesConverter inputConverter = scales.get(inputUnit);
                TemperaturesConverter outputConverter = scales.get(outputUnit);
                double result = (new BindingConverter(inputConverter, outputConverter, Double.parseDouble(input))).getOutputValue();
                temperaturesView.getOutputField().setText(String.valueOf(result));
            } catch (NumberFormatException e2) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "неверный формат ввода");
            }
        }


    }


}
