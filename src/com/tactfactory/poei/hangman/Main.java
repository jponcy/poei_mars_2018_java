package com.tactfactory.poei.hangman;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] words = new String[] {"mistere", "introuvable", "securise", "fort", "toto", "viagra", "amidon"};
        Scanner scan = new Scanner(System.in);
        String line;
        int life = 5;
        boolean found;

        // Select the mystery word.
        String mystery = words[new Random().nextInt(words.length)];

        System.out.println("Essai de trouver le mot mistère, il est introuvable.");
        System.out.println("Indice : " + mystery);

        /*
        do {
            line = scan.nextLine().trim();
        } while ("".equals(line));
        // OR
        */
        do {
            // Print "question".
            System.out.println("Il vous reste " + life + " vie" + (life == 1 ? "" : "s") + " : ");

            // Wait correct try.
            while ("".equals((line = scan.nextLine().trim())));

            if (!(found = line.equals(mystery))) {
                -- life;
            }
        } while (!found && life > 0);

        scan.close();

        System.out.println(found ? "Bravo !" : "... Le mot correct était \"" + mystery + "\" !");
    }
}
