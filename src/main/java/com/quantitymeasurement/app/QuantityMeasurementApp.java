package com.quantitymeasurement.app;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuantityMeasurementApp {
<<<<<<< HEAD
    public static void main(String[] args) {
        SpringApplication.run(QuantityMeasurementApp.class, args);
    }
}
=======
import com.quantitymeasurement.controller.QuantityMeasurementController;
import com.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.quantitymeasurement.service.QuantityMeasurementServiceImpl;
import com.quantitymeasurement.dto.QuantityDTO;
=======
import com.quantitymeasurement.repository.*;
import com.quantitymeasurement.service.*;
import com.quantitymeasurement.app.util.ApplicationConfig;
import org.h2.tools.Server;
>>>>>>> feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence

public class QuantityMeasurementApp {

    public static void main(String[] args) {

<<<<<<< HEAD
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
>>>>>>> feature/UC15-N-Tier
=======
        try {
            Server.createWebServer("-web","-webAllowOthers","-webPort","8082").start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        IQuantityMeasurementRepository repository;

        String repoType =
                ApplicationConfig.getProperty("app.repository.type");

        if ("database".equalsIgnoreCase(repoType)) {
            repository = new QuantityMeasurementDatabaseRepository();
        } else {
            repository = QuantityMeasurementCacheRepository.getInstance();
        }

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repository);

        System.out.println("Application Started");

    }
}
>>>>>>> feature/UC16-Database-Integration-with-JDBC-for-Quantity-Measurement-Persistence
=======

    public static void main(String[] args) {
        SpringApplication.run(QuantityMeasurementApp.class, args);
    }
}
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
