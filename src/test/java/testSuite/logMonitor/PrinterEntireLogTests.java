package testSuite.logMonitor;

import logMonitor.PrinterEntireLog;
import org.junit.jupiter.api.Test;
import testSuite.LogMonitorTestsConfig;

import java.io.File;

public class PrinterEntireLogTests extends LogMonitorTestsConfig {

    @Test
    public void testPrintEntireLogV0() {
        PrinterEntireLog printer = new PrinterEntireLog(new File(filePath + "2022-2-22_v0.log"));
        setUpNewOutStream();
        printer.print();
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
    }

    @Test
    public void testPrintEntireLogV2() {
        PrinterEntireLog printer = new PrinterEntireLog(new File(filePath + "2022-2-22_v2.txt"));
        setUpNewOutStream();
        printer.print();
        assertConsole("2022-2-22 13:33:54 [123] ERROR: Some exception occurred", outStream);
    }

    @Test
    public void testPrintEntireLogV4() {
        PrinterEntireLog printer = new PrinterEntireLog(new File(filePath + "2022-2-22_v4.log"));
        setUpNewOutStream();
        printer.print();
        assertConsole("", outStream);
    }

    @Test
    public void testPrintEntireLogV6() {
        PrinterEntireLog printer = new PrinterEntireLog(new File(filePath + "2022-2-22_v6.log"));
        setUpNewOutStream();
        printer.print();
        assertConsole("", outStream);
    }

}
