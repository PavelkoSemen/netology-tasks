package ru.netology.serviceexception;

public class CatServiceException extends Exception{
    public CatServiceException() {
    }

    public CatServiceException(String message) {
        super(message);
    }
}
