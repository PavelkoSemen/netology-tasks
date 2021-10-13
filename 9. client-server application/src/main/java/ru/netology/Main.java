package ru.netology;

import ru.netology.client.ClientSocket;
import ru.netology.server.Server;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        server.start();
        ClientSocket clientSocket = new ClientSocket();
        clientSocket.start();
    }
}
