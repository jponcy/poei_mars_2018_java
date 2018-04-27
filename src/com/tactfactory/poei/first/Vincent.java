package com.tactfactory.poei.first;
import java.util.Scanner;

enum Color {
    RED, BLUE, SUPER_GREEEEEN
}

@SuppressWarnings("all")
public class Vincent {

    public static void main(String ...args) {
        /*
        MyFirstClass object = new MyFirstClass(42);

        System.out.println(MyFirstClass.PI);
        object.coucou();
        object.dawa();

        MyFirstClass.PI = 1;

        System.out.println(MyFirstClass.PI);

        System.out.println("--------");

        object.nameConflicts(3);
        */

        new MyFirstClass().testVar();
    }

    private static void array2() {
        int[] tab = new int[5];
        tab[2] = 0x2;

        int[] temp = new int[tab.length + 50];
        for (int i = 0; i < tab.length; ++ i) {
            temp[i] = tab[i];
        }

        tab = temp;

        System.out.println(tab.length);
        System.out.println(0_0);
        System.out.println(tab[2]);
        System.out.println(temp[2]);
        System.out.println(tab[0]);
        System.out.println(temp[0]);
    }

    public boolean equalsIgnoreCase(String str1, String str2) {
        return str1.toLowerCase().equals(str2.toLowerCase());
    }

    private static void array1() {
        int[] is = new int[20];
        System.out.println(is[19]);
        byte sum = 0;

        is[19] = 012;

        for (int i : is) {
            sum += i;
        }

        System.out.println("Sum is: " + (sum == 0 ? "seum" : sum));
    }

    private static void SUPER_SWITCH() {
        int i = 3;
        Color color = Color.SUPER_GREEEEEN;

        System.out.println(Color.BLUE);

        switch (color) {
        case BLUE:
            System.out.println("I'm blue, dabo...");
            break;
        case RED:
            System.out.println("I love diablo");
            break;

        default:
            System.out.println("Super greeeeen!!!!!!!!!");
            break;
        }

        switch ("toto") {
        case "toto":
            System.out.println("Super");
            break;

        default:
            System.out.println("Dommage");
            break;
        }

        switch (i) {
        case 3:
            System.out.println(3);
            // No break isn't mistake (case 3 then 2).
        case 2:
            System.out.println(2);
            break;
        case 1:
            System.out.println("Hum ...");
            break;

        default:
            System.out.println("Cas non prit, avec un s, en compte");
            break;
        }
    }

    private static void loopExamples() {
        int square = 0;
        int i = 0;

        for (;
                i < 5 && square >= 0;
                ++ i, square = i * i)
            System.out.println(i + " - " + square);

        for (int y = 0; y >= i; ++ y) {
            System.out.println("Scofield");
        }

        for (int v : new int[]{1, 2, 3, 4, 5}) {
            System.out.println(v);
        }
    }

    private static void worsteExamples() {
        Scanner scanner = new Scanner(System.in);
        int i;

        while (!scanner.hasNextInt() && scanner.nextLine() == null);
        i = scanner.nextInt();

        System.out.println(i);

        boolean b = toto();

        while (alwaysFalse(b))
            System.out.println("While");

        do
            System.out.println("DO");
        while (alwaysFalse(b));

//        if (args.length > 0) {
//            name = " " + args[0];
//        }
//        System.out.println("cde\0dez");;
//
//        System.out.println("Salut" + name);
//
//        int i = 0;
//
//        for (i = 0; i < args.length; ++ i) {
//            System.out.println(args[i]);
//        }
    }

    private static boolean alwaysFalse(boolean b) {
        return b  != toto();
    }

    private static boolean toto() {
        return false;
    }
}
