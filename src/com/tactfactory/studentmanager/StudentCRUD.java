
package com.tactfactory.studentmanager;

import com.tactfactory.studentmanager.repository.EntityManager;

public class StudentCRUD extends CRUDStrategy<Student> {

    @SuppressWarnings("unchecked")
    public StudentCRUD() {
        super((EntityRepository<Student>) EntityManager.getRepository(StudentRepository.class));
    }

    @Override
    protected Student fillStudent() {
        return fillStudent(new Student());
    }

    @Override
    protected Student fillStudent(Student student) {
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
}
