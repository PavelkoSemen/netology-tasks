package ru.netology.server;

import lombok.extern.slf4j.Slf4j;
import ru.netology.myexception.PropertyNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server extends Thread {


    @Override
    public void run() {
        try {
            ServerProperty serverProperty = ServerProperty.getInstance();
            ServerSocket serverSocket = new ServerSocket(serverProperty.getServerPort());
            log.info("Server started");
            try (Socket socket = serverSocket.accept();
                 PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String answer;
                while ((answer = br.readLine()) != null) {
                    if (answer.equals("END")) break;
                    pw.println(returnFibonacciNumbers(Integer.parseInt(answer)));
                }

            } catch (IOException e) {
                log.error("Stream read error", e);
            }
        } catch (PropertyNotFoundException e) {
            log.error("Property file not found", e);
        } catch (IOException e) {
            log.error("Server creation error", e);
        }
        log.info("Server finished");
    }

    public int returnFibonacciNumbers(int number) {
        log.info("Method returnFibonacciNumbers called with param {}", number);
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return returnFibonacciNumbers(number - 1) + returnFibonacciNumbers(number - 2);
    }
}
