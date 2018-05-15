package com.tactfactory.poei.hangman;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] words = new String[] {"mistere", "introuvable", "securise", "fort", "toto", "viagra", "amidon"};
        Scanner scan = new Scanner(System.in);
        String line;

        // Select the mystery word.
        String mystery = words[new Random().nextInt(words.length)];

        System.out.println("Essai de trouver le mot mistère, il est introuvable : ");
        System.out.println("Indice : " + mystery);

        /*
        do {
            line = scan.nextLine().trim();
        } while ("".equals(line));
        // OR
        */
        while ("".equals((line = scan.nextLine().trim())));

        System.out.println(line + (mystery.equals(line) ? " => bravo" : " n'est pas le mot \"mystère\", "
                + "il fallait trouver \"" + mystery + "\""));
    }
}
