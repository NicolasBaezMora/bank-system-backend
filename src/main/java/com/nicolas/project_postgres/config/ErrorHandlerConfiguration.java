package com.nicolas.project_postgres.config;

import com.nicolas.project_postgres.exceptions.GeneralServiceException;
import com.nicolas.project_postgres.exceptions.NoDataFoundException;
import com.nicolas.project_postgres.exceptions.ValidateServiceException;
import com.nicolas.project_postgres.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerConfiguration {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> all(Exception e) {
        ErrorResponse err = ErrorResponse.builder()
                .error(e.getMessage())
                .build();
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GeneralServiceException.class)
    public ResponseEntity<ErrorResponse> generalServiceException(GeneralServiceException e) {
        ErrorResponse err = ErrorResponse.builder()
                .error(e.getMessage())
                .build();
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ErrorResponse> noDataFoundException(NoDataFoundException e) {
        ErrorResponse err = ErrorResponse.builder()
                .error(e.getMessage())
                .build();
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateServiceException.class)
    public ResponseEntity<ErrorResponse> validateServiceException(ValidateServiceException e) {
        ErrorResponse err = ErrorResponse.builder()
                .error(e.getMessage())
                .build();
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
