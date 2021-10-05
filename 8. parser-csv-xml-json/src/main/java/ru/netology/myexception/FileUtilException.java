package ru.netology.myexception;

public class FileUtilException extends Exception{
    public FileUtilException() {
        super();
    }

    public FileUtilException(String message) {
        super(message);
    }
}
