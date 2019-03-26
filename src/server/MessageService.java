package server;

import server.model.Client;

import java.io.IOException;

public class MessageService {
    private final ClientStorage clientStorage;

    public MessageService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }

    public synchronized void sendMessages(String message) {
        clientStorage.getClients().forEach(client -> {
            try {
                System.out.println(String.format("sending message '%s' to '%s'", message, client));
                client.getOs().writeUTF(message + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
    public synchronized void sendWhisper(String message, Client toClient, Client fromClient){
        try {
            System.out.println(String.format("sending message '%s' to '%s'", message, toClient));
            toClient.getOs().writeUTF(fromClient.getLogin()+" whispers to you::"+message + "\n");
            fromClient.getOs().writeUTF("you whispered to"+toClient.getLogin()+"::"+message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public synchronized void sendWhisperClientDoesNotExist(String message,Client fromClient){
        try {
            System.out.println(String.format("sending message '%s' to '%s'", message, fromClient));
            fromClient.getOs().writeUTF("SYSTEM:: Specified client does not exist.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
