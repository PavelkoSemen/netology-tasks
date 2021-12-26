package ru.netology.myexception;

public class PropertyNotFoundException extends Exception{
    public PropertyNotFoundException() {
    }

    public PropertyNotFoundException(String message) {
        super(message);
    }

    public PropertyNotFoundException(Throwable cause) {
        super(cause);
    }
}
