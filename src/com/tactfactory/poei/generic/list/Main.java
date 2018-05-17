
package com.tactfactory.poei.generic.list;

public class Main {

    public static void main(String[] args) {
        array();

//        linked();
    }

    private static void array() {
        List<String> list = new ArrayList<>();
        list.add("string");
        list.add("string");
        list.add("a");
        list.add("b");
        System.out.println(list);
    }

    @SuppressWarnings("all")
    private static void linked() {
        LinkedList<String> list = new LinkedList<>();

        list.add("Toto");
        list.add("Titi");
        list.add("Tutu");

        list.printAll();
    }
}
