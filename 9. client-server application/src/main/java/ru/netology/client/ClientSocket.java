package ru.netology.client;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import ru.netology.myexception.PropertyNotFoundException;
import ru.netology.property.ServerProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@Slf4j
public class ClientSocket extends Thread {
    PrintWriter pw;
    BufferedReader br;
    Socket client;

    @Override
    public void run() {
        try {
            log.info("Start client");
            ServerProperty property = new ServerProperty();
            client = new Socket(property.getServerId(), property.getServerPort());
            pw = new PrintWriter(client.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String name = "Ivan";
            pw.println(name);
            String answer = br.readLine();
            System.out.println(answer);


            pw.close();
            br.close();
            client.close();
            log.info("Client closed");
        } catch (IOException e) {
            log.error("IO error", e);
        } catch (PropertyNotFoundException e) {
            log.error("Properties file is missing");
        }

    }

}
