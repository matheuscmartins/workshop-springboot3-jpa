package com.udemy.course.resources.exceptions;

import com.udemy.course.services.exceptions.DatabaseException;
import com.udemy.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

//classe para tratamento manual de erro
@ControllerAdvice //intercepta as exceptions que irão acontecer a serem tratadaS
public class ResourceExceptionHandler {

   @ExceptionHandler(ResourceNotFoundException.class) //para que seja capaz de interceptar qualquer tipo de ResourceNotFoundException
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
    String error = "Resource not found";
       HttpStatus status = HttpStatus.NOT_FOUND;
       StandardError standardError = new StandardError(Instant.now(), status.value(), error,
               e.getMessage(), request.getRequestURI());
       return  ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(DatabaseException.class) //para que seja capaz de interceptar qualquer tipo de DatabaseException
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), status.value(), error,
                e.getMessage(), request.getRequestURI());
        return  ResponseEntity.status(status).body(standardError);
    }
}
