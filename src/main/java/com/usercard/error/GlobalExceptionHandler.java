package com.usercard.error;

import com.usercard.error.exceptions.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private MessageAccessor messageAccessor;
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        LOGGER.error("Unexpected error", ex);
        return new ResponseEntity<>(
            build(MessageConstants.UNEXPECTED_ERROR),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponse>> handleBeanValidationException(MethodArgumentNotValidException ex) {
        LOGGER.error("Form error", ex);
        List<ErrorResponse> errors = ex.getBindingResult().getFieldErrors().stream().map(error ->
            build(error.getDefaultMessage())
        ).collect(Collectors.toList());
        return new ResponseEntity<>(
            errors,
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        LOGGER.error("Unexpected error", ex);
        return new ResponseEntity<>(
            build(ex.getMessage()),
            HttpStatus.NOT_FOUND
        );
    }

    private ErrorResponse build(String code) {
        return new ErrorResponse(
            code,
            messageAccessor.getMessage(code, null)
        );
    }
}
