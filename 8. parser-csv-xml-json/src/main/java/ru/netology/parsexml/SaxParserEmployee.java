package ru.netology.parsexml;

import lombok.extern.slf4j.Slf4j;
import org.xml.sax.SAXException;
import ru.netology.entity.Employee;
import ru.netology.myexception.SaxParserException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

import static ru.netology.fileutil.FileUtil.*;

@Slf4j
public class SaxParserEmployee {

    public static List<Employee> parse(String fileName) throws SaxParserException {
        log.info("Start sax parsing '{}' file", fileName);

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser;

        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            log.error("Error create new sax parser", e);
            throw new SaxParserException("Error create new sax parser");
        }

        try {
            parser.parse(getReaderFromResources(fileName), handler);
        } catch (SAXException e) {
            log.error("Sax parsing error ", e);
            throw new SaxParserException("Sax parsing error");

        } catch (IOException e) {
            log.error("IO parsing error ", e);
            throw new SaxParserException("IO parsing error");
        }

        log.info("Finish sax parsing '{}' file", fileName);

        return handler.getEmployees();
    }
}
