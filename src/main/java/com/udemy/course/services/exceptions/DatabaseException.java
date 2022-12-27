package com.udemy.course.services.exceptions;

//classe criada para personlaizar o tratamento de DatabaseException
public class DatabaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg){
        super(msg);
    }
}
