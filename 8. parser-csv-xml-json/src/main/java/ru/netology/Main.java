package ru.netology;

import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import ru.netology.entity.Employee;
import ru.netology.fileutil.FileUtil;
import ru.netology.myexception.CsvParserException;
import ru.netology.myexception.FileUtilException;
import ru.netology.myexception.SaxParserException;
import ru.netology.parsecsv.CsvParser;
import ru.netology.parsejson.JsonParserEmployee;
import ru.netology.parsexml.SaxParserEmployee;

import java.lang.reflect.Type;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args)  {
        csvToJson();
        xmlToJson();
        jsonToListEmployees();
    }

    public static void csvToJson() {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";

        try {
            List<Employee> employees = CsvParser.parseCSV(columnMapping, fileName);
            Type listType = new TypeToken<List<Employee>>() {
            }.getType();
            String stringJson = JsonParserEmployee.listToJson(employees, listType);
            System.out.println(stringJson);
            FileUtil.writeString("CsvToJson.json", stringJson);
        } catch (CsvParserException e) {
            e.printStackTrace();
        } catch (FileUtilException e) {
            e.printStackTrace();
        }
    }

    public static void xmlToJson() {
        String fileName = "data.xml";

        try {
            List<Employee> employees = SaxParserEmployee.parse("data.xml");
            Type listType = new TypeToken<List<Employee>>() {
            }.getType();
            String stringJson = JsonParserEmployee.listToJson(employees, listType);
            FileUtil.writeString("XmlToJson.json", stringJson);
        } catch (SaxParserException e) {
            e.printStackTrace();
        } catch (FileUtilException e) {
            e.printStackTrace();
        }
    }

    public static void jsonToListEmployees(){
        String fileName = "XmlToJson.json";
        try {
            String json = FileUtil.readFile("XmlToJson.json");
            JsonParserEmployee.jsonToList(json)
                    .forEach(System.out::println);
        } catch (FileUtilException e) {
            e.printStackTrace();
        }

    }
}
