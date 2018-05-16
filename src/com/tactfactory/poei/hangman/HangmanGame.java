package com.tactfactory.poei.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HangmanGame {

    private int life = 5;
    private String mystery;
    private char[] state;

    /** All letter and word tried by user. */
    private List<String> allTries;
    private Dictionary dico = new Dictionary();

    /** Constructor. */
    public HangmanGame() {
        this.mystery = this.dico.getRandomWord();

        // Initialize list of tries.
        this.allTries = new ArrayList<>(mystery.length() + 4);

        this.initState();
    }

    public void process() {
        Scanner scan = new Scanner(System.in);
        String line;
        boolean found = false;

        System.out.println("Essai de trouver le mot mistère, il est introuvable.");

        do {
            announceTurn();

            line = getUserTry(scan);

            // Process commands.
            if (!(processCommands(line) && allTries.contains(line))) {
                allTries.add(line);

                found = processInput(line, found);
            }
        } while (!found && life > 0);

        scan.close();

        System.out.println("");
        System.out.println(found ? "Bravo !" : "... Le mot correct était \"" + mystery + "\" !");
    }

    private boolean processInput(String line, boolean found) {
        if (line.length() == 1) { // If try letter.
            found = processLetter(line, found);
        } else { // Try word.
            found = processWord(line);
        }
        return found;
    }

    private boolean processWord(String line) {
        boolean found;
        if (!(found = line.equals(mystery))) {
            -- life;
        }
        return found;
    }

    private boolean processLetter(String line, boolean found) {
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
        return found;
    }

    /**
     * Process commands.
     * @param line
     * @return Tells if was a CMD. True if it is, false otherwise.
     */
    private boolean processCommands(String line) {
        boolean result = false;

        if ((result = line.startsWith("/"))) {
            if (line.startsWith("/add")) {
                this.dico.addWords(line.split(" "));
            } else if (line.startsWith("/solution")) {
                System.out.println("Léger indice, le mot est : " + mystery);
            } else {
                System.err.println("Commande inexistante. Vous êtes stupide !");
            }
        }

        return result;
    }

    private String getUserTry(Scanner scan) {
        String line;
        // Wait correct try.
        while ("".equals((line = scan.nextLine().trim())));
        return line;
    }

    private void announceTurn() {
        System.out.println("");
        System.out.println("Déjà trouvé : " + String.valueOf(state));
        System.out.println("Essais précédents : " + String.join(", ", allTries));
        // Print "question".
        System.out.println("Il vous reste " + life + " vie" + (life == 1 ? "" : "s") + " : ");
    }

    private void initState() {
        // Initialize array state --- word with same size than mystery but with _ instead of letters.
        Arrays.fill(state = new char[this.mystery.length()], '_');
    }
}
