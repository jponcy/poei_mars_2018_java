
package com.tactfactory.studentmanager;

import java.util.HashMap;
import java.util.Map;

import com.tactfactory.studentmanager.io.IOConsole;
import com.tactfactory.studentmanager.io.IOStream;

public class Main {

    private final StudentRepository repo = new StudentRepository();
    private Map<Integer, Integer> ids;
    private IOStream io = new IOConsole();

    public static void main(String[] args) {
        new Main().process();
    }

    private void process() {
        while (true) {
            ids = new HashMap<>();

            if (repo.isEmpty()) {
                this.io.write("Pas encore d'étudiants");
            } else {
                int counter = 0;

                for (Student student : repo.findAll()) {
                    this.io.write("" + (++ counter) + " - " + student);
                    ids.put(counter, student.getId());
                }
            }

            this.io.write("\nQue voulez vous faire ?"
                    + "\n\t1) Ajouter un étudiants"
                    + "\n\t2) Modifier un étudiant"
                    + "\n\t3) Supprimer un étudiant"
                    + "\n\t0) Quitter");

            switch (this.io.read()) {
                case "0":
                    this.io.write("Merci et à  bientôt !");
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
                    this.io.write("Quoi ?????");
                    break;
            }
        }
    }

    /**
     * Call remove when we don't has students => infinite loop.
     */
    private void removeStudent() {
        Integer index = getNumberByIndex();

        if (index != null) repo.delete(index);
    }

    private void updateStudent() {
        Integer index = getNumberByIndex();

        if (index != null) {
            Student student = repo.find(index);
            this.io.write("Modifions " + student);
            repo.update(fillStudent(student));
        }
    }

    private void addStudent() {
        Student student = fillStudent();
        repo.create(student);
    }

    private Student fillStudent() {
        return fillStudent(new Student());
    }
    private Student fillStudent(Student student) {
        this.io.write("Nom ?");
        String name = this.io.read();

        String[] split = name.split(" ");

        if (split.length == 2) {
            student.setLastname(split[0]);
            student.setFirstname(split[1]);
        } else {
            student.setLastname(name);

            this.io.write("Prénom ?");
            student.setFirstname(this.io.read());
        }

        return student;
    }

    /**
     * @return The `index -1` when index was fill by user.
     */
    private Integer getNumberByIndex() {
        this.io.write("Quel étudiants (numéro) ?");
        String givenIndex;
        int index;

        givenIndex = this.io.read();
        while (!givenIndex.matches("^\\d+$") ||
                (index = Integer.parseInt(givenIndex)) <= 0 || index > repo.count()) {
            this.io.write("Merci de saisir un nombre compris entre " + 1 + " et " + repo.count());
            givenIndex = this.io.read();
        }

        return ids.get(index);
    }
}
