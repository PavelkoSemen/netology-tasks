package ru.netology.logger;

import java.text.SimpleDateFormat;

public class Logger {
    protected int num = 1;
    private static Logger logger;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    private Logger() {
    }


    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }

        return logger;
    }

    public void log(String msg) {
        System.out.println("[" + formatter.format(System.currentTimeMillis()) + " " + num++ + "] " + msg);
    }
}