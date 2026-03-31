package com.feetandinchmeasuments;

import java.util.Objects;

public class QuantityLength implements Comparable<QuantityLength> {

    private final double value;
    private final LengthUnit unit;

    private static final double TOLERANCE = 0.00001;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.toBase(value);
    }

    // UC5 → Addition
    public QuantityLength add(QuantityLength other) {
        double sum = this.toBaseUnit() + other.toBaseUnit();
        return new QuantityLength(sum, LengthUnit.FEET);
    }

    // UC5 → Subtraction
    public QuantityLength subtract(QuantityLength other) {
        double diff = this.toBaseUnit() - other.toBaseUnit();
        return new QuantityLength(diff, LengthUnit.FEET);
    }

    // UC6 → Comparison
    @Override
    public int compareTo(QuantityLength other) {
        double diff = this.toBaseUnit() - other.toBaseUnit();
        if (Math.abs(diff) < TOLERANCE) return 0;
        return diff > 0 ? 1 : -1;
    }

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
        return value + " " + unit;
    }
}