package net.engine;

public abstract class Config {

    public abstract String getBaseApiUrl();

    public abstract JSONConvert getDefaultJsonConvert();

    public abstract RequestConvert getRequestConvert();
}
