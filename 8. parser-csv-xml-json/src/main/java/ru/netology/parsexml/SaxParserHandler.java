package ru.netology.parsexml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.netology.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class SaxParserHandler extends DefaultHandler {
    private final String TAG_EMPLOYEE = "employee";
    private final String TAG_ID = "id";
    private final String TAG_FIRST_NAME = "firstName";
    private final String TAG_LAST_NAME = "lastName";
    private final String TAG_COUNTRY = "country";
    private final String TAG_AGE = "age";

    private String currentTagName;
    private List<Employee> employees = new ArrayList<>();
    private Employee tmpEmployee;
    private boolean isEmployee = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;
        if (qName != null && qName.equals(TAG_EMPLOYEE)) {
            isEmployee = true;
            tmpEmployee = new Employee();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName != null && qName.equals(TAG_EMPLOYEE)) {
            employees.add(tmpEmployee);
            tmpEmployee = null;
            isEmployee = false;
        }
        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentTagName == null) {
            return;
        }
        if (isEmployee) {
            fillingEmployee(new String(ch, start, length));
        }
    }

    private void fillingEmployee(String parameter) {
        switch (currentTagName) {
            case TAG_ID -> tmpEmployee.setId(Long.parseLong(parameter));
            case TAG_FIRST_NAME -> tmpEmployee.setFirstName(parameter);
            case TAG_LAST_NAME -> tmpEmployee.setLastName(parameter);
            case TAG_COUNTRY -> tmpEmployee.setCountry(parameter);
            case TAG_AGE -> tmpEmployee.setAge(Integer.parseInt(parameter));
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
