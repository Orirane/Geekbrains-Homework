package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import server.model.Client;

public class ChatServer {
    private static ClientStorage clientStorage = new ClientStorage();
    private static MessageService messageService = new MessageService(clientStorage);

    public static void main(String[] args) throws IOException {

        try (ServerSocket ss = new ServerSocket(8080)) {
            System.out.println("server started");
            while (true) {
                Socket socket = ss.accept();
                DataInputStream is = new DataInputStream(socket.getInputStream());
                DataOutputStream os = new DataOutputStream(socket.getOutputStream());

                Client client = new Client(is.readUTF(), is, os);
                System.out.println("client connected::" + client + "::" + socket);
                messageService.sendMessages("SYSTEM:: "+client.toString().substring(client.toString().indexOf("'")+1, client.toString().length()-2)+" has joined the chat.");
                clientStorage.addClient(client);
                new Thread(() -> new ClientServiceImpl(client, messageService, clientStorage)
                        .processMessage()).start();
            }
        }
    }
}
