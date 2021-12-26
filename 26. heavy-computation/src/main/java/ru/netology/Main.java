package ru.netology;

import ru.netology.client.ClientSocket;
import ru.netology.server.Server;

public class Main {
    public static void main(String[] args) {
        new Server().start();
        new ClientSocket().start();
    }
}
