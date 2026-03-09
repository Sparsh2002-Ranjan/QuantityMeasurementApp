package com.feetandinchmeasuments;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

    private final double conversionFactorToFeet;

    LengthUnit(double conversionFactorToFeet) {
        this.conversionFactorToFeet = conversionFactorToFeet;
    }

    public double toBase(double value) {
        return value * conversionFactorToFeet;
    }

    public double fromBase(double baseValue) {
        return baseValue / conversionFactorToFeet;
    }
}