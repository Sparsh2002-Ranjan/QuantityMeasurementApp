package com.quantitymeasurement.app.repository;

<<<<<<< HEAD
import com.quantitymeasurement.app.entity.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IQuantityMeasurementRepository extends JpaRepository<QuantityMeasurementEntity, Long> {
    List<QuantityMeasurementEntity> findByUserEmail(String userEmail);
}
=======
import java.util.List;

import com.quantitymeasurement.app.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAllMeasurements();

    void deleteAll();
    
    void initializeDatabase();
}
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
