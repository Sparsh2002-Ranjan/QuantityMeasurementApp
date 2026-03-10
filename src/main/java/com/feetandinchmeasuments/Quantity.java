package com.feetandinchmeasuments;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // Convert to another unit
    public Quantity<U> convertTo(U targetUnit) {
        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new Quantity<>(convertedValue, targetUnit);
    }

    // Add quantities (result in first unit)
    public Quantity<U> add(Quantity<U> other) {
        double baseValue1 = this.unit.convertToBaseUnit(this.value);
        double baseValue2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = baseValue1 + baseValue2;

        double resultValue = this.unit.convertFromBaseUnit(sumBase);

        return new Quantity<>(resultValue, this.unit);
    }

    // Add quantities with explicit target unit
    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double baseValue1 = this.unit.convertToBaseUnit(this.value);
        double baseValue2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = baseValue1 + baseValue2;

        double resultValue = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(resultValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || !(obj instanceof Quantity<?>)) {
            return false;
        }

        Quantity<?> other = (Quantity<?>) obj;

        // Prevent comparing different categories
        if (!this.unit.getClass().equals(other.unit.getClass())) {
            return false;
        }

        double baseValue1 = this.unit.convertToBaseUnit(this.value);
        double baseValue2 = ((IMeasurable) other.unit).convertToBaseUnit(other.value);

        return Math.abs(baseValue1 - baseValue2) < EPSILON;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}