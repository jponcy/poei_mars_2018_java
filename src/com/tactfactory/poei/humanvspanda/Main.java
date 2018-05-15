package com.tactfactory.poei.humanvspanda;

import java.util.LinkedList;
import java.util.List;

public class Main {

    /** Program entry point. */
    public static void main(String[] args) {
        List<Client> clients = new LinkedList<>();

        // Add items.
        clients.add(new Bad(    "400",      "Bad request"));
        clients.add(new Worst(  "404",      "not-found"));
        clients.add(new Bad(    "request",  "bad"));
        clients.add(new Worst(  "worst",    "human-ever"));
        clients.add(new Panda(  "Fromage"));

        // Print names.
        for (Client client : clients) {
            System.out.println(client.getName());
        }
    }
}
