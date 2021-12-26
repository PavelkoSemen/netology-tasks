package ru.netology.client;

import lombok.extern.slf4j.Slf4j;
import ru.netology.myexception.PropertyNotFoundException;
import ru.netology.server.ServerProperty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Slf4j
public class Client extends Thread {
    private final static int BUFFER_LENGTH = 2 << 4;

    @Override
    public void run() {
        log.info("Client started");
        try {
            ServerProperty serverProperty = ServerProperty.getInstance();
            InetSocketAddress socketAddress = new InetSocketAddress(serverProperty.getServerId()
                    , serverProperty.getServerPort());
            SocketChannel socketChannel = SocketChannel.open();
            try (socketChannel; Scanner scanner = new Scanner(System.in)) {
                socketChannel.connect(socketAddress);
                final ByteBuffer byteBuffer = ByteBuffer.allocate(BUFFER_LENGTH);
                String text;
                while (true) {
                    System.out.println("Enter message for server...");
                    text = scanner.nextLine();
                    System.out.println("Что-то введено " + text);
                    if (text.equals("END")) break;

                    socketChannel.write(ByteBuffer.wrap(text.getBytes(StandardCharsets.UTF_8)));

                    int bytesCount;
                    while ((bytesCount = socketChannel.read(byteBuffer)) > 0){
                        System.out.print(new String(byteBuffer.array(), 0, bytesCount, StandardCharsets.UTF_8));
                        byteBuffer.clear();
                    }
                }
            }

        } catch (PropertyNotFoundException e) {
            log.error("Property file not found", e);
        } catch (IOException e) {
            log.error("Can't open socket channel", e);
        }
        log.info("Client finished");
    }
}
