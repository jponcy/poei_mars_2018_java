
package com.tactfactory.poei.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BadMath.max(1l,  3D);
    }

    @SuppressWarnings("all")
    private static void stupidUseOfLists() {
        List<Object> list = new ArrayList<>();

        list.add(new Integer(5));
        list.add((int) 'c');
        list.add("toto");
        list.add(Arrays.asList(list.get(0), list.get(1)));
        list.add(4);

        List<Integer> toto = new LinkedList<>();
        toto.add(5);

        list.forEach(System.out::println);
    }
}
