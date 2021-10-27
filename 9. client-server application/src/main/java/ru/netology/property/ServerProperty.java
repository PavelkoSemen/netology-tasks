package ru.netology.property;

import ru.netology.myexception.PropertyNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ServerProperty {
    private final Properties property = new Properties();

    public ServerProperty(String pathProperty) throws PropertyNotFoundException {
        try {
            property.load(new FileReader(pathProperty));
        } catch (IOException e) {
            e.printStackTrace();
            throw new PropertyNotFoundException("Property file does not exist");
        }
    }

    public ServerProperty() throws PropertyNotFoundException {
        this("9. client-server application/src/main/resources/config.properties");
    }

    public int getServerPort(){
        return Integer.parseInt(property.getProperty("server.port"));
    }
    public String getServerId(){
        return property.getProperty("server.id");
    }
}
