package ru.netology.client;

import lombok.extern.slf4j.Slf4j;
import ru.netology.myexception.PropertyNotFoundException;
import ru.netology.server.ServerProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

@Slf4j
public class ClientSocket extends Thread {


    @Override
    public void run() {
        try {
            log.info("Client started");
            ServerProperty serverProperty = ServerProperty.getInstance();
            try (Socket socket = new Socket(serverProperty.getServerId(), serverProperty.getServerPort());
                 PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 Scanner scanner = new Scanner(System.in)) {
                String question;
                while (true) {
                    System.out.println("Введите число:");
                    question = scanner.nextLine();
                    pw.println(question);
                    if (question.equals("END")) break;
                    System.out.printf("Числа фибоначчи под номер %s равно: %s\n", question, br.readLine());
                }

            } catch (IOException e) {
                log.error("Stream read error", e);
            }
        } catch (PropertyNotFoundException e) {
            log.error("Property file not found", e);
        }
        log.info("Client finished");
    }
}
