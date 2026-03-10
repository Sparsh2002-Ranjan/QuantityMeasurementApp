package com.feetandinchmeasuments;

public enum WeightUnit implements IMeasurable {

    KILOGRAM(1.0),
    GRAM(0.001),
    TONNE(1000);

    private final double conversionFactor;

    SupportsArithmetic supportsArithmetic = () -> true;

    WeightUnit(double conversionFactor) {
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