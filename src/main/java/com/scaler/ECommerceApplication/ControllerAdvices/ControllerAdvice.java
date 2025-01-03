package com.scaler.ECommerceApplication.ControllerAdvices;

import ProductDataTransferObject.ExceptionHandlingDTO;
import com.scaler.ECommerceApplication.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class ControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)

    public ResponseEntity<ExceptionHandlingDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException){

        ExceptionHandlingDTO exceptionHandlingDTO = new ExceptionHandlingDTO();

        exceptionHandlingDTO.setMessage(productNotFoundException.getMessage());

        ResponseEntity<ExceptionHandlingDTO> screenMessage = new ResponseEntity<>(exceptionHandlingDTO, HttpStatus.NOT_FOUND);

        return screenMessage;

    }
}
