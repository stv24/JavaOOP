package ru.JavaOOP.stv.Main;

import ru.JavaOOP.stv.TemperaturesControl.TemperaturesControl;
import ru.JavaOOP.stv.TemperaturesView.TemperaturesView;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TemperaturesView view = new TemperaturesView();
            view.createUI();
            TemperaturesControl control = new TemperaturesControl(view);
            control.printScales();
        });
    }

}
