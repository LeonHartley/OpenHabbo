package com.openhabbo.commons.logging;

import org.eclipse.jetty.util.log.AbstractLogger;
import org.eclipse.jetty.util.log.Logger;

public class JettyLogger extends AbstractLogger {
    @Override
    protected Logger newLogger(String s) {
        return this;
    }

    @Override
    public String getName() {
        return "Null";
    }

    @Override
    public void warn(String s, Object... objects) {

    }

    @Override
    public void warn(Throwable throwable) {

    }

    @Override
    public void warn(String s, Throwable throwable) {

    }

    @Override
    public void info(String s, Object... objects) {

    }

    @Override
    public void info(Throwable throwable) {

    }

    @Override
    public void info(String s, Throwable throwable) {

    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public void setDebugEnabled(boolean b) {

    }

    @Override
    public void debug(String s, Object... objects) {

    }

    @Override
    public void debug(Throwable throwable) {

    }

    @Override
    public void debug(String s, Throwable throwable) {

    }

    @Override
    public void ignore(Throwable throwable) {

    }
}
