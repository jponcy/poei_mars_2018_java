package com.tactfactory.poei.hangman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private static final String FILENAME = "resources/dico.txt";

    private List<String> words;

    public Dictionary() {
        this.words = read();
    }

    public String getRandomWord() {
        return words.get(new Random().nextInt(words.size()));
    }

    public void addWords(String[] newWords) {
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(FILENAME, true))) {
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
    }

    /** Read all words from dictionary file. */
    private List<String> read() {
        List<String> words = new ArrayList<>();
        // Read words.
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            while (br.ready()) words.add(br.readLine().trim());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Impossible to read dictionary!");
            System.exit(-1);
        }

        return words;
    }
}
