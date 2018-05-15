package com.tactfactory.poei.humanvspanda;

import java.util.Arrays;
import java.util.List;

public class Main {

    /** Program entry point. */
    public static void main(String[] args) {
        // Initialize.
        List<Client> clients = Arrays.asList(
                new Bad(    "400",      "Bad request"),
                new Worst(  "404",      "not-found"),
                new Bad(    "request",  "bad"),
                new Worst(  "worst",    "human-ever"),
                new Panda(  "Fromage"));

        // Print names.
        clients
            .stream()
            .map(e -> e.getName())
            .forEach(System.out::println);
    }
}
