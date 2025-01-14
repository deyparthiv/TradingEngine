package org.parthiv.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * specify an interface for the server taking order requests
 */
public class OrderService implements IOrderService {
    final ExecutorService executor;
    boolean isRunning;
    final ServerSocket serverSocket;

    public OrderService() throws IOException {
        executor = Executors.newCachedThreadPool();
        isRunning = true;
        serverSocket = new ServerSocket(1234);
    }

    /**
     * Listen for clients
     */
    @Override
    public void run() {
        while (isRunning) {
            try {
                new Thread(new OrderServerClientHandler(serverSocket.accept())).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void submitRequest(IOrderRequest request) {
        executor.submit(() ->
                request.getOrder().accept(request.getAction())
        );
    }
}
