package com.tactfactory.poei.two_dog;

import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        String[] names = new String[]{"Michel", "Boris", "Bertrand", "Zeus"};
        String[] breeds = {"Caniche", "Boxer"};
        final int size = names.length * breeds.length;
        Dog[] dogs = new Dog[size];
        String dateFormat = "dd/MM/yyyy";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);

        for (int i = 0; i < names.length; ++ i) {
            for (int j = 0; j < breeds.length; ++ j) {
                dogs[i + j * names.length] = new Dog(names[i], breeds[j]);
            }
        }

        for (Dog d : dogs)
            System.out.println(
                    d.getName() +
                    " est un " + d.getBreed() + ". Il et nez le : " +
                    d.getBirthdate().format(dateFormatter));


















//        String[][] dogs = new String[][]{
//            {"boxer", "Bruce", "Michel", "Henri"},
//            {"Lévrier", "buRger"}
//        };
//
//        for (byte line = 0; line < dogs.length; ++ line) {
//            String[] lineData = dogs[line];
//            String breed = lineData[0];
//
//            for (byte col = 1; col < lineData.length; ++ col) {
//                String name = lineData[col];
//
//                System.out.println(name + " est un " + breed);
//            }
//        }
    }
}
