package com.tactfactory.poei.humanvspanda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /** Program entry point. */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        // Initialize.
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; ++ i) {
            list.add(i);
        }

        demo(list);
    }

    private static void demo(List<Integer> list) {
        list
            .stream()
            .filter(e -> e % 2 == 0 && e > 0)
            .map(item -> item * item)
            .forEach(System.out::println);
    }
}
