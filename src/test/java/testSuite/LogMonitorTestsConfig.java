package testSuite;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
public class LogMonitorTestsConfig {

    protected final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    protected final ByteArrayOutputStream errStream = new ByteArrayOutputStream();

    protected final String filePath = "src\\test\\java\\testFiles\\";

    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    protected void printTestInfo(TestInfo testInfo) {
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss\t").format(Calendar.getInstance().getTime());
        System.out.print((char) 27 + "[37m" + currentTime + (char) 27 + "[0m");
        System.out.println(testInfo.getDisplayName());
    }

    @AfterEach
    protected void setUpOriginalConsoleSteams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    protected void setUpNewOutStream() {
        System.setOut(new PrintStream(outStream));
    }

    protected void setUpNewErrStream() {
        System.setErr(new PrintStream(errStream));
    }

    protected static void assertConsole(final String example, final ByteArrayOutputStream stream) {
        assertEquals(example.trim(), stream.toString().replaceAll("\r", "").trim());
    }
}
