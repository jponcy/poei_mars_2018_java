package com.tactfactory.poei.thread.runnable;

public class ExampleRunnable implements Runnable {

    private int incNb;

    public ExampleRunnable(int incrementationNumber) {
        this.incNb = incrementationNumber;
    }

    @Override
    public void run() {
        while (true) {
            StupidSingleton.getInstance().add(this.incNb);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
