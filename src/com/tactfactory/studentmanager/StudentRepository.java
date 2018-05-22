
package com.tactfactory.studentmanager;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepository implements EntityRepository<Student> {
    private static final List<Student> students = new LinkedList<>();
    private static int size = 0;

    @Override
    public int count() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return students.isEmpty();
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean delete(int id) {
        List<Student> found = students.stream()
            .filter(student -> student.getId() == id)
            .collect(Collectors.toList());

        if (found.size() > 1) {
            throw new RuntimeException("Non unique primary key: " + id);
        } else if (found.size() == 1) {
            students.remove(found.get(0));
            return true;
        }

        return false;
    }

    @Override
    public Student find(int id) {
        Student result = null;
        Student elt;
        Iterator<Student> it = students.iterator();

        while (it.hasNext() && result == null)
            if ((elt = it.next()).getId() == id) result = elt;

        return result;
    }

    @Override
    public void update(Student student) {
    }

    @Override
    public int create(Student student) {
        if (student.getId() != null) throw new RuntimeException("Fuck!!!");

        int id = ++ size;

        student.setId(id);
        students.add(student);

        return id;
    }
}
