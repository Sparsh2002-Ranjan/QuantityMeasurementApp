package com.quantitymeasurement.app;

import com.quantitymeasurement.controller.QuantityMeasurementController;
import com.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.quantitymeasurement.service.QuantityMeasurementServiceImpl;
import com.quantitymeasurement.dto.QuantityDTO;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityMeasurementCacheRepository repository =
                QuantityMeasurementCacheRepository.getInstance();

        QuantityMeasurementServiceImpl service =
                new QuantityMeasurementServiceImpl(repository);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        QuantityDTO q1 = new QuantityDTO(1, "FEET");
        QuantityDTO q2 = new QuantityDTO(12, "INCHES");

        controller.performComparison(q1, q2);
    }
}