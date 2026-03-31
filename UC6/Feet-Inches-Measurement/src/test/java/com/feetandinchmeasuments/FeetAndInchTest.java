package com.feetandinchmeasuments;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    // ================= UC1–UC4 (Equality Tests) =================

    @Test
    void testFeetToFeetEqual() {
        assertTrue(new QuantityLength(1.0, LengthUnit.FEET)
                .equals(new QuantityLength(1.0, LengthUnit.FEET)));
    }

    @Test
    void testFeetToInchesEqual() {
        assertTrue(new QuantityLength(1.0, LengthUnit.FEET)
                .equals(new QuantityLength(12.0, LengthUnit.INCHES)));
    }

    @Test
    void testYardToFeetEqual() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARDS)
                .equals(new QuantityLength(3.0, LengthUnit.FEET)));
    }

    @Test
    void testCentimeterToInchesEqual() {
        assertTrue(new QuantityLength(1.0, LengthUnit.CENTIMETERS)
                .equals(new QuantityLength(0.393701, LengthUnit.INCHES)));
    }

    @Test
    void testDifferentValuesNotEqual() {
        assertFalse(new QuantityLength(1.0, LengthUnit.FEET)
                .equals(new QuantityLength(2.0, LengthUnit.FEET)));
    }

    @Test
    void testNullUnitThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new QuantityLength(5.0, null));
    }

    // ================= UC5 (Addition & Subtraction) =================

    @Test
    void testAddition_FeetAndInches() {
        QuantityLength result =
                new QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityLength(11.0, LengthUnit.INCHES));

        assertTrue(result.equals(new QuantityLength(1.9166667, LengthUnit.FEET)));
    }

    @Test
    void testSubtraction_FeetAndInches() {
        QuantityLength result =
                new QuantityLength(2.0, LengthUnit.FEET)
                        .subtract(new QuantityLength(12.0, LengthUnit.INCHES));

        assertTrue(result.equals(new QuantityLength(1.0, LengthUnit.FEET)));
    }

    // ================= UC6 (Comparison) =================

    @Test
    void testComparison_GreaterThan() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        assertTrue(q1.compareTo(q2) > 0);
    }

    @Test
    void testComparison_LessThan() {
        QuantityLength q1 = new QuantityLength(6.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(q1.compareTo(q2) < 0);
    }

    @Test
    void testComparison_Equal() {
        QuantityLength q1 = new QuantityLength(3.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(9.0, LengthUnit.FEET);

        assertEquals(0, q1.compareTo(q2));
    }
}