package com.feetandinchmeasuments;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.feetandinchmeasuments.QuantityLength;
import com.feetandinchmeasuments.LengthUnit;

class QuantityLengthTest {

    //  Feet to Feet (Same Value)
    @Test
    void testEquality_FeetToFeet_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    //  Inch to Inch (Same Value)
    @Test
    void testEquality_InchToInch_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    //  Feet to Inch (Equivalent Value)
    @Test
    void testEquality_FeetToInch_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    //  Inch to Feet (Equivalent Value - Symmetry)
    @Test
    void testEquality_InchToFeet_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    //  Feet to Feet (Different Value)
    @Test
    void testEquality_FeetToFeet_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    //  Inch to Inch (Different Value)
    @Test
    void testEquality_InchToInch_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.INCH);

        assertFalse(q1.equals(q2));
    }

    //  Invalid Unit (Handled via Enum – compile-time safety)
    @Test
    void testEquality_InvalidUnit() {
        // Since LengthUnit is an enum, invalid units can't be passed.
        // So we simulate by expecting exception for null.
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1.0, null);
        });
    }

    //  Null Unit
    @Test
    void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(5.0, null);
        });
    }

    //  Same Reference (Reflexive Property)
    @Test
    void testEquality_SameReference() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q1));
    }

    //  Null Comparison
    @Test
    void testEquality_NullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);

        assertFalse(q1.equals(null));
    }
}