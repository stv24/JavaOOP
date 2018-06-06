package ru.JavaOOP.stv.TemperaturesModel;

public class CelsiusConverter implements TemperaturesConverter {
    @Override
    public double convertInputValueToCelsius(double inputTemperature) {
        return inputTemperature;
    }

    @Override
    public double convertOutputValue(double inputValue) {
        return inputValue;
    }
}
