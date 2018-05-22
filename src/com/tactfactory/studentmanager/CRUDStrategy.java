package com.tactfactory.studentmanager;

import java.util.HashMap;
import java.util.Map;

import com.tactfactory.studentmanager.io.IOConsole;
import com.tactfactory.studentmanager.io.IOStream;

public abstract class CRUDStrategy<T extends Entity> {

    private Map<Integer, Integer> ids;
    protected final IOStream io = new IOConsole();

    protected EntityRepository<T> repository;

    protected CRUDStrategy(EntityRepository<T> repo) {
        this.repository = repo;
    }

    public void process() {
        ids = new HashMap<>();

        if (this.repository.isEmpty()) {
            this.io.write("Pas encore d'étudiants");
        } else {
            int counter = 0;

            for (T entity : this.repository.findAll()) {
                this.io.write("" + (++ counter) + " - " + entity);
                ids.put(counter, entity.getId());
            }
        }

        this.io.write("\nQue voulez vous faire ?"
                + "\n\t1) Ajouter un étudiants"
                + "\n\t2) Modifier un étudiant"
                + "\n\t3) Supprimer un étudiant"
                + "\n\t0) Quitter");

        switch (this.io.read()) {
            case "0":
                return;
            case "1":
                addStudent();
                break;
            case "2":
                updateStudent();
                break;
            case "3":
                removeEntity();
                break;
            default:
                this.io.write("Quoi ?????");
                break;
        }
    }

    /**
     * Call remove when we don't has students => infinite loop.
     */
    private void removeEntity() {
        Integer index = this.getNumberByIndex();

        if (index != null) this.repository.delete(index);
    }

    private void updateStudent() {
        Integer index = getNumberByIndex();

        if (index != null) {
            T entity = this.repository.find(index);
            this.io.write("Modifions " + entity);
            this.repository.update(fillStudent(entity));
        }
    }

    private void addStudent() {
        T entity = fillStudent();
        this.repository.create(entity);
    }

    protected abstract T fillStudent();
    protected abstract T fillStudent(T student);

    /**
     * @return The `index -1` when index was fill by user.
     */
    private Integer getNumberByIndex() {
        this.io.write("Quel étudiants (numéro) ?");
        String givenIndex;
        int index;

        givenIndex = this.io.read();
        while (!givenIndex.matches("^\\d+$") ||
                (index = Integer.parseInt(givenIndex)) <= 0 || index > this.repository.count()) {
            this.io.write("Merci de saisir un nombre compris entre " + 1 + " et " + this.repository.count());
            givenIndex = this.io.read();
        }

        return ids.get(index);
    }
}
