package com.quantitymeasurement.app.core;

<<<<<<< HEAD
public class Quantity<T extends IMeasurable> {

    private double value;
    private T unit;

    public Quantity(double value, T unit) {
=======
public class Quantity<U extends IMeasurable> {

    private double value;
    private U unit;

    private static final double TOLERANCE = 0.0001;

    public Quantity(double value, U unit) {
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
        this.value = value;
        this.unit = unit;
    }

<<<<<<< HEAD
    public double getValue() { return value; }
    public T getUnit() { return unit; }

    public double toBase() {
        return unit.toBaseUnit(value);
    }

    public Quantity<T> convertTo(T targetUnit) {
        double base = unit.toBaseUnit(value);
        double converted = targetUnit.fromBaseUnit(base);
        return new Quantity<>(converted, targetUnit);
    }

    public Quantity<T> add(Quantity<T> other) {
        double base = this.toBase() + other.toBase();
        double result = unit.fromBaseUnit(base);
        return new Quantity<>(result, unit);
    }

    public double divide(Quantity<T> other) {
        return this.toBase() / other.toBase();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;
        Quantity<?> other = (Quantity<?>) obj;
        return Math.abs(this.toBase() - other.toBase()) < 0.0001;
    }
}
=======
    public double toBaseUnit() {
        return unit.toBaseUnit(value);
    }

    public Quantity<U> convertTo(U targetUnit) {

        double base = unit.toBaseUnit(value);
        double converted = targetUnit.fromBaseUnit(base);

        return new Quantity<>(converted, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {

        unit.validateOperationSupport("addition");

        double result = this.toBaseUnit() + other.toBaseUnit();
        double converted = unit.fromBaseUnit(result);

        return new Quantity<>(converted, unit);
    }

    public Quantity<U> subtract(Quantity<U> other) {

        unit.validateOperationSupport("subtraction");

        double result = this.toBaseUnit() - other.toBaseUnit();
        double converted = unit.fromBaseUnit(result);

        return new Quantity<>(converted, unit);
    }

    public double divide(Quantity<U> other) {

        unit.validateOperationSupport("division");

        return this.toBaseUnit() / other.toBaseUnit();
    }

    public boolean equals(Object obj) {

        if (!(obj instanceof Quantity)) return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (!this.unit.getClass().equals(other.unit.getClass()))
            return false;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < TOLERANCE;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }
}
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
