package com.tactfactory.poei.hangman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String mistery = "mystere";
        Scanner scan = new Scanner(System.in);
        String line;

        System.out.println("Essai de trouver le mot mistère, il est introuvable : ");

        /*
        do {
            line = scan.nextLine().trim();
        } while ("".equals(line));
        // OR
        */
        while ("".equals((line = scan.nextLine().trim())));

        System.out.println(line + (mistery.equals(line) ? " => bravo" : " n'est pas le mot \"mystère\""));
    }
}
