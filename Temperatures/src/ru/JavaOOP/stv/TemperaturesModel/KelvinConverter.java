package ru.JavaOOP.stv.TemperaturesModel;

public class KelvinConverter implements TemperaturesConverter {
    @Override
    public double convertInputValueToCelsius(double inputTemperature) {
        return inputTemperature - 273.15;
    }

    @Override
    public double convertOutputValue(double inputValueInCelsius) {
        return inputValueInCelsius + 273.15;
    }
}
