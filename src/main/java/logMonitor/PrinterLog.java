package logMonitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public abstract class PrinterLog {

    protected final File logFile;
    protected PrinterConfig printerConfig;

    public PrinterLog(File logFile) {
        this.logFile = logFile;
    }

    public void print() {
        if (new FileAnalyzer(logFile).isAvailable()) {
            printByEvents();
        }
    }

    protected void printByEvents() {
        try (FileReader fileReader = new FileReader(logFile)) {
            BufferedReader br = new BufferedReader(fileReader);
            String currentLine;
            String lastEvent = "";
            while ((currentLine = br.readLine()) != null) {
                lastEvent = selectErrorEventsToPrint(currentLine, lastEvent);
            }
            printerConfig.displayOnConsole(lastEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String selectErrorEventsToPrint(String currentLine, String lastEvent) {
        if (currentLine.matches("" +
                "\\d{4}[-]\\d{1,2}[-]\\d{1,2}\\s" +     // yyyy-MM-dd + space
                "\\d{1,2}[:]\\d{1,2}[:]\\d{1,2}\\s" +   // hh:mm:ss + space
                "(\\[\\d{3}\\])\\s.+")) {               // [ddd] + text
            if (printerConfig == null) {
                System.err.println("" +
                        "Pay attention: The interface PrinterConfig  has not been overridden!\n" +
                        "Each event will be displayed");
                printerConfig = new PrinterEntireLog.PrinterEachEvent();
            }
            printerConfig.displayOnConsole(lastEvent);
            lastEvent = currentLine;
        } else if (currentLine.matches("\\s+[A-Z].+") && !lastEvent.equals("")) {
            lastEvent = lastEvent + "\n" + currentLine;
        } else if (!lastEvent.equals("")){
            // Normalize spaces
            currentLine = Pattern.compile("\\s+").matcher(currentLine).replaceAll(" ").trim();
            lastEvent = lastEvent + " " + currentLine;
        }
        return lastEvent;
    }

    public interface PrinterConfig {
        default void displayOnConsole(String lastEvent) {
            System.out.println(lastEvent);
        }
    }

}