package ru.netology.parsejson;

import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import ru.netology.entity.Employee;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsonParserEmployee {
    private final static GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
    private final static Gson gson = gsonBuilder.create();


    public static String listToJson(List<Employee> employees, Type listType) {
        return gson.toJson(employees, listType);
    }


    public static List<Employee> jsonToList(String json) {
        log.info("Start parsing string to json");
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = (JsonArray) jsonParser.parse(json);

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jo = (JsonObject) jsonArray.get(i);
            employees.add(gson.fromJson(jo, Employee.class));
        }
        log.info("Finish parsing string to json");
        return employees;
    }
}
