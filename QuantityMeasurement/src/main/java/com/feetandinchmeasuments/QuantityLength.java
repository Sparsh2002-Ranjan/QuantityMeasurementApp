package com.feetandinchmeasuments;

import java.util.Objects;

public class QuantityLength implements Comparable<QuantityLength> {

    private final double value;
    private final LengthUnit unit;

    private static final double TOLERANCE = 0.00001;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.toBase(value);
    }

    // ======== Private Utility for Addition (UC7 DRY principle) ========
    private static QuantityLength addInternal(
            QuantityLength q1,
            QuantityLength q2,
            LengthUnit targetUnit) {

        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Quantities cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseSum = q1.toBaseUnit() + q2.toBaseUnit();
        double converted = targetUnit.fromBase(baseSum);

        return new QuantityLength(converted, targetUnit);
    }

    // ======== UC5 (Backward Compatible) ========
    public QuantityLength add(QuantityLength other) {
        return addInternal(this, other, this.unit);
    }

    public QuantityLength subtract(QuantityLength other) {
        double baseDiff = this.toBaseUnit() - other.toBaseUnit();
        double converted = this.unit.fromBase(baseDiff);
        return new QuantityLength(converted, this.unit);
    }

    // ======== UC7 (Explicit Target Unit) ========
    public static QuantityLength add(
            QuantityLength q1,
            QuantityLength q2,
            LengthUnit targetUnit) {

        return addInternal(q1, q2, targetUnit);
    }

    // ======== UC6 Comparison ========
    @Override
    public int compareTo(QuantityLength other) {
        double diff = this.toBaseUnit() - other.toBaseUnit();

        if (Math.abs(diff) < TOLERANCE)
            return 0;

        return diff > 0 ? 1 : -1;
    }

    // ======== UC1–UC4 Equality ========
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

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}