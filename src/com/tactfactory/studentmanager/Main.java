
package com.tactfactory.studentmanager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentRepository repo = new StudentRepository();
    private static Map<Integer, Integer> ids;

    public static void main(String[] args) {
        while (true) {
            ids = new HashMap<>();

            if (repo.isEmpty()) {
                System.out.println("Pas encore d'étudiants");
            } else {
                int counter = 0;

                for (Student student : repo.findAll()) {
                    System.out.println("" + (++ counter) + " - " + student);
                    ids.put(counter, student.getId());
                }
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
        Integer index = getNumberByIndex();

        if (index != null) repo.delete(index);
    }

    private static void updateStudent() {
        Integer index = getNumberByIndex();

        if (index != null) {
            Student student = repo.find(index);
            System.out.println("Modifions " + student);
            repo.update(fillStudent(student));
        }
    }

    private static void addStudent() {
        Student student = fillStudent();
        repo.create(student);
    }

    private static Student fillStudent() {
        return fillStudent(new Student());
    }
    private static Student fillStudent(Student student) {
        System.out.println("Nom ?");
        String name = read();

        String[] split = name.split(" ");

        if (split.length == 2) {
            student.setLastname(split[0]);
            student.setFirstname(split[1]);
        } else {
            student.setLastname(name);

            System.out.println("Prénom ?");
            student.setFirstname(read());
        }

        return student;
    }

    private static String read() {
        String result;
        while ("".equals((result = scanner.nextLine().trim())));

        return result;
    }

    /**
     * @return The `index -1` when index was fill by user.
     */
    private static Integer getNumberByIndex() {
        System.out.println("Quel étudiants (numéro) ?");
        String givenIndex;
        int index;

        givenIndex = read();
        while (!givenIndex.matches("^\\d+$") ||
                (index = Integer.parseInt(givenIndex)) <= 0 || index > repo.count()) {
            System.out.println("Merci de saisir un nombre compris entre " + 1 + " et " + repo.count());
            givenIndex = read();
        }

        return ids.get(index);
    }
}
