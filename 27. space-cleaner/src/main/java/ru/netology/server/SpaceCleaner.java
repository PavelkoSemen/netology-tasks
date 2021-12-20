package ru.netology.server;

import lombok.extern.slf4j.Slf4j;
import ru.netology.myexception.PropertyNotFoundException;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

@Slf4j
public class SpaceCleaner extends Thread {
    private final static int BUFFER_LENGTH = 2 << 4;


    @Override
    public void run() {
        log.info("Server started");
        try {
            ServerProperty serverProperty = ServerProperty.getInstance();
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress(serverProperty.getServerId(), serverProperty.getServerPort()));
            try (SocketChannel socketChannel = serverChannel.accept()) {
                final ByteBuffer byteBuffer = ByteBuffer.allocate(BUFFER_LENGTH);

                while (socketChannel.isConnected()) {
                    int bytesCount = socketChannel.read(byteBuffer);
                    log.info("Server read {} byte", bytesCount);
                    if (bytesCount == -1) break;

                    final String text = new String(byteBuffer.array(), 0, bytesCount, StandardCharsets.UTF_8);
                    byteBuffer.clear();
                    final String textWithoutSpace = text.replace(" ", "");

                    socketChannel.write(ByteBuffer.wrap(textWithoutSpace.getBytes(StandardCharsets.UTF_8)));

                }
            }

        } catch (PropertyNotFoundException e) {
            log.error("Property file not found", e);
        } catch (IOException e) {
            log.error("Can't open socket channel", e);
        }
        log.info("Server finished");
    }
}
