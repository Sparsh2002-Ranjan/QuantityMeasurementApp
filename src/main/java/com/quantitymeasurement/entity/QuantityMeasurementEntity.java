package com.quantitymeasurement.entity;

<<<<<<< HEAD
import java.io.Serializable;

public class QuantityMeasurementEntity implements Serializable {

    private static final long serialVersionUID = 1L;
=======
public class QuantityMeasurementEntity {
>>>>>>> feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence

    private String operation;
    private String operand1;
    private String operand2;
    private String result;
<<<<<<< HEAD
    private String error;
=======
>>>>>>> feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence

    public QuantityMeasurementEntity(String operation, String operand1, String operand2, String result) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }

<<<<<<< HEAD
    public QuantityMeasurementEntity(String error) {
        this.error = error;
    }

    public boolean hasError() {
        return error != null;
=======
    public String getOperation() {
        return operation;
    }

    public String getOperand1() {
        return operand1;
    }

    public String getOperand2() {
        return operand2;
>>>>>>> feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence
    }

    public String getResult() {
        return result;
    }
}