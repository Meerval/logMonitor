package testSuite.logMonitor;

import logMonitor.PrinterEntireLog;
import logMonitor.PrinterErrors;
import org.junit.jupiter.api.Test;
import testSuite.LogMonitorTestsConfig;

import java.io.File;

public class PrinterErrorsTests extends LogMonitorTestsConfig {

    @Test
    public void testPrintErrorsV0() {
        PrinterErrors printer = new PrinterErrors(new File(filePath + "2022-2-22_v0.log"));
        setUpNewOutStream();
        printer.print();
        assertConsole("2022-2-22 13:33:54 [123] ERROR: Some exception occurred\n" +
                "2022-2-22 13:33:57 [190] ERROR: Invalid input: \"Tuhma kissa! Pois näppäimistöltä\"\n" +
                "2022-2-22 13:33:59 [105] ERROR: Some exception occurred and it takes a few lines\n" +
                "                         Please do something to identify them as good looking message", outStream);
    }

    @Test
    public void testPrintErrorsV1() {
        PrinterErrors printer = new PrinterErrors(new File(filePath + "2022-2-22_v1.log"));
        setUpNewOutStream();
        printer.print();
        assertConsole("2022-2-22 13:33:54 [123] ERROR: Some exception occurred\n" +
                "2022-2-22 13:33:57 [190] ERROR: Invalid input: \"Tuhma kissa! Pois näppäimistöltä\"\n" +
                "2022-2-22 13:33:59 [105] ERROR: Some exception occurred and it takes a few lines\n" +
                "                         Please do something to identify them as good looking message", outStream);
    }

    @Test
    public void testPrintErrorsV2() {
        PrinterErrors printer = new PrinterErrors(new File(filePath + "2022-2-22_v2.txt"));
        setUpNewOutStream();
        printer.print();
        assertConsole("2022-2-22 13:33:54 [123] ERROR: Some exception occurred", outStream);
    }

    @Test
    public void testPrintErrorsV3() {
        PrinterErrors printer = new PrinterErrors(new File(filePath + "2022-2-22_v3.log"));
        setUpNewOutStream();
        printer.print();
        assertConsole("", outStream);
    }

    @Test
    public void testPrintErrorsV5() {
        PrinterErrors printer = new PrinterErrors(new File(filePath + "2022-2-22_v5.log"));
        setUpNewOutStream();
        printer.print();
        assertConsole("2022-2-22 13:33:59 [105] ERROR: Some exception occurred and it takes a few lines\n" +
                "                         Please do something to identify them as good looking message", outStream);
    }

    @Test
    public void testPrintErrorsV6() {
        PrinterEntireLog printer = new PrinterEntireLog(new File(filePath + "2022-2-22_v6.log"));
        setUpNewOutStream();
        printer.print();
        assertConsole("", outStream);
    }

}
