package com.quantitymeasurement.app.units;

import com.quantitymeasurement.app.core.IMeasurable;
<<<<<<< HEAD

public enum TemperatureUnit implements IMeasurable {

    CELSIUS, FAHRENHEIT, KELVIN;

    public double toBaseUnit(double value) {
        switch (this) {
            case CELSIUS: return value + 273.15;
            case FAHRENHEIT: return (value - 32) * 5.0 / 9.0 + 273.15;
            case KELVIN: return value;
=======
import com.quantitymeasurement.app.core.SupportsArithmetic;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS,
    FAHRENHEIT,
    KELVIN;

    SupportsArithmetic supportsArithmetic = () -> false;

    public double toBaseUnit(double value) {

        switch (this) {
            case CELSIUS:
                return value + 273.15;
            case FAHRENHEIT:
                return (value - 32) * 5 / 9 + 273.15;
            case KELVIN:
                return value;
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
        }
        return value;
    }

    public double fromBaseUnit(double value) {
<<<<<<< HEAD
        switch (this) {
            case CELSIUS: return value - 273.15;
            case FAHRENHEIT: return (value - 273.15) * 9.0 / 5.0 + 32;
            case KELVIN: return value;
=======

        switch (this) {
            case CELSIUS:
                return value - 273.15;
            case FAHRENHEIT:
                return (value - 273.15) * 9 / 5 + 32;
            case KELVIN:
                return value;
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
        }
        return value;
    }

<<<<<<< HEAD
    public static TemperatureUnit fromString(String unit) {
        return TemperatureUnit.valueOf(unit.trim().toUpperCase());
    }
}
=======
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException("Temperature does not support " + operation);
    }
}
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
