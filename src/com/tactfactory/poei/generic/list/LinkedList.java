
package com.tactfactory.poei.generic.list;

public class LinkedList<T> implements List<T> {

    private class Item {
        private T value;
        private Item next = null;

        private Item(T value) {
            this.value = value;
        }
    }

    private Item first = null;

    public void printAll() {
        Item elt = this.first;

        while (elt != null) {
            System.out.println(elt.value);
            elt = elt.next;
        }
    }

    @Override
    public void add(T value) {
        Item elt = new Item(value);

        if (this.first == null) { // First added element.
            this.first = elt;
        } else {
            this.lastItem().next = elt;
        }
    }

    @Override
    public void remove(T value) {
        LinkedList<T>.Item elt = this.first;
        LinkedList<T>.Item last = null;

        if (elt != null) {
            // Find element.
            while (elt != null && !elt.value.equals(value)) {
                last = elt;
                elt = elt.next;
            }

            if (elt != null) {
                if (last == null) {
                    this.first = elt.next;
                } else {
                    last.next = elt.next;
                }
            }
        }
    }

    @Override
    public T get(int index) {
        Item elt = this.first;

        for (int i = 0; i < index && elt != null; ++ i, elt = elt.next);

        return elt == null ? null : elt.value;
    }

    private Item lastItem() {
        Item loop = this.first;

        if (loop != null) {
            while (loop.next != null) {
                loop = loop.next;
            }
        }

        return loop;
    }
}
