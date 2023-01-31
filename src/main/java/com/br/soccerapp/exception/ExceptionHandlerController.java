package com.br.soccerapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerController {

    ResponseMessage response = new ResponseMessage();

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseMessage> handleBadRequestException(BadRequestException badRequestException, HttpServletRequest request) {
        response.setStatusType(HttpStatus.BAD_REQUEST);
        response.setPath(request.getRequestURI());
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setTimestamp(Instant.now());
        response.setMessage(badRequestException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ObjectNullException.class)
    public ResponseEntity<ResponseMessage> handleObjectNullException(ObjectNullException objectNullException, HttpServletRequest request) {
        response.setStatusType(HttpStatus.BAD_REQUEST);
        response.setPath(request.getRequestURI());
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setTimestamp(Instant.now());
        response.setMessage(objectNullException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
