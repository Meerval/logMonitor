package logMonitor;

public class LogMonitorDemo {

    public static void main(String[] args) {
        String path = "src\\test\\java\\testFiles\\2022-2-22_v0.log";
        LogMonitor logMonitor = new LogMonitor(path);

        logMonitor.printOnlyErrors();
    }
}
