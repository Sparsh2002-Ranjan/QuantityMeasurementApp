package com.feetandinchmeasuments;

import java.util.Objects;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.toFeet(value);
    }

    private static final double TOLERANCE = 0.00001;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < TOLERANCE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBaseUnit());
    }
    
    public static void main(String[] args) {

        // Feet & Inches
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println("1 Foot == 12 Inches ? " + feet.equals(inches));

        // Yard & Feet
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength threeFeet = new QuantityLength(3.0, LengthUnit.FEET);

        System.out.println("1 Yard == 3 Feet ? " + yard.equals(threeFeet));

        // Yard & Inches
        QuantityLength thirtySixInches = new QuantityLength(36.0, LengthUnit.INCH);

        System.out.println("1 Yard == 36 Inches ? " + yard.equals(thirtySixInches));

        // Centimeter & Inch
        QuantityLength oneCm = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength inchEquivalent = new QuantityLength(0.393701, LengthUnit.INCH);

        System.out.println("1 cm == 0.393701 Inches ? " + oneCm.equals(inchEquivalent));

        // Different Values
        QuantityLength twoFeet = new QuantityLength(2.0, LengthUnit.FEET);

        System.out.println("1 Foot == 2 Feet ? " + feet.equals(twoFeet));
    }
}
