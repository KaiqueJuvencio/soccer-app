package com.br.soccerapp.exceptionhandler;


import com.br.soccerapp.dto.ResponseMessageDTO;
import com.br.soccerapp.exceptionhandler.exceptions.BadRequestException;
import com.br.soccerapp.exceptionhandler.exceptions.ObjectNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ApiExceptionHandler {
    ResponseMessageDTO response = new ResponseMessageDTO();

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseMessageDTO> handleBadRequestException(BadRequestException exception,
                                                                     HttpServletRequest request) {
        response.setStatusType(HttpStatus.BAD_REQUEST);
        response.setPath(request.getRequestURI());
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setTimestamp(Instant.now());
        response.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ObjectNullException.class)
    public ResponseEntity<ResponseMessageDTO> objectNullException(ObjectNullException exception,
                                                                        HttpServletRequest request) {
        response.setStatusType(HttpStatus.BAD_REQUEST);
        response.setPath(request.getRequestURI());
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setTimestamp(Instant.now());
        response.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
