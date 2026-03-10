package com.feetandinchmeasuments;

public enum VolumeUnit implements IMeasurable {

    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    SupportsArithmetic supportsArithmetic = () -> true;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double toBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double fromBaseUnit(double value) {
        return value / conversionFactor;
    }

    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }
}