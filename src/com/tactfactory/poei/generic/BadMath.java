
package com.tactfactory.poei.generic;

/**
 * @author Noufel Abbassi!
 */
public class BadMath {
    /**
     * @param a
     * @param b
     * @return
     * @author Noufel Abbassi!
     */
    public static <T extends Number, K extends Number> Number max(T a, K b) {
        Number result = a.doubleValue() > b.doubleValue() ? a : b;

        System.out.println("Max(" + a + ", " + b + ") => " + result);

        return result;
    }
}
