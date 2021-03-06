package ru.JavaOOP.stv.TemperaturesModel;

public class BindingConverter {
    public double getOutputValue(TemperaturesConverter inputConverter, TemperaturesConverter outputConvert, double inputValue) {
        double celsiusTemperature = inputConverter.convertToCelsius(inputValue);
        return outputConvert.convertFromCelsius(celsiusTemperature);
    }
}
