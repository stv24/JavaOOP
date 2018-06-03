package ru.JavaOOP.stv.TemperaturesModel;

public class TemperaturesModel {
    private String inputUnit;
    private String outputUnit;
    private double inputTemperature;

    public void setOutputUnit(String units) {
        outputUnit = units;

    }

    public void setInputUnit(String units) {
        inputUnit = units;
    }

    public void setInputTemperature(double inputTemperature) {
        this.inputTemperature = inputTemperature;
    }

    private double calculateOutputTemperature() {
        switch (inputUnit) {
            case "C":
                if (!outputUnit.equals("C")) {
                    return outputUnit.equals("K") ? inputTemperature + 273.15 : 9.0 / 5 * inputTemperature + 32;
                }
                break;
            case "K":
                if (!outputUnit.equals("K")) {
                    return outputUnit.equals("F") ? (9.0 / 5) * (inputTemperature - 273.15) + 32 : inputTemperature - 273.15;
                }
                break;
            default:
                if (!outputUnit.equals("F")) {
                    return outputUnit.equals("C") ? 5.0 / 9 * (inputTemperature - 32) : 5.0 / 9 * (inputTemperature - 32) + 273.15;
                }
                break;
        }
        return inputTemperature;
    }

    public String getOutputTemperature(){
        return String.valueOf(calculateOutputTemperature());
    }

}
