package com.tactfactory.studentmanager.repository;

import java.util.HashMap;
import java.util.Map;

import com.tactfactory.studentmanager.EntityRepository;

public class EntityManager {

    private static Map<Class<?>, EntityRepository<?>> repositories = new HashMap<>();

    private EntityManager() {
    }

    public static EntityRepository<?> getRepository(Class<?> clazz) {
        if (!repositories.containsKey(clazz)) {
            try {
                repositories.put(clazz, (EntityRepository<?>) clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }

        return repositories.get(clazz);
    }
}
