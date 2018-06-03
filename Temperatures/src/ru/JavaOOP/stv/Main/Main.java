package ru.JavaOOP.stv.Main;

import ru.JavaOOP.stv.TemperaturesControl.TemperaturesControl;
import ru.JavaOOP.stv.TemperaturesModel.TemperaturesModel;
import ru.JavaOOP.stv.TemperaturesView.TemperaturesView;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
                    TemperaturesModel model = new TemperaturesModel();
                    TemperaturesView view = new TemperaturesView();
                    view.getUI();
                    TemperaturesControl control = new TemperaturesControl(model, view);
                }
        );
    }

}
