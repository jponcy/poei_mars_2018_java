package com.tactfactory.poei.first;

class MyFirstClass extends Object {
    static float PI = 3.14f; // Class attribute.
    int x, y; // Object attributes.

    /** Simple constructor. */
    MyFirstClass() {
        this(42); // Call other constructor.
    }

    /** Constructor with one integer parameter. */
    MyFirstClass(int y) {
        System.out.println("Construction d'un objet");
        this.y = 3;
    }

    void coucou() {
        int i, j; // Local variable.

        this.coucou("world");
    }

    void coucou(String name) {
        System.out.println("Hello " + name + "!");
    }

    void coucou(String cou, int i)
    {}

    void coucou(int i, String cou)
    {}

    void dawa() {
        System.out.println("PI avant le dawa : " + PI);
        MyFirstClass.PI *= 2;
        System.out.println("PI après le dawa: " + PI);
    }

    void nameConflicts(int x) {
        this.x = 2;
        y = 2;

        System.out.println(x);
        System.out.println(this.x);
    }

    int square(int i) {
        return (int) Math.pow(i, 2);
    }

    void stupid(String s, int i) {
        this.stupid(i, s);
    }
    void stupid(int i, String s) {
        System.out.println(s);
    }


    public MyFirstClass toCopy() {
        MyFirstClass result = new MyFirstClass();
        result.x = x;
        result.y = y;
        return result;
    }

    public static void toto4312() {

    }

    public final int toty(int i, int a, int z, String e, Integer o) {
        return 4;
    }

    void testVar() {
        MyFirstClass i = new MyFirstClass();
        i.y = 2;
        this.subTestVar(i.toCopy());
        System.out.println("Var: " + i.y);
    }

    void subTestVar(MyFirstClass i) {
        i.y *= 2;
        System.out.println("Sub: " + i.y);
    }
}
