
package com.tactfactory.poei.thread.runnable;

class ScorePrinter implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println(StupidSingleton.getInstance().value());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



public class Main {
    public static void main(String[] args) {
        new Thread(new ExampleRunnable(1)).start();
        new Thread(new ExampleRunnable(1000)).start();

        new Thread(new ScorePrinter()).start();
    }
}
