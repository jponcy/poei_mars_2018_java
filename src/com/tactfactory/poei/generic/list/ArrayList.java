package com.tactfactory.poei.generic.list;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {

    private static final int POOL_SIZE = 50;

    /** The store of <T> items. */
    private Object[] items = new Object[0];
    /** The number of added element. */
    private int counter = 0;

    /* (non-Javadoc)
     * @see com.tactfactory.poei.generic.list.List#add(java.lang.Object)
     */
    @Override
    public void add(T item) {
        // Prepare place if necessary.
        if (this.counter == this.items.length) { // If has no more place.
            this.items = Arrays.copyOf(this.items, this.counter + POOL_SIZE);
        }

        // Add element.
        this.items[this.counter ++] = item;
    }

    /* (non-Javadoc)
     * @see com.tactfactory.poei.generic.list.List#remove(java.lang.Object)
     */
    @Override
    public void remove(T item) {
        int index = this.find(item);

        if (index >= 0) this.items[index] = null;
    }

    /* (non-Javadoc)
     * @see com.tactfactory.poei.generic.list.List#get(int)
     */
    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index < 0 || index >= this.counter)
            throw new RuntimeException("Nop, ya pa de e den nope");

        return (T) this.items[index];
    }

    /**
     * Search element index.
     * @param item
     * @return The index of element. -1 if not found.
     */
    private int find(T item) {
        int result = -1;

        for (int i = 0; i < this.counter && result < 0; ++ i) {
            if (this.items[i].equals(item)) {
                result = i;
            }
        }

        return result;
    }
}
