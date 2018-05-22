
package com.tactfactory.studentmanager;

import java.util.List;

public interface EntityRepository<T extends Entity> {
    int count();
    boolean isEmpty();
    List<T> findAll();
    boolean delete(int id);
    T find(int id);
    void update(T student);
    int create(T student);
}
