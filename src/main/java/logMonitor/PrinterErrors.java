package logMonitor;

import java.io.File;

public class PrinterErrors extends PrinterLog {

    public PrinterErrors(File logFile) {
        super(logFile);
        super.printerConfig = new PrinterErrorEvent();
    }

    protected static class PrinterErrorEvent implements PrinterConfig {
        @Override
        public void displayOnConsole(String lastEvent) {
            if (lastEvent.contains("ERROR:"))
                System.out.println(lastEvent);
        }
    }
}