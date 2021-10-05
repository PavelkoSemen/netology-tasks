package ru.netology.myexception;

public class SaxParserException extends Exception{
    public SaxParserException() {
    }

    public SaxParserException(String message) {
        super(message);
    }
}
