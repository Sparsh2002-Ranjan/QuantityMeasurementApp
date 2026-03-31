package com.feetandinchmeasuments;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        demonstrateSubtraction();

        demonstrateDivision();
    }

    private static void demonstrateSubtraction() {

        System.out.println("SUBTRACTION");

        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FOOT);

        Quantity<LengthUnit> q2 =
                new Quantity<>(6.0, LengthUnit.INCH);

        System.out.println(
                q1.subtract(q2)
        );

        System.out.println(
                q1.subtract(q2, LengthUnit.INCH)
        );

        Quantity<WeightUnit> w1 =
                new Quantity<>(10.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(5000.0, WeightUnit.GRAM);

        System.out.println(
                w1.subtract(w2)
        );

        Quantity<VolumeUnit> v1 =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        System.out.println(
                v1.subtract(v2)
        );
    }

    private static void demonstrateDivision() {

        System.out.println("\nDIVISION");

        Quantity<LengthUnit> a =
                new Quantity<>(10.0, LengthUnit.FOOT);

        Quantity<LengthUnit> b =
                new Quantity<>(2.0, LengthUnit.FOOT);

        System.out.println(
                a.divide(b)
        );

        Quantity<LengthUnit> c =
                new Quantity<>(24.0, LengthUnit.INCH);

        Quantity<LengthUnit> d =
                new Quantity<>(2.0, LengthUnit.FOOT);

        System.out.println(
                c.divide(d)
        );

        Quantity<WeightUnit> w1 =
                new Quantity<>(10.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(5.0, WeightUnit.KILOGRAM);

        System.out.println(
                w1.divide(w2)
        );
    }
}