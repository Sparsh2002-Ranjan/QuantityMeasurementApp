package com.feetandinchmeasuments;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        System.out.println("Temperature Equality:");

        System.out.println(
                new Quantity<>(0.0, TemperatureUnit.CELSIUS)
                        .equals(new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT))
        );

        System.out.println(
                new Quantity<>(273.15, TemperatureUnit.KELVIN)
                        .equals(new Quantity<>(0.0, TemperatureUnit.CELSIUS))
        );

        System.out.println("\nTemperature Conversion:");

        System.out.println(
                new Quantity<>(100.0, TemperatureUnit.CELSIUS)
                        .convertTo(TemperatureUnit.FAHRENHEIT)
        );

        System.out.println(
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT)
                        .convertTo(TemperatureUnit.CELSIUS)
        );

        System.out.println("\nUnsupported Operation Example:");

        try {

            Quantity<TemperatureUnit> t1 =
                    new Quantity<>(100.0, TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> t2 =
                    new Quantity<>(50.0, TemperatureUnit.CELSIUS);

            System.out.println(t1.add(t2));

        } catch (UnsupportedOperationException e) {

            System.out.println(e.getMessage());

        }
    }
}