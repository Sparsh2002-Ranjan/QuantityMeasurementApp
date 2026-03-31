package com.feetandinchmeasuments;

import java.util.Objects;

public class Quantity<U extends Enum<U> & IMeasurable>
        implements Comparable<Quantity<U>> {

    private final double value;
    private final U unit;

    private static final double TOLERANCE = 0.00001;

    public Quantity(double value, U unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.toBaseUnit(value);
    }

    // Conversion
    public Quantity<U> convertTo(U targetUnit) {

        double base = unit.toBaseUnit(value);
        double converted = targetUnit.fromBaseUnit(base);

        return new Quantity<>(converted, targetUnit);
    }

    // Addition
    public Quantity<U> add(Quantity<U> other) {

        unit.validateOperationSupport("addition");

        double baseSum =
                this.toBaseUnit() + other.toBaseUnit();

        double converted =
                unit.fromBaseUnit(baseSum);

        return new Quantity<>(converted, unit);
    }

    // Subtraction
    public Quantity<U> subtract(Quantity<U> other) {

        unit.validateOperationSupport("subtraction");

        double baseDiff =
                this.toBaseUnit() - other.toBaseUnit();

        double converted =
                unit.fromBaseUnit(baseDiff);

        return new Quantity<>(converted, unit);
    }

    // Division
    public double divide(Quantity<U> other) {

        unit.validateOperationSupport("division");

        return this.toBaseUnit() / other.toBaseUnit();
    }

    // Equality
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Quantity<?> other))
            return false;

        if (!unit.getClass().equals(other.unit.getClass()))
            return false;

        return Math.abs(
                this.toBaseUnit() - other.toBaseUnit()
        ) < TOLERANCE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBaseUnit());
    }

    // Comparison
    @Override
    public int compareTo(Quantity<U> other) {

        double diff =
                this.toBaseUnit() - other.toBaseUnit();

        if (Math.abs(diff) < TOLERANCE)
            return 0;

        return diff > 0 ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}