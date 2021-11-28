package ru.netology.server;

import lombok.extern.slf4j.Slf4j;
import ru.netology.myexception.PropertyNotFoundException;
import ru.netology.property.ServerProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server extends Thread {
    private ServerSocket server;
    private PrintWriter pw;
    private BufferedReader br;

    @Override
    public void run() {

        try {
            ServerProperty property = new ServerProperty();
            server = new ServerSocket(property.getServerPort());
            log.info("Server started");
            Socket clientSocket = server.accept();
            log.info("New connection accepted. Port : {}", clientSocket.getPort());

            pw = new PrintWriter(clientSocket.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String name = br.readLine();
            System.out.println("name: " + name);
            pw.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));


            pw.close();
            br.close();
            clientSocket.close();
            server.close();
            log.info("Server closed");
        } catch (IOException e) {
            log.error("IO error", e);
        } catch (PropertyNotFoundException e) {
            log.error("Properties file is missing");
        }

    }

}
