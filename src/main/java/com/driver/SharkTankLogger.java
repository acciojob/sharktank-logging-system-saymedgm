package com.driver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SharkTankLogger {
    private String logFileName;
    private boolean writeToConsole;

    public SharkTankLogger(String logFileName, boolean writeToConsole) {
        this.logFileName = logFileName;
        this.writeToConsole = writeToConsole;
    }

    public void log(LogLevel level, String message) {
        String formattedMessage = getFormattedMessage(level, message);
        writeToConsole(formattedMessage);
        writeToFile(formattedMessage);
    }

    private String getFormattedMessage(LogLevel level, String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date());
        return String.format("[%s] %s - %s", level.toString(), timestamp, message);
    }

    private void writeToConsole(String message) {
        if (writeToConsole) {
            System.out.println(message);
        }
    }

    private void writeToFile(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFileName, true))) {
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
