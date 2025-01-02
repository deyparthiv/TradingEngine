package org.parthiv.servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Takes in messages from a client
 */
public class OrderServerClientHandler implements Runnable {
    private final Socket client;
    private final BufferedReader in;
    private final PrintWriter out;

    public OrderServerClientHandler(Socket client) throws IOException {
        this.client = client;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream());
    }

    /**
     * Listen for messages from the connected client
     */
    @Override
    public void run() {
        String message = "";
        while(!message.equals("disconnect")){
            try {
                message = in.readLine();
                System.out.println("Received: " + message);
                out.println("Received: " + message);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
