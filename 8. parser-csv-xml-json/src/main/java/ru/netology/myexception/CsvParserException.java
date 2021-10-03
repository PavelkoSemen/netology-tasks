package ru.netology.myexception;

public class CsvParserException extends Exception {
    public CsvParserException() {
    }

    public CsvParserException(String message) {
        super(message);
    }
}
