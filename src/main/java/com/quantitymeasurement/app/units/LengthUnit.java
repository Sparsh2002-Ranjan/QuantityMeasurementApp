package com.quantitymeasurement.app.units;

import com.quantitymeasurement.app.core.IMeasurable;
<<<<<<< HEAD
=======
import com.quantitymeasurement.app.core.SupportsArithmetic;
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement

public enum LengthUnit implements IMeasurable {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084),
    METERS(3.28084);

    private final double conversionFactor;

<<<<<<< HEAD
=======
    SupportsArithmetic supportsArithmetic = () -> true;

>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

<<<<<<< HEAD
    public double toBaseUnit(double value) { return value * conversionFactor; }
    public double fromBaseUnit(double value) { return value / conversionFactor; }

    public static LengthUnit fromString(String unit) {
        return LengthUnit.valueOf(unit.trim().toUpperCase());
    }
}
=======
    public double toBaseUnit(double value) {
        return value * conversionFactor;
    }

    public double fromBaseUnit(double value) {
        return value / conversionFactor;
    }

    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }
}
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
