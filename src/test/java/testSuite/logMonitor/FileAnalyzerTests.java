package testSuite.logMonitor;

import logMonitor.FileAnalyzer;
import org.junit.jupiter.api.Test;
import testSuite.LogMonitorTestsConfig;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileAnalyzerTests extends LogMonitorTestsConfig {

    @Test
    public void testFileByPathIsAvailable() {
        setUpNewErrStream();
        assertFileByPathIsAvailable("2022-2-22_v0.log");
        assertConsole("", errStream);
    }

    private void assertFileByPathIsAvailable(final String fileName) {
        assertTrue(new FileAnalyzer(filePath + fileName).isAvailable());
    }

    @Test
    public void testFileIsAvailable() {
        setUpNewErrStream();
        assertFileIsAvailable("2022-2-22_v2.txt");
        assertConsole("", errStream);
    }

    private void assertFileIsAvailable(final String fileName) {
        assertTrue(new FileAnalyzer(new File(filePath + fileName)).isAvailable());
    }

    @Test
    public void testFileByPathIsNotExists() {
        setUpNewErrStream();
        String fileName = "22-2-2022.log";
        assertFileByPathIsNotAvailable(fileName);
        assertConsole("File {" + filePath + fileName + "} doesn't exist\n" +
                "Please, make sure you use the correct path to try again", errStream);
    }

    private void assertFileByPathIsNotAvailable(final String fileName) {
        assertFalse(new FileAnalyzer(filePath + fileName).isAvailable());
    }

    @Test
    public void testFileIsNotExists() {
        setUpNewErrStream();
        String fileName = "22-2-2022.log";
        assertFileIsNotAvailable(fileName);
        assertConsole("File {" + filePath + fileName + "} doesn't exist\n" +
                "Please, make sure you use the correct path to try again", errStream);
    }

    private void assertFileIsNotAvailable(final String fileName) {
        assertFalse(new FileAnalyzer(new File(filePath + fileName)).isAvailable());
    }

    @Test
    public void testFileByPathHasAnotherExtension() {
        setUpNewErrStream();
        String fileName = "2022-2-22.txt";
        assertFileByPathIsNotAvailable(fileName);
        assertConsole("File {" + filePath + fileName + "} doesn't exist\n" +
                "Please, make sure you use the correct path to try again", errStream);
    }

    @Test
    public void testFileHasAnotherExtension() {
        setUpNewErrStream();
        String fileName = "2022-2-22.txt";
        assertFileIsNotAvailable(fileName);
        assertConsole("File {" + filePath + fileName + "} doesn't exist\n" +
                "Please, make sure you use the correct path to try again", errStream);
    }

    @Test
    public void itIsNotAFileByPath() {
        setUpNewErrStream();
        assertFileByPathIsNotAvailable("");
        assertConsole("{" + filePath + "} is not a file\n" +
                "Please, use file, not a folder to try again", errStream);
    }

    @Test
    public void itIsNotAFile() {
        setUpNewErrStream();
        assertFileIsNotAvailable("");
        assertConsole("{" + filePath + "} is not a file\n" +
                "Please, use file, not a folder to try again", errStream);
    }

    @Test
    public void testFileByPathHasUnsupportedExtension() {
        setUpNewErrStream();
        String fileName = "2022-2-22.xml";
        assertFileByPathIsNotAvailable(fileName);
        assertConsole("File {" + filePath + fileName + "} " +
                "does not have a unsupported extension\n" +
                "Please, use file with .log or .txt extension to try again", errStream);
    }

    @Test
    public void testFileHasUnsupportedExtension() {
        setUpNewErrStream();
        String fileName = "2022-2-22.xml";
        assertFileIsNotAvailable(fileName);
        assertConsole("File {" + filePath + fileName + "} " +
                "does not have a unsupported extension\n" +
                "Please, use file with .log or .txt extension to try again", errStream);
    }
}
