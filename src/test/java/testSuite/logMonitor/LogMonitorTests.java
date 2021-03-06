package testSuite.logMonitor;

import logMonitor.LogMonitor;
import org.junit.jupiter.api.Test;
import testSuite.LogMonitorTestsConfig;

public class LogMonitorTests extends LogMonitorTestsConfig {

    final private LogMonitor lm = new LogMonitor(filePath + "2022-2-22_v0.log");

    @Test
    public void testPrintEntireLog() {
        setUpNewOutStream();
        lm.printEntireLog();
        assertConsole("2022-2-22 13:32:40 [190] User3 logs in\n" +
                "2022-2-22 13:33:45 [123] User1 logs in\n" +
                "2022-2-22 13:33:45 [123] User1 goes to search page\n" +
                "2022-2-22 13:33:46 [123] User1 types in search text\n" +
                "2022-2-22 13:33:48 [256] User2 logs in\n" +
                "2022-2-22 13:33:49 [190] User3 runs some job\n" +
                "2022-2-22 13:33:50 [123] User1 clicks search button and searches something wrong\n" +
                "2022-2-22 13:33:53 [256] User2 does something\n" +
                "2022-2-22 13:33:54 [123] ERROR: Some exception occurred\n" +
                "2022-2-22 13:33:56 [256] User2 logs off\n" +
                "2022-2-22 13:33:57 [190] ERROR: Invalid input: \"Tuhma kissa! Pois näppäimistöltä\"\n" +
                "2022-2-22 13:33:57 [105] User4 logs in\n" +
                "2022-2-22 13:33:59 [105] ERROR: Some exception occurred and it takes a few lines\n" +
                "                         Please do something to identify them as good looking message\n" +
                "2022-2-22 13:34:01 [123] User1 logs off", outStream);
    }    @Test
    public void testPrintOnlyErrors() {
        setUpNewOutStream();
        lm.printOnlyErrors();
        assertConsole("2022-2-22 13:33:54 [123] ERROR: Some exception occurred\n" +
                "2022-2-22 13:33:57 [190] ERROR: Invalid input: \"Tuhma kissa! Pois näppäimistöltä\"\n" +
                "2022-2-22 13:33:59 [105] ERROR: Some exception occurred and it takes a few lines\n" +
                "                         Please do something to identify them as good looking message", outStream);
    }
}
