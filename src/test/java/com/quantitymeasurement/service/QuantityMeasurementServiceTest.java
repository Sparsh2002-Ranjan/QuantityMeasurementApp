package com.quantitymeasurement.service;

import com.quantitymeasurement.dto.QuantityDTO;
import com.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementServiceTest {

    private QuantityMeasurementServiceImpl service;

    @BeforeEach
    void setup() {
        service = new QuantityMeasurementServiceImpl(
                QuantityMeasurementCacheRepository.getInstance()
        );
    }

    @Test
    void givenSameFeet_shouldReturnTrue() {

        QuantityDTO q1 = new QuantityDTO(1, "FEET");
        QuantityDTO q2 = new QuantityDTO(1, "FEET");

        assertTrue(service.compare(q1, q2));
    }

    @Test
    void givenFeetAndInches_shouldReturnTrue() {

        QuantityDTO q1 = new QuantityDTO(1, "FEET");
        QuantityDTO q2 = new QuantityDTO(12, "INCHES");

        assertTrue(service.compare(q1, q2));
    }

    @Test
    void givenDifferentValues_shouldReturnFalse() {

        QuantityDTO q1 = new QuantityDTO(1, "FEET");
        QuantityDTO q2 = new QuantityDTO(2, "FEET");

        assertFalse(service.compare(q1, q2));
    }

    @Test
    void givenFeet_shouldConvertToInches() {

        QuantityDTO input = new QuantityDTO(1, "FEET");

        QuantityDTO result = service.convert(input, "INCHES");

        assertEquals(12, result.getValue(), 0.01);
    }

    @Test
    void givenTwoQuantities_shouldAddCorrectly() {

        QuantityDTO q1 = new QuantityDTO(1, "FEET");
        QuantityDTO q2 = new QuantityDTO(11, "INCHES");

        QuantityDTO result = service.add(q1, q2);

        assertEquals(1.9166, result.getValue(), 0.01);
    }

    @Test
    void givenTwoQuantities_shouldSubtractCorrectly() {

        QuantityDTO q1 = new QuantityDTO(2, "FEET");
        QuantityDTO q2 = new QuantityDTO(12, "INCHES");

        QuantityDTO result = service.subtract(q1, q2);

        assertEquals(1, result.getValue(), 0.01);
    }

    @Test
    void givenTwoQuantities_shouldDivideCorrectly() {

        QuantityDTO q1 = new QuantityDTO(2, "FEET");
        QuantityDTO q2 = new QuantityDTO(1, "FEET");

        double result = service.divide(q1, q2);

        assertEquals(2, result);
    }
}