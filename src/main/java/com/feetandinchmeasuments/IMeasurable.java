package com.feetandinchmeasuments;

public interface IMeasurable {

    double toBaseUnit(double value);

    double fromBaseUnit(double value);

    // Lambda indicating arithmetic support (default = true)
    SupportsArithmetic supportsArithmetic = () -> true;

    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    // Validate arithmetic operation
    default void validateOperationSupport(String operation) {
        // default allows all
    }
}
