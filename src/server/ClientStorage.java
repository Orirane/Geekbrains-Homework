package server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import server.model.Client;

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
}
