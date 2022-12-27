package com.udemy.course.services.exceptions;

//classe para tratamento de erro
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id "+ id);
    }
}
