
package com.tactfactory.studentmanager;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new LinkedList<>();

    public static void main(String[] args) {
        while (true) {
            if (students.isEmpty()) {
                System.out.println("Pas encore d'étudiants");
            } else {
                Iterator<Student> it = students.iterator();
                short counter = 0;

                while (it.hasNext())
                    System.out.println("" + (++ counter) + " - " + it.next());
            }

            System.out.println("\nQue voulez vous faire ?"
                    + "\n\t1) Ajouter un étudiants"
                    + "\n\t2) Modifier un étudiant"
                    + "\n\t3) Supprimer un étudiant"
                    + "\n\t0) Quitter");

            switch (read()) {
                case "0":
                    scanner.close();
                    System.out.println("Merci et à  bientôt !");
                    System.exit(0);
                    break;
                case "1":
                    addStudent();
                    break;
                case "2":
                    updateStudent();
                    break;
                case "3":
                    removeStudent();
                    break;
                default:
                    System.out.println("Quoi ?????");
                    break;
            }
        }
    }

    /**
     * Call remove when we don't has students => infinite loop.
     */
    private static void removeStudent() {
        int id = getStudentByIndex();

        students.remove(id);
    }

    private static void updateStudent() {
        int index = getStudentByIndex();
        System.out.println("Modifions " + students.get(index));
        students.set(index, fillStudent());
    }

    private static void addStudent() {
        Student student = fillStudent();
        students.add(student);
    }

    private static Student fillStudent() {
        String firstname;
        String lastname;

        System.out.println("Nom ?");
        String name = read();

        String[] split = name.split(" ");

        if (split.length == 2) {
            lastname = split[0];
            firstname = split[1];
        } else {
            lastname = name;

            System.out.println("Prénom ?");
            firstname = read();
        }

        return new Student(lastname, firstname);
    }

    private static String read() {
        String result;
        while ("".equals((result = scanner.nextLine().trim())));

        return result;
    }

    private static int getStudentByIndex() {
        System.out.println("Quel étudiants (numéro) ?");
        String givenId;
        int id;

        givenId = read();
        while (!givenId.matches("^\\d+$") || (id = Integer.parseInt(givenId)) <= 0 || id > students.size()) {
            System.out.println("Merci de saisir un nombre compris entre " + 1 + " et " + students.size());
            givenId = read();
        }
        return id;
    }
}
