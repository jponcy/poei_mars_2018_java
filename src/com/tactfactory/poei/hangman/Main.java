package com.tactfactory.poei.hangman;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] words = new String[] {"mistere", "introuvable", "securise", "fort", "toto", "viagra", "amidon"};
        Scanner scan = new Scanner(System.in);
        String line;
        int run = 1;

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
            System.out.println("Votre essai n°" + (run ++));

            // Wait correct try.
            while ("".equals((line = scan.nextLine().trim())));
        } while (!line.equals(mystery));

        System.out.println("bravo");
    }
}
