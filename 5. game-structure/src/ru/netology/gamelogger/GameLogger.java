package ru.netology.gamelogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class GameLogger {
    private final String path;
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private final String LOG_FORMAT = "%s - %s.";

    public GameLogger(String rootPath) {
        path = rootPath + "/tmp";
        if (!initLogger()) {
            System.out.println("Ошибка создания лога");
        }
    }

    public void info(String info) {

        String nameFile = path + "/temp.txt";
        GregorianCalendar calendar = new GregorianCalendar();

        try (FileWriter writer = new FileWriter(nameFile, true)) {
            String messages = String.format(
                    LOG_FORMAT
                    , DATE_FORMAT.format(calendar.getTime())
                    , info);
            writer.write(messages);
            writer.write('\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean initLogger() {
        File logDirectory = new File(path);
        return logDirectory.exists() || logDirectory.mkdir();
    }
}
