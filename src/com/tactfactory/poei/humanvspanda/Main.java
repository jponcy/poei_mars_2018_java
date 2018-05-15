package com.tactfactory.poei.humanvspanda;

import java.util.LinkedList;
import java.util.List;

public class Main {

    /** Program entry point. */
    public static void main(String[] args) {
        List<Client> clients = new LinkedList<>();

        // Initialize client data.
        String[][] names = new String[][]{
            // 0        1
            {"400",     "Bad request"   }, // 0
            {"404",     "not-found"     }, // 1
            {"request", "bad"           }, // 2
            {"worst",   "human-ever"    }, // 3
            {"Fromage", null            }  // 4
        };

        // Add clients.
        for (int i = 0; i < names.length; ++i) {
            String[] n = names[i];
            Client newClient;

            if (n[1] == null) { // Panda.
                newClient = new Panda();
                ((Panda) newClient).setName(n[0]);
            } else { // Human.
                String lastname = n[0];
                String firstname = n[1];

                if (firstname.toLowerCase().contains("bad")) {
                    newClient = new Bad(lastname, firstname);
                } else { // Worst is worse than bad.
                    Worst w = new Worst();
                    w.setFirstname(firstname);
                    w.setLastname(lastname);
                    newClient = w;
                }
            }

            clients.add(newClient);
        }

        // Print names.
        for (Client client : clients) {
            System.out.println(client.getName());
        }
    }
}
