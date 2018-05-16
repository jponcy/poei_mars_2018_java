package com.tactfactory.poei.hangman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static final String FILENAME = "resources/dico.txt";

    private static Pattern pattern = Pattern.compile("/\\s([a-z-]+)/");

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String line;
        int life = 5;
        boolean found = false;
        char[] state;
        List<String> allTries;

        // Read words.
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            while (br.ready()) words.add(br.readLine().trim());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Impossible to read dictionary!");
            return;
        }

        // Select the mystery word.
        String mystery = words.get(new Random().nextInt(words.size())); //words[new Random().nextInt(words.length)];

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

        do {
            System.out.println("");
            System.out.println("Déjà trouvé : " + String.valueOf(state));
            System.out.println("Essais précédents : " + String.join(", ", allTries));
            // Print "question".
            System.out.println("Il vous reste " + life + " vie" + (life == 1 ? "" : "s") + " : ");

            // Wait correct try.
            while ("".equals((line = scan.nextLine().trim())));

            // Process commands.
            if (line.startsWith("/")) {
                if (line.startsWith("/add")) {
                    try (BufferedWriter writter = new BufferedWriter(new FileWriter(FILENAME, true))) {
                        String[] newWords = line.split(" ");

                        for (int i = 1; i < newWords.length; ++i) {
                            String word = newWords[i];

                            if (!words.contains(word)) {
                                writter.write(word);
                                writter.newLine();
                                words.add(word);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.err.println("Impossible to write the word into dictionary!");
                    }
                } else if (line.startsWith("/solution")) {
                    System.out.println("Léger indice, le mot est : " + mystery);
                } else {
                    System.err.println("Commande inexistante. Vous êtes stupide !");
                }

                continue;
            }

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
