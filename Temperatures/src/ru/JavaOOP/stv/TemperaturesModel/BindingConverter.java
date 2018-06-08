package ru.JavaOOP.stv.TemperaturesModel;

public class BindingConverter {
    private TemperaturesConverter inputConverter;
    private TemperaturesConverter outputConvert;
    private double inputValue;

    public BindingConverter(TemperaturesConverter inputConverter, TemperaturesConverter outputConvert, double inputValue) {
        this.inputConverter = inputConverter;
        this.outputConvert = outputConvert;
        this.inputValue = inputValue;
    }

    public double getOutputValue() {
        double celsiusTemperature = inputConverter.convertInputValueToCelsius(inputValue);
        return outputConvert.convertOutputValue(celsiusTemperature);
    }
}
