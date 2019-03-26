package server;

import server.model.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientStorage {
    private static List<Client> clients = Collections.synchronizedList(new ArrayList<>());

    public void addClient(Client client) {
        System.out.println("client added::"+client);
        clients.add(client);
    }

    public void removeClient(Client client) {
        System.out.println("client removed::"+client);
        clients.remove(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client getClient(String clientLogin){
        for (Client client : clients) {
            if (client.getLogin().equals(clientLogin)){
                return client;
            }
        }
        return null;
    }
}
