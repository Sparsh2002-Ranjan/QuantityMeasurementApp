package com.feetandinchmeasuments;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // LENGTH
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FOOT);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCH);

        System.out.println("Length Equality: " + length1.equals(length2));

        Quantity<LengthUnit> lengthConverted = length1.convertTo(LengthUnit.INCH);
        System.out.println("Converted Length: " + lengthConverted);


        // WEIGHT
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Weight Equality: " + weight1.equals(weight2));

        Quantity<WeightUnit> weightConverted = weight1.convertTo(WeightUnit.GRAM);
        System.out.println("Converted Weight: " + weightConverted);


        // VOLUME (UC11)
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Volume Equality: " + volume1.equals(volume2));

        Quantity<VolumeUnit> volumeConverted = volume1.convertTo(VolumeUnit.MILLILITRE);
        System.out.println("Converted Volume: " + volumeConverted);


        // ADDITION EXAMPLE
        Quantity<VolumeUnit> sum = volume1.add(volume2);

        System.out.println("Volume Addition: " + sum);
    }
}