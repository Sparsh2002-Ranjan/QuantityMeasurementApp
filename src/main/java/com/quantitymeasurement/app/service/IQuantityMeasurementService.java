package com.quantitymeasurement.app.service;

<<<<<<< HEAD
import com.quantitymeasurement.app.dto.QuantityInputDTO;
import com.quantitymeasurement.app.dto.ResponseDTO;
import java.util.List;

public interface IQuantityMeasurementService {
    ResponseDTO convertQuantities(QuantityInputDTO dto, String userEmail);
    List<ResponseDTO> getHistoryForUser(String userEmail);
}
=======
import java.util.List;

import com.quantitymeasurement.app.dto.QuantityInputDTO;
import com.quantitymeasurement.app.dto.ResponseDTO;

public interface IQuantityMeasurementService {

    ResponseDTO compareQuantities(QuantityInputDTO dto);

    ResponseDTO convertQuantities(QuantityInputDTO dto);

    ResponseDTO addQuantities(QuantityInputDTO dto);

    ResponseDTO divideQuantities(QuantityInputDTO dto);

    long getOperationCount(String operation);

    List<ResponseDTO> getHistoryByOperation(String operation);

    List<ResponseDTO> getHistoryByType(String type);

    List<ResponseDTO> getErrorHistory();
}
>>>>>>> feature/UC17-Spring-Backend-for-Quantit-Measurement
