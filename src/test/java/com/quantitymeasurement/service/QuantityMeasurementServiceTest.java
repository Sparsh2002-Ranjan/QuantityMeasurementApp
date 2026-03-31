<<<<<<< HEAD
package com.quantitymeasurement.service;

import com.quantitymeasurement.dto.QuantityDTO;
<<<<<<< HEAD
import com.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

=======
import com.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

>>>>>>> feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementServiceTest {

<<<<<<< HEAD
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
=======
    private static IQuantityMeasurementRepository repository;
    private static IQuantityMeasurementService service;

    // ⚡ Toggle DB or cache
    private static boolean useDatabase = true;

    @BeforeAll
    static void setup() {
        repository = useDatabase ? new QuantityMeasurementDatabaseRepository()
                                 : QuantityMeasurementCacheRepository.getInstance();

        if (useDatabase) {
            repository.initializeDatabase(); // create table if not exists
        }

        repository.deleteAll(); // clear previous data
        service = new QuantityMeasurementServiceImpl(repository);
    }

    @Test
    void testAddOperation() {
        QuantityDTO q1 = new QuantityDTO(10, "FEET");
        QuantityDTO q2 = new QuantityDTO(5, "FEET");

        QuantityDTO result = service.add(q1, q2);

        assertEquals(15, result.getValue(), 0.001);
        assertEquals("FEET", result.getUnit());

        List<QuantityMeasurementEntity> data = repository.getAllMeasurements();
        assertEquals("ADD", data.get(data.size() - 1).getOperation()); // last record
    }

    @Test
    void testSubtractOperation() {
        QuantityDTO q1 = new QuantityDTO(10, "FEET");
        QuantityDTO q2 = new QuantityDTO(5, "FEET");

        QuantityDTO result = service.subtract(q1, q2);

        assertEquals(5, result.getValue(), 0.001);

        List<QuantityMeasurementEntity> data = repository.getAllMeasurements();
        assertEquals("SUBTRACT", data.get(data.size() - 1).getOperation());
    }

    @Test
    void testCompareOperationEqual() {
        QuantityDTO q1 = new QuantityDTO(12, "INCHES");
        QuantityDTO q2 = new QuantityDTO(1, "FEET");

        boolean result = service.compare(q1, q2);
        assertTrue(result);

        List<QuantityMeasurementEntity> data = repository.getAllMeasurements();
        assertEquals("COMPARE", data.get(data.size() - 1).getOperation());
    }

    @Test
    void testConvertOperation() {
        QuantityDTO q1 = new QuantityDTO(1, "FEET");

        QuantityDTO result = service.convert(q1, "INCHES");

        assertEquals(12, result.getValue(), 0.001);
        assertEquals("INCHES", result.getUnit());

        List<QuantityMeasurementEntity> data = repository.getAllMeasurements();
        assertEquals("CONVERT", data.get(data.size() - 1).getOperation());
    }

    @Test
    void testDivideOperation() {
        QuantityDTO q1 = new QuantityDTO(10, "FEET");
        QuantityDTO q2 = new QuantityDTO(5, "FEET");

        double result = service.divide(q1, q2);
        assertEquals(2, result, 0.001);

        List<QuantityMeasurementEntity> data = repository.getAllMeasurements();
        assertEquals("DIVIDE", data.get(data.size() - 1).getOperation());
>>>>>>> feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence
    }
}
=======
//package com.quantitymeasurement.service;
//
//import com.quantitymeasurement.dto.QuantityDTO;
//import com.quantitymeasurement.entity.QuantityMeasurementEntity;
//import com.quantitymeasurement.repository.IQuantityMeasurementRepository;
//import com.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
//import com.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class QuantityMeasurementServiceTest {
//
//    private static IQuantityMeasurementRepository repository;
//    private static IQuantityMeasurementService service;
//
//    // ⚡ Toggle DB or cache
//    private static boolean useDatabase = true;
//
//    @BeforeAll
//    static void setup() {
//        repository = useDatabase ? new QuantityMeasurementDatabaseRepository()
//                                 : QuantityMeasurementCacheRepository.getInstance();
//
//        if (useDatabase) {
//            repository.initializeDatabase(); // create table if not exists
//        }
//
//        repository.deleteAll(); // clear previous data
//        service = new QuantityMeasurementServiceImpl(repository);
//    }
//
//    @Test
//    void testAddOperation() {
//        QuantityDTO q1 = new QuantityDTO(10, "FEET");
//        QuantityDTO q2 = new QuantityDTO(5, "FEET");
//
//        QuantityDTO result = service.add(q1, q2);
//
//        assertEquals(15, result.getValue(), 0.001);
//        assertEquals("FEET", result.getUnit());
//
//        List<QuantityMeasurementEntity> data = repository.getAllMeasurements();
//        assertEquals("ADD", data.get(data.size() - 1).getOperation()); // last record
//    }
//
//    @Test
//    void testSubtractOperation() {
//        QuantityDTO q1 = new QuantityDTO(10, "FEET");
//        QuantityDTO q2 = new QuantityDTO(5, "FEET");
//
//        QuantityDTO result = service.subtract(q1, q2);
//
//        assertEquals(5, result.getValue(), 0.001);
//
//        List<QuantityMeasurementEntity> data = repository.getAllMeasurements();
//        assertEquals("SUBTRACT", data.get(data.size() - 1).getOperation());
//    }
//
//    @Test
//    void testCompareOperationEqual() {
//        QuantityDTO q1 = new QuantityDTO(12, "INCHES");
//        QuantityDTO q2 = new QuantityDTO(1, "FEET");
//
//        boolean result = service.compare(q1, q2);
//        assertTrue(result);
//
//        List<QuantityMeasurementEntity> data = repository.getAllMeasurements();
//        assertEquals("COMPARE", data.get(data.size() - 1).getOperation());
//    }
//
//    @Test
//    void testConvertOperation() {
//        QuantityDTO q1 = new QuantityDTO(1, "FEET");
//
//        QuantityDTO result = service.convert(q1, "INCHES");
//
//        assertEquals(12, result.getValue(), 0.001);
//        assertEquals("INCHES", result.getUnit());
//
//        List<QuantityMeasurementEntity> data = repository.getAllMeasurements();
//        assertEquals("CONVERT", data.get(data.size() - 1).getOperation());
//    }
//
//    @Test
//    void testDivideOperation() {
//        QuantityDTO q1 = new QuantityDTO(10, "FEET");
//        QuantityDTO q2 = new QuantityDTO(5, "FEET");
//
//        double result = service.divide(q1, q2);
//        assertEquals(2, result, 0.001);
//
//        List<QuantityMeasurementEntity> data = repository.getAllMeasurements();
//        assertEquals("DIVIDE", data.get(data.size() - 1).getOperation());
//    }
//}
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
