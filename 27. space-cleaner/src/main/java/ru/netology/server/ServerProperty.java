package ru.netology.server;

import ru.netology.myexception.PropertyNotFoundException;

import java.io.IOException;
import java.util.Properties;

public class ServerProperty {
    private static final String PROPERTIES_NAME = "/config.properties";
    private static final Properties property = new Properties();
    private static ServerProperty instance;
    private static final Object lock = new Object();

    private ServerProperty() throws PropertyNotFoundException {
        try {
            property.load(ServerProperty.class.getResourceAsStream(PROPERTIES_NAME));
        } catch (IOException e) {
            throw new PropertyNotFoundException(e);
        }
    }

    public static ServerProperty getInstance() throws PropertyNotFoundException {
        if (instance != null) {
            return instance;
        }
        synchronized (lock) {
            if (instance == null) {
                instance = new ServerProperty();
            }
        }
        return instance;
    }


    public int getServerPort() {
        return Integer.parseInt(property.getProperty("server.port"));
    }

    public String getServerId() {
        return property.getProperty("server.id");
    }
}