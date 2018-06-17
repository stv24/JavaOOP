package ru.JavaOOP.stv.TemperaturesModel;

public class KelvinConverter implements TemperaturesConverter {
    @Override
    public double convertToCelsius(double inputTemperature) {
        return inputTemperature - 273.15;
    }

    @Override
    public double convertFromCelsius(double inputValueInCelsius) {
        return inputValueInCelsius + 273.15;
    }
}
