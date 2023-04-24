package com.hotel_management.project.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s){}
    public static String ResourceNotFoundException(String message){
        return(message);
    }
}
