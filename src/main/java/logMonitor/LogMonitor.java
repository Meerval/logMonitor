package logMonitor;

import java.io.File;

public class LogMonitor {

    File logFile;
    PrinterLog printer;

    public LogMonitor(String logPath) {
        logFile = new File(logPath);
    }

    public void printEntireLog() {
        printer = new PrinterEntireLog(logFile);
        printer.print();
    }

    public void printOnlyErrors() {
        printer = new PrinterErrors(logFile);
        printer.print();
    }
}
