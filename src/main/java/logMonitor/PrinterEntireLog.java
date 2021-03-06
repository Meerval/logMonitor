package logMonitor;

import java.io.File;

public class PrinterEntireLog extends PrinterLog {

    public PrinterEntireLog(File logFile) {
        super(logFile);
        super.printerConfig = new PrinterEachEvent();
    }


    protected static class PrinterEachEvent implements PrinterConfig {
        @Override
        public void displayOnConsole(String lastEvent) {
            System.out.println(lastEvent);
        }
    }

}