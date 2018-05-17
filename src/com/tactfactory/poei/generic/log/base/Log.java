package com.tactfactory.poei.generic.log.base;

public class Log <T extends Logger> implements Logger {
    private T logger;
    private static Log instance;

    private Log(T instance) {
        this.logger = instance;
    }

    public static <K extends Logger> void init(K loggerInstance)
            throws AlreadyInitializedLoggerException {
        if (instance == null) {
            instance = new Log<>(loggerInstance);
        } else {
            throw new AlreadyInitializedLoggerException();
        }
    }

    public static Log<?> instance() throws LoggerNotInitializedException {
        if (instance == null) {
            throw new LoggerNotInitializedException();
        }

        return instance;
    }

    @Override
    public void error(String msg) {
        logger.error(msg);
    }

    @Override
    public void info(String msg) {
        logger.info(msg);
    }
}
