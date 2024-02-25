package com.driver;

public class LoggerFactory {
    public static SharkTankLogger createLogger(String logFileName, boolean writeToConsole) {
        return new SharkTankLogger(logFileName, writeToConsole);
    }
}
