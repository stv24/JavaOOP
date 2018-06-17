package ru.JavaOOP.stv.TemperaturesModel;

public class CelsiusConverter implements TemperaturesConverter {
    @Override
    public double convertToCelsius(double inputTemperature) {
        return inputTemperature;
    }

    @Override
    public double convertFromCelsius(double inputValue) {
        return inputValue;
    }
}
