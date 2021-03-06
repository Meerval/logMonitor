package logMonitor;

import java.io.File;

public class FileAnalyzer {

    File file;

    public FileAnalyzer(File file) {
        this.file = file;
    }

    public FileAnalyzer(String filePath) {
        this.file = new File(filePath);
    }

    public boolean isAvailable() {
        if (file.exists())
            return isItNotAFile() && isReadable() && isExtCorrect();
        System.err.println("File {" + file.getPath() + "} doesn't exist\n" +
                "Please, make sure you use the correct path to try again");
        return false;
    }

    private boolean isReadable() {
        if (file.canRead())
            return true;
        System.err.println("File {" + file.getPath() + "} is unreadable\n" +
                "Please, make sure the file has read access to try again");
        return false;
    }

    private boolean isItNotAFile() {
        if (file.isFile())
            return true;
        System.err.println("{" + file.getPath() + "\\} is not a file\n" +
                "Please, use file, not a folder to try again");
        return false;
    }

    private boolean isExtCorrect() {
        String fileName = file.getName();
        if (fileName.endsWith(".log") || fileName.endsWith(".txt"))
            return true;
        System.err.println("File {" + file.getPath() + "} does not have a unsupported extension\n" +
                "Please, use file with .log or .txt extension to try again");
        return false;
    }
}