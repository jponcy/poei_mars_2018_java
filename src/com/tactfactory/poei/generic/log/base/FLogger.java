
package com.tactfactory.poei.generic.log.base;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FLogger implements Logger {

    private static String FILENAME = null;

    @Override
    public void error(String msg) {
        this.write("ERROR - " + msg);
    }

    @Override
    public void info(String msg) {
        this.write("INFO - " + msg);
    }

    private void write(String msg) {
        if (FILENAME == null) {
            FILENAME = "" + System.currentTimeMillis() + ".log";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            writer.write(System.currentTimeMillis() + " " + msg);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
