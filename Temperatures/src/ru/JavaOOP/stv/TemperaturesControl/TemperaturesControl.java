package ru.JavaOOP.stv.TemperaturesControl;

import ru.JavaOOP.stv.TemperaturesModel.*;


import java.util.HashMap;

public class TemperaturesControl {
    private BindingConverter bindingConverter;

    private HashMap<String, TemperaturesConverter> scales;

    public void printScales() {
        for (String k : scales.keySet()) {
            System.out.println(k);
        }
    }

    public void addScale(String scaleName, TemperaturesConverter temperatureClass) {
        scales.putIfAbsent(scaleName, temperatureClass);
    }

    public double getResult(String inputUnit, String outputUnit, double input) {
        TemperaturesConverter inputConverter = scales.get(inputUnit);
        TemperaturesConverter outputConverter = scales.get(outputUnit);
        return bindingConverter.getOutputValue(inputConverter, outputConverter, input);
    }

    public TemperaturesControl() {
        scales = new HashMap<>();
        scales.put("K", new KelvinConverter());
        scales.put("F", new FahrenheitConverter());
        scales.put("C", new CelsiusConverter());
        bindingConverter = new BindingConverter();
    }

    public String[] getScales() {
        String[] tempUnits = new String[scales.size()];
        return scales.keySet().toArray(tempUnits);
    }


}
