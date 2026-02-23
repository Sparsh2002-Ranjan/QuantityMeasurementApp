package com.feetandinchmeasuments;

public class QuantityMeasurementApp {

    public static void demonstrateLengthConversion(double value,
                                                   LengthUnit from,
                                                   LengthUnit to) {

        double result = QuantityLength.convert(value, from, to);
        System.out.println(value + " " + from + " = " + result + " " + to);
    }

    public static void demonstrateLengthConversion(QuantityLength length,
                                                   LengthUnit to) {

        QuantityLength converted = length.convertTo(to);
        System.out.println(length + " = " + converted);
    }

    public static void demonstrateLengthEquality(QuantityLength a,
                                                 QuantityLength b) {

        System.out.println(a + " equals " + b + " ? " + a.equals(b));
    }

    public static void main(String[] args) {

        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.YARDS);
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES);

        QuantityLength l1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength l2 = new QuantityLength(12.0, LengthUnit.INCHES);

        demonstrateLengthEquality(l1, l2);
    }
}
