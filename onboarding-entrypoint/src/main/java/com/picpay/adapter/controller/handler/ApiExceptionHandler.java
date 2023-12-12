package com.picpay.adapter.controller.handler;

import com.picpay.exceptions.AddresNotFoundException;
import com.picpay.exceptions.CpfAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import com.picpay.adapter.controller.handler.ErrorMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(AddresNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage addresNotFoundException(AddresNotFoundException ex, HttpServletRequest request) {
        ErrorMessage message = ErrorMessage.builder()
                .timestamp(System.currentTimeMillis())
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
        .build();
        return message;
    }
    @ExceptionHandler(CpfAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage cpfAlreadyExistsException(CpfAlreadyExistsException ex, HttpServletRequest request) {
        ErrorMessage message = ErrorMessage.builder()
                .timestamp(System.currentTimeMillis())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .build();
        return message;
    }

}
