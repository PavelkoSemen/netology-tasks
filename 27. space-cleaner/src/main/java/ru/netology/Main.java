package ru.netology;

import ru.netology.client.Client;
import ru.netology.server.SpaceCleaner;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        SpaceCleaner spaceCleaner = new SpaceCleaner();

        spaceCleaner.start();
        client.start();
    }
}
