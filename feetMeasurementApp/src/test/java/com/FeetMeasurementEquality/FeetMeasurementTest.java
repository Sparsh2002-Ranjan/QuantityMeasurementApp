package com.FeetMeasurementEquality;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.FeetMeasurementEquality.FeetMeasurement.Feet;

public class FeetMeasurementTest {

    @Test
    public void testEquality_SameValue() {
        Feet a = new Feet(1.0);
        Feet b = new Feet(1.0);
        assertTrue(a.equals(b));
    }

    @Test
    public void testEquality_DifferentValue() {
        Feet a = new Feet(1.0);
        Feet b = new Feet(2.0);
        assertFalse(a.equals(b));
    }

    @Test
    public void testEquality_NullComparison() {
        Feet a = new Feet(1.0);
        assertFalse(a.equals(null));
    }

    @Test
    public void testEquality_NonNumericInput() {
        Feet a = new Feet(1.0);
        Object obj = new Object();
        assertFalse(a.equals(obj));
    }

    @Test
    public void testEquality_SameReference() {
        Feet a = new Feet(1.0);
        assertTrue(a.equals(a));
    }
}
