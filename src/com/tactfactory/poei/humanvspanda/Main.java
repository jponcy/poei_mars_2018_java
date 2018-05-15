package com.tactfactory.poei.humanvspanda;

import java.util.Arrays;
import java.util.List;

public class Main {

    /** Program entry point. */
    public static void main(String[] args) {
        // Print names.
        List<Client> clients = Arrays.asList(
                new Bad(    "400",      "Bad request"),
                new Worst(  "404",      "not-found"),
                new Bad(    "request",  "bad"),
                new Worst(  "worst",    "human-ever"),
                new Panda(  "Fromage"));

        for (Client client : clients) {
            System.out.println(client.getName());
        }
    }
}
