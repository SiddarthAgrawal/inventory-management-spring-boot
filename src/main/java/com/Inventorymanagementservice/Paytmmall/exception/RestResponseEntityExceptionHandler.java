package com.Inventorymanagementservice.Paytmmall.exception;

import com.Inventorymanagementservice.Paytmmall.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> ProductNotFoundException(ProductNotFoundException exception,
                                                                 WebRequest request)
    {
        ErrorMessage message = new ErrorMessage(exception.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(QuantityNotGreaterThanZeroException.class)
    public ResponseEntity<ErrorMessage> QuantityNotGreaterThanZeroException(QuantityNotGreaterThanZeroException exception,
                                                                                   WebRequest request)
    {
        ErrorMessage message = new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

}
