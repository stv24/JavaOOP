package ru.JavaOOP.stv.TemperaturesModel;

public class FahrenheitConverter implements TemperaturesConverter {

    @Override
    public double convertToCelsius(double inputTemperature) {
        return 5.0 / 9 * (inputTemperature - 32);
    }

    @Override
    public double convertFromCelsius(double inputValueInCelsius) {
        return 9.0 / 5 * inputValueInCelsius + 32;
    }
}
