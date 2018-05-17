package com.tactfactory.poei.generic.log.base;

public class Log <T extends Logger> {
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

    @SuppressWarnings("all")
    private static Log<?> instance() {
        if (instance == null) {
            instance = new Log(new CLogger());
        }

        return instance;
    }

    public static void error(String msg) {
        instance().logger.error(msg);
    }

    public static void info(String msg) {
        instance().logger.info(msg);
    }
}
