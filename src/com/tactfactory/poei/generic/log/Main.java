package com.tactfactory.poei.generic.log;

import com.tactfactory.poei.generic.log.base.AlreadyInitializedLoggerException;
import com.tactfactory.poei.generic.log.base.FLogger;
import com.tactfactory.poei.generic.log.base.Log;

public class Main {

    public static void main(String[] args) {
        try {
            Log.init(new FLogger());
        } catch (AlreadyInitializedLoggerException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        Log.info("Demarage du programe");

        try {
            int r = 3 / 0;
        } catch (ArithmeticException e) {
            Log.error("Oula");
        }

        Log.info("End of BIG program (you're welcome about frenglish)!");
    }
}
