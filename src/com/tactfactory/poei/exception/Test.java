
package com.tactfactory.poei.exception;

class ZeroDivisionException extends Exception {
}
class EvenNumberException extends Exception {
    public EvenNumberException() {
        this("variable named 'a' should not be even");
    }
    public EvenNumberException(String msg) {
        super(msg);
    }
}

public class Test {

    public static final int OK = 0;

    public static final int DIVISION_BY_0 = -1;

    public void div(int a, int b) throws ZeroDivisionException, EvenNumberException {
        if (a % 2 == 0) {
            throw new EvenNumberException();
        }

        if (b == 0) throw new ZeroDivisionException();

        int result = a / b;

        System.out.println(result);
    }

    public static void main(String[] args) {
        Test test = new Test();

        // try {
        // test.div(2, 0);
        // } catch (ArithmeticException e) {
        // e.printStackTrace();
        // System.out.println("Exprès ?");
        //
        // try {
        // int inf = 3/0;
        // } catch (ArithmeticException math) {
        // System.out.println("oups");
        // }
        // } catch (Exception ee) {
        // System.out.println("default");
        // ee.printStackTrace();
        // }

        int a = 0;
        boolean correct = false;

        do {
            System.out.println();
            System.out.println("Try with " + a);

            try {
                test.div(a, 2);
                correct = true;
            } catch (ZeroDivisionException | EvenNumberException e) {
                e.printStackTrace();
                a ++;
            }
        } while (!correct);
    }
}
