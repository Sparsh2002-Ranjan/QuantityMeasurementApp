package com.quantitymeasurement.repository;

import com.quantitymeasurement.entity.QuantityMeasurementEntity;
import java.util.List;

public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity entity);

<<<<<<< HEAD
    List<QuantityMeasurementEntity> findAll();
=======
    List<QuantityMeasurementEntity> getAllMeasurements();

    void deleteAll();
    
    void initializeDatabase();
>>>>>>> feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence
}