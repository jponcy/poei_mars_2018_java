
package com.tactfactory.poei.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExampleThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; ++ i) {
            System.out.println(Thread.currentThread().getName() + " => " + i);

            try {
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; ++ i) {
            ExampleThread t = new ExampleThread();

            if (i == 0) t.setName("Kirikou");
            else if (i == 9) t.setName("Olaf");

            threads.add(t);

            t.start();
        }

        /* Pas bien !
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        threads.forEach(t -> t.stop());
        */
    }
}
