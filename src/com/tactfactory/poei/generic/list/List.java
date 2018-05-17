
package com.tactfactory.poei.generic.list;

/**
 * Provides API to used POEI -- super mega -- lists.
 *
 * @param <T> The generic type of element to store.
 */
public interface List<T> {

    /**
     * Adds the given item to store.
     * @param item
     */
    void add(T item);

    /**
     * Removes from store the first item equals to given.
     * @param item
     */
    void remove(T item);

    /**
     * Returns the n°<index> item from the store (no remove -- !pop).
     * @param index
     * @return The found element.
     */
    T get(int index);
}
