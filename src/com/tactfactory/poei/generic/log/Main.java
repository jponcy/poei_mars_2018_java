package com.tactfactory.poei.generic.log;

import com.tactfactory.poei.generic.log.base.AlreadyInitializedLoggerException;
import com.tactfactory.poei.generic.log.base.FLogger;
import com.tactfactory.poei.generic.log.base.Log;
import com.tactfactory.poei.generic.log.base.LoggerNotInitializedException;

public class Main {
    private static Log<?> logger;

    public static void main(String[] args) {
        try {
            Log.init(new FLogger());
            logger = Log.instance();
        } catch (AlreadyInitializedLoggerException | LoggerNotInitializedException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        logger.info("Demarage du programe");

        try {
            int r = 3 / 0;
        } catch (ArithmeticException e) {
            logger.error("Oula");
        }

        logger.info("End of BIG program (you're welcome about frenglish)!");
    }
}
