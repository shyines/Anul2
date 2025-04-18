package com.pt.a2.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private final PrintWriter writer;

    public Logger(String pathname) {
        var file = new File(pathname);
        try {
            this.writer = new PrintWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public synchronized void log(Object message) {
        writer.println(message);
        writer.flush();
    }

    public void close() {
        this.writer.close();
    }
}
