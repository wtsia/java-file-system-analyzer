import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class FileSystemAnalyzer {
    private LinkedList<String> fileTypeList;

    public static void analyzeDirectory(File directory) { // recursively analyze directory
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

    public static String getFileType(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            return fileName.substring(dotIndex + 1);
        }
        return "Unknown"; // File has no extension
    }

    // File type analysis
    public void FileTypeCounter() {
        fileTypeList = new LinkedList<>();
    }

    public void addFileType(String fileType) {
        fileTypeList.add(fileType);
    }

    public Map<String, Integer> getFileTypeCounts() {
        Map<String, Integer> fileTypeCounts = new HashMap<>();

        for (String fileType : fileTypeList) {
            fileTypeCounts.put(fileType, fileTypeCounts.getOrDefault(fileType, 0) + 1);
        }

        // Sort the fileTypeCounts by count in descending order
        return fileTypeCounts.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public void printTopNFileTypes(int n) { // DEFAULT 3
        Map<String, Integer> fileTypeCounts = getFileTypeCounts();

        if (n <= 0) {
            System.out.println("Invalid value of 'n'.");
            return;
        }

        System.out.println("Top " + n + " File Types:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : fileTypeCounts.entrySet()) {
            if (count >= n) {
                break;
            }
            System.out.println(entry.getKey() + ": " + entry.getValue() + " occurrences");
            count++;
        }
    }




    // TESTER
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
}
