
package com.tactfactory.poei.thread.runnable;

public class StupidSingleton {

    private static volatile StupidSingleton instance;

    private long counter = 0;

    private StupidSingleton() {
    }

    public void add(int value) {
        this.counter += value;
    }

    public static synchronized StupidSingleton getInstance() {
        if (StupidSingleton.instance == null) StupidSingleton.instance = new StupidSingleton();

//        synchronized (StupidSingleton.class) {
//            if (StupidSingleton.instance == null) StupidSingleton.instance = new StupidSingleton();
//        }

        return StupidSingleton.instance;
    }

    public long value() {
        return this.counter;
    }
}
