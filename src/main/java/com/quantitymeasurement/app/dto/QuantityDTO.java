package com.quantitymeasurement.app.dto;

public class QuantityDTO {
<<<<<<< HEAD
    private double value;
    private String unit;

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
}
=======

    private double value;
    private String unit;
    private String measurementType;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }
}
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
