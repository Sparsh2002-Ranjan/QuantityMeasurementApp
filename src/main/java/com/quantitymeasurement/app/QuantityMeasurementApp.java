package com.quantitymeasurement.app;

import com.quantitymeasurement.repository.*;
import com.quantitymeasurement.service.*;
import com.quantitymeasurement.app.util.ApplicationConfig;
import org.h2.tools.Server;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

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