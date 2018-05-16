package com.tactfactory.poei.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] words = new String[] {"mistere", "introuvable", "securise", "fort", "toto", "viagra", "amidon"};
        Scanner scan = new Scanner(System.in);
        String line;
        int life = 5;
        boolean found = false;
        char[] state;
        List<String> allTries;

        // Select the mystery word.
        String mystery = words[new Random().nextInt(words.length)];

        // Initialize list of tries.
        allTries = new ArrayList<>(mystery.length() + 4);

        // Initialize array state --- word with same size than mystery but with _ instead of letters.
        Arrays.fill(state = new char[mystery.length()], '_');

        // Initialize state --- word with same size than mystery but with _ instead of letters.
        /*
         * To create state as string.
         * for (int i = 0; i < mystery.length(); ++ i) state += "_"; // Need initialize
         *
         * // OR.
         *
         * state = Arrays.asList(mystery.split("")).stream().map(e -> "_").collect(Collectors.joining(""));
         *
         * // OR.
         *
         * state = IntStream.range(0, mystery.length()).mapToObj(i -> "_").collect(Collectors.joining(""));
         *
         * // OR.
         *
         * StringBuilder sBuilder = new StringBuilder(mystery.length());
         * for (int i = 0; i < mystery.length(); ++ i) sBuilder.append('_');
         * state = sBuilder.toString();
         */

        System.out.println("Essai de trouver le mot mistère, il est introuvable.");
        System.out.println("Indice : " + mystery);

        do {
            System.out.println("");
            System.out.println("Déjà trouvé : " + String.valueOf(state));
            System.out.println("Essais précédents : " + String.join(", ", allTries));
            // Print "question".
            System.out.println("Il vous reste " + life + " vie" + (life == 1 ? "" : "s") + " : ");

            // Wait correct try.
            while ("".equals((line = scan.nextLine().trim())));

            if (allTries.contains(line)) continue;

            allTries.add(line);

            if (line.length() == 1) { // If try letter.
                char inputLetter = line.charAt(0); // The only one letter.
                boolean letterFound = false;

                for (byte i = 0; i < mystery.length(); ++ i) {
                    char letter = mystery.charAt(i);

                    if (letter == inputLetter) {
                        state[i] = letter;
                        letterFound = true;
                    }
                }

                if (letterFound /* possibility to to following code instead of body : && !String.valueOf(state).contains("_")*/) {
                    for (int i = 0; i < state.length; ++ i) {
                        if (state[i] == '_') break;
                        else if (i == state.length - 1) {
                            System.out.println(mystery);
                            found = true;
                        }
                    }
                } else -- life;
            } else { // Try word.
                if (!(found = line.equals(mystery))) {
                    -- life;
                }
            }
        } while (!found && life > 0);

        scan.close();

        System.out.println("");
        System.out.println(found ? "Bravo !" : "... Le mot correct était \"" + mystery + "\" !");
    }
}
