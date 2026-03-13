package com.quantitymeasurement.service;

import com.quantitymeasurement.dto.QuantityDTO;
import com.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.quantitymeasurement.core.Quantity;
import com.quantitymeasurement.units.LengthUnit;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    public boolean compare(QuantityDTO q1, QuantityDTO q2) {

        LengthUnit unit1 = LengthUnit.valueOf(q1.getUnit());
        LengthUnit unit2 = LengthUnit.valueOf(q2.getUnit());

        Quantity quantity1 = new Quantity(q1.getValue(), unit1);
        Quantity quantity2 = new Quantity(q2.getValue(), unit2);

        return quantity1.equals(quantity2);
    }

    public QuantityDTO convert(QuantityDTO input, String targetUnit) {

        LengthUnit unit = LengthUnit.valueOf(input.getUnit());
        LengthUnit target = LengthUnit.valueOf(targetUnit);

        Quantity quantity = new Quantity(input.getValue(), unit);
        Quantity result = quantity.convertTo(target);

        return new QuantityDTO(result.getValue(), targetUnit);
    }

    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        LengthUnit unit1 = LengthUnit.valueOf(q1.getUnit());
        LengthUnit unit2 = LengthUnit.valueOf(q2.getUnit());

        Quantity quantity1 = new Quantity(q1.getValue(), unit1);
        Quantity quantity2 = new Quantity(q2.getValue(), unit2);

        Quantity result = quantity1.add(quantity2);

        return new QuantityDTO(result.getValue(), result.getUnit().toString());
    }

    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

        LengthUnit unit1 = LengthUnit.valueOf(q1.getUnit());
        LengthUnit unit2 = LengthUnit.valueOf(q2.getUnit());

        Quantity quantity1 = new Quantity(q1.getValue(), unit1);
        Quantity quantity2 = new Quantity(q2.getValue(), unit2);

        Quantity result = quantity1.subtract(quantity2);

        return new QuantityDTO(result.getValue(), result.getUnit().toString());
    }

    public double divide(QuantityDTO q1, QuantityDTO q2) {

        LengthUnit unit1 = LengthUnit.valueOf(q1.getUnit());
        LengthUnit unit2 = LengthUnit.valueOf(q2.getUnit());

        Quantity quantity1 = new Quantity(q1.getValue(), unit1);
        Quantity quantity2 = new Quantity(q2.getValue(), unit2);

        return quantity1.divide(quantity2);
    }
}