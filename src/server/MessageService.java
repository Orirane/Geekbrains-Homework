package server;

import server.model.Client;

import java.io.IOException;

public class MessageService {
    private final ClientStorage clientStorage;
    private final ChatLogger logs = new ChatLogger();

    public MessageService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }

    public synchronized void sendMessages(String message) {
        clientStorage.getClients().forEach(client -> {
            try {
                System.out.println(String.format("sending message '%s' to '%s'", message, client));
                ChatLogger.writeToLogs(message);
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
    public synchronized void sendTheEntireChatHistoryWhatCouldGoWrong(Client toClient){
        System.out.println("Sending chat history to "+toClient.getLogin());
        try {
            for (String line: ChatLogger.getChatHistory()) {
                if (line != null){
                    toClient.getOs().writeUTF(line+"\n");
                }

            }

        } catch (IOException e) {

            e.printStackTrace();
            System.out.println("Failed to send chat history to" + toClient.getLogin());
        }
    }

}
