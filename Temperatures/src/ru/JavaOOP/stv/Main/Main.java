package ru.JavaOOP.stv.Main;

import ru.JavaOOP.stv.TemperaturesControl.TemperaturesControl;
import ru.JavaOOP.stv.TemperaturesView.TemperaturesView;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TemperaturesControl control = new TemperaturesControl();
            TemperaturesView view = new TemperaturesView(control);
            view.createUI();
            control.printScales();
        });
    }

}
