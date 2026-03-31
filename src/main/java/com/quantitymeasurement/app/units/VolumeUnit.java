package com.quantitymeasurement.app.units;

import com.quantitymeasurement.app.core.IMeasurable;
<<<<<<< HEAD
=======
import com.quantitymeasurement.app.core.SupportsArithmetic;
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement

public enum VolumeUnit implements IMeasurable {

    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

<<<<<<< HEAD
=======
    SupportsArithmetic supportsArithmetic = () -> true;

>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

<<<<<<< HEAD
    public double toBaseUnit(double value) { return value * conversionFactor; }
    public double fromBaseUnit(double value) { return value / conversionFactor; }

    public static VolumeUnit fromString(String unit) {
        return VolumeUnit.valueOf(unit.trim().toUpperCase());
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
