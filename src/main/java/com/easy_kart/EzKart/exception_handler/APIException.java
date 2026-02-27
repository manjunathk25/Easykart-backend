package com.easy_kart.EzKart.exception_handler;

public class APIException extends RuntimeException{

    private static final Long serialVersionUID = 1L;

    public APIException(String message){
        super(message);
    }
}
