package com.feetandinchmeasuments;

public class QuantityMeasurementApp {

	    public static void main(String[] args) {
            
	    	// UC9 - Weight Measurements
	    	System.out.println("------------------------------------------------");
	    	System.out.println("UC9 - Weight Measurements");

	    	// Equality
	    	QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
	    	QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

	    	System.out.println("1 KG equals 1000 G ? -> " + w1.equals(w2));

	    	QuantityWeight w3 = new QuantityWeight(1.0, WeightUnit.POUND);
	    	System.out.println("1 Pound equals 453.592 Gram ? -> " +
	    	        w3.equals(new QuantityWeight(453.592, WeightUnit.GRAM)));

	    	System.out.println("------------------------------------------------");

	    	// Conversion
	    	QuantityWeight converted =
	    	        new QuantityWeight(2.0, WeightUnit.POUND)
	    	                .convertTo(WeightUnit.KILOGRAM);

	    	System.out.println("2 Pound in KG = " + converted);

	    	QuantityWeight converted2 =
	    	        new QuantityWeight(1.0, WeightUnit.KILOGRAM)
	    	                .convertTo(WeightUnit.POUND);

	    	System.out.println("1 KG in Pound = " + converted2);

	    	System.out.println("------------------------------------------------");

	    	// Addition (implicit unit)
	    	QuantityWeight addWeight =
	    	        new QuantityWeight(1.0, WeightUnit.KILOGRAM)
	    	                .add(new QuantityWeight(500.0, WeightUnit.GRAM));

	    	System.out.println("1 KG + 500 G = " + addWeight);

	    	System.out.println("------------------------------------------------");

	    	// Addition (explicit target unit)
	    	QuantityWeight addTarget =
	    	        new QuantityWeight(1.0, WeightUnit.KILOGRAM)
	    	                .add(new QuantityWeight(1000.0, WeightUnit.GRAM), WeightUnit.GRAM);

	    	System.out.println("1 KG + 1000 G in Gram = " + addTarget);
	    	
	        // UC1–UC4 - Equality
	        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
	        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCHES);

	        System.out.println("1 Foot equals 12 Inches ? -> " + feet.equals(inches));

	        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
	        System.out.println("1 Yard equals 3 Feet ? -> " + yard.equals(new QuantityLength(3.0, LengthUnit.FEET)));

	        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
	        System.out.println("1 CM equals 0.393701 Inches ? -> " +
	                cm.equals(new QuantityLength(0.393701, LengthUnit.INCHES)));

	        System.out.println("------------------------------------------------");

	        // UC5 - Addition
	        QuantityLength resultAdd =
	                new QuantityLength(1.0, LengthUnit.FEET)
	                        .add(new QuantityLength(11.0, LengthUnit.INCHES));

	        System.out.println("1 Foot + 11 Inches = " + resultAdd);

	        // UC5 - Subtraction
	        QuantityLength resultSub =
	                new QuantityLength(2.0, LengthUnit.FEET)
	                        .subtract(new QuantityLength(12.0, LengthUnit.INCHES));

	        System.out.println("2 Feet - 12 Inches = " + resultSub);

	        System.out.println("------------------------------------------------");

	        // UC6 - Comparison
	        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.FEET);
	        QuantityLength q2 = new QuantityLength(18.0, LengthUnit.INCHES);

	        int comparison = q1.compareTo(q2);

	        if (comparison > 0) {
	            System.out.println("2 Feet is greater than 18 Inches");
	        } else if (comparison < 0) {
	            System.out.println("2 Feet is less than 18 Inches");
	        } else {
	            System.out.println("2 Feet equals 18 Inches");
	       }
	        
	       // UC7 - Conversion
	        System.out.println("------------------------------------------------");
	        QuantityLength result =
	                QuantityLength.add(
	                        new QuantityLength(1.0, LengthUnit.FEET),
	                        new QuantityLength(12.0, LengthUnit.INCHES),
	                        LengthUnit.YARDS);

	        System.out.println(result);
	   }
}