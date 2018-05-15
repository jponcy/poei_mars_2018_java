package com.tactfactory.poei.humanvspanda;


public class Main {

    /** Program entry point. */
    public static void main(String[] args) {
        test(new Bad(), "400", "bad-request");
        test(new Bad(), "404", "not-found");
        test(new Bad(), "request", "bad");
        test(new Worst(), "worst", "human-ever");
        test(new Panda(), "Fromage", null);
    }

    private static void test(Client instance, String lastname, String firstname) {
        if (instance instanceof Human) {
            Human human = (Human) instance;

            human.setFirstname(firstname);
            human.setLastname(lastname);
        } else { // Panda.
            Panda panda = (Panda) instance;
            panda.setName(lastname);
        }

        System.out.println(instance.getName());
    }
}
