import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemAnalyzer {

    public static void main(String[] args) {
        // Specify the root directory you want to analyze
        String rootDirectory = "C:/Users/Winston/Documents/Test";

        // Create a File object for the root directory
        File rootDir = new File(rootDirectory);

        if (rootDir.exists() && rootDir.isDirectory()) {
            // Start the analysis from the root directory
            analyzeDirectory(rootDir);
        } else {
            System.out.println("The specified root directory does not exist or is not a directory.");
        }

        if (rootDir.exists() && rootDir.isDirectory()) {
            System.out.println("Directory Tree for: " + rootDir.getAbsolutePath());
            DirectoryTreePrinter.printDirectoryTree(rootDir, 0);
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }

    public static void analyzeDirectory(File directory) {
        System.out.println("Analyzing directory: " + directory.getAbsolutePath());

        // List the files and subdirectories in the current directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // It's a file; you can perform file-specific analysis here
                    System.out.println("File: " + file.getName());
                    System.out.println("Size: " + file.length() + " bytes");
                } else if (file.isDirectory()) {
                    // It's a subdirectory; recursively analyze it
                    analyzeDirectory(file);
                }
            }
        }
    }

    public static String getFileType(Path path) {
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            return fileName.substring(dotIndex + 1);
        }
        return "Unknown"; // File has no extension
    }
}
