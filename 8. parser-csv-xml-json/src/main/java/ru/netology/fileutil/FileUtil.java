package ru.netology.fileutil;

import lombok.extern.slf4j.Slf4j;
import ru.netology.myexception.FileUtilException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

@Slf4j
public class FileUtil {
    public static InputStream getReaderFromResources(String fileName) {
        return Objects.requireNonNull(FileUtil.class
                .getClassLoader()
                .getResourceAsStream(fileName));
    }

    public static void writeString(String fileName, String text) throws FileUtilException {
        log.info("Start write to file '{}'", fileName);
        Path path = Path.of("8. parser-csv-xml-json/src/main/resources/" + fileName);
        try {
            Files.writeString(path, text);
        } catch (IOException e) {
            log.error("Error write to file ", e);
            throw new FileUtilException("Error write to file '" + fileName + "'");
        }
        log.info("Finish write to file '{}'", fileName);
    }

    public static String readFile(String fileName) throws FileUtilException {
        log.info("Start read file '{}'", fileName);
        try (BufferedReader bf = new BufferedReader(
                new InputStreamReader(getReaderFromResources(fileName), StandardCharsets.UTF_8)
        )) {
            String outString;
            StringBuilder totalString = new StringBuilder();

            while ((outString = bf.readLine()) != null) {
                totalString.append(outString);
            }
            log.info("Finish read file '{}'", fileName);
            return totalString.toString();
        } catch (NullPointerException e) {
            log.error("File '{}' not found", fileName);
            throw new FileUtilException("File '" + fileName + "' not found");

        } catch (IOException e) {
            log.error("Error io");
            throw new FileUtilException("Error io");
        }
    }
}
