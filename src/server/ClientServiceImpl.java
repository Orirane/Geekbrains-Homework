package server;

import java.io.IOException;

import server.model.Client;

public class ClientServiceImpl implements ClientService {
    private final Client client;
    private final MessageService messageService;
    private final ClientStorage clientStorage;

    public ClientServiceImpl(Client client, MessageService messageService, ClientStorage clientStorage) {
        this.client = client;
        this.messageService = messageService;
        this.clientStorage = clientStorage;
    }

    @Override
    public void processMessage() {
        try {
            while (true) {
                String message = client.getIs().readUTF();
                System.out.println(String.format("received message '%s' to '%s'", message, client));
                String[] msgArray =  message.split(" ");
                if (!msgArray[0].equals("/w") || msgArray.length <=1){
                messageService.sendMessages(client.getLogin() + "::" + message);
                }else {
                    Client whisperTarget = clientStorage.getClient(msgArray[1]);
                    Client whisperOrigin = clientStorage.getClient(msgArray[msgArray.length-1]);
                    if(whisperTarget == null){
                        messageService.sendWhisperClientDoesNotExist(message,whisperOrigin);
                        return;
                    }
                    message.replace("/w", "");
                    message.replace(msgArray[2], "");
                    messageService.sendWhisper(message.substring(0, message.lastIndexOf(" ")), whisperTarget, whisperOrigin);
                }
            }
            } catch (IOException io) {
            messageService.sendMessages("SYSTEM::" + client.getLogin() + " has left the chat.");
            clientStorage.removeClient(client);
            io.printStackTrace();
        }
    }
}
