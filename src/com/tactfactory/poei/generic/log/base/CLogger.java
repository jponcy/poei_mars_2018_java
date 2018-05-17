
package com.tactfactory.poei.generic.log.base;

public class CLogger implements Logger {

    @Override
    public void error(String msg) {
        System.err.println(msg);
    }

    @Override
    public void info(String msg) {
        System.out.println(msg);
    }
}
