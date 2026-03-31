package com.feetandinchmeasuments;

public class QuantityMeasurementApp {

	    public static void main(String[] args) {

<<<<<<< HEAD
	        // UC1–UC4 → Equality
=======
	        // UC1–UC4 - Equality
>>>>>>> feature/UC8-Refactoring-Unit-Enum-To-Standalone
	        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
	        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCHES);

	        System.out.println("1 Foot equals 12 Inches ? -> " + feet.equals(inches));

	        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
	        System.out.println("1 Yard equals 3 Feet ? -> " + yard.equals(new QuantityLength(3.0, LengthUnit.FEET)));

	        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
	        System.out.println("1 CM equals 0.393701 Inches ? -> " +
	                cm.equals(new QuantityLength(0.393701, LengthUnit.INCHES)));

	        System.out.println("------------------------------------------------");

<<<<<<< HEAD
	        // UC5 → Addition
=======
	        // UC5 - Addition
>>>>>>> feature/UC8-Refactoring-Unit-Enum-To-Standalone
	        QuantityLength resultAdd =
	                new QuantityLength(1.0, LengthUnit.FEET)
	                        .add(new QuantityLength(11.0, LengthUnit.INCHES));

	        System.out.println("1 Foot + 11 Inches = " + resultAdd);

<<<<<<< HEAD
	        // UC5 → Subtraction
=======
	        // UC5 - Subtraction
>>>>>>> feature/UC8-Refactoring-Unit-Enum-To-Standalone
	        QuantityLength resultSub =
	                new QuantityLength(2.0, LengthUnit.FEET)
	                        .subtract(new QuantityLength(12.0, LengthUnit.INCHES));

	        System.out.println("2 Feet - 12 Inches = " + resultSub);

	        System.out.println("------------------------------------------------");

<<<<<<< HEAD
	        // UC6 → Comparison
=======
	        // UC6 - Comparison
>>>>>>> feature/UC8-Refactoring-Unit-Enum-To-Standalone
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