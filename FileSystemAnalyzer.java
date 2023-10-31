import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

// Recursion
// Max Heap
// Hash Tables

public class FileSystemAnalyzer {
    public static void analyzeDirectory(File directory) {
        System.out.println("Analyzing directory: " + directory.getAbsolutePath());

        // List the files and subdirectories in the current directory
        File[] files = directory.listFiles();

        // Init
        LinkedList nameList = new LinkedList();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // It's a file; you can perform file-specific analysis here
                    System.out.println("File: " + file.getName());
                    System.out.println("Size: " + file.length() + " bytes");
                    System.out.println("Type: " + getFileType(file));
                } else if (file.isDirectory()) {
                    // It's a subdirectory; recursively analyze it
                    nameList = recursiveAnalyzeDirectory(file, nameList);
                }
            }
        }

        System.out.println("\nLinked List Contents:");
        nameList.iterateList();

        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insertLinkedList(nameList);

        FileTypeHashtable fileTypeHashtable = new FileTypeHashtable();

        int topN = 3; // Specify the number of top counts to retrieve

        List<MaxHeap.heapNode> topNNodes = maxHeap.searchByTopNCounts(topN);
        if (!topNNodes.isEmpty()) {
            System.out.println("\nTop " + topN + " Nodes with Highest Counts:");
            for (MaxHeap.heapNode node : topNNodes) {
                System.out.println("Type: " + node.type + ", Count: " + node.count + ", Bytes: " + node.bytes);
                fileTypeHashtable.printFileTypeDescription(node.type);
                System.out.println();
            }
        } else {
            System.out.println("Heap is empty.");
        }
    }

    public static LinkedList recursiveAnalyzeDirectory(File directory, LinkedList nameList) {
        System.out.println("Analyzing directory: " + directory.getAbsolutePath());

        // List the files and subdirectories in the current directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                nameList.add(file.getName(), getFileType(file), file.length());
                if (file.isFile()) {
                    // It's a file; you can perform file-specific analysis here
                    System.out.println("File: " + file.getName());
                    System.out.println("Size: " + file.length() + " bytes");
                    System.out.println("Type: " + getFileType(file));
                } else if (file.isDirectory()) {
                    // It's a subdirectory; recursively analyze it
                    nameList = recursiveAnalyzeDirectory(file, nameList);
                }
            }
        }
        return nameList;
    }

        public static String getFileType(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            return fileName.substring(dotIndex + 1);
        }
        return "Unknown"; // File has no extension
    }

    // Tester: Track runtime
    public static void main(String[] args) {
        // Specify the root directory you want to analyze
        String rootDirectory = "C:/Users/winst/OneDrive/Documents/Test";

        Instant startTime = Instant.now(); // Start time

        // Create a File object for the root directory
        File rootDir = new File(rootDirectory);

        if (rootDir.exists() && rootDir.isDirectory()) {
            // Start the analysis from the root directory
            analyzeDirectory(rootDir);
        } else {
            System.out.println("The specified root directory does not exist or is not a directory.");
        }

        if (rootDir.exists() && rootDir.isDirectory()) {
            System.out.println("\nDirectory Tree for: " + rootDir.getAbsolutePath());
            DirectoryTreePrinter.printDirectoryTree(rootDir, 0);
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }

        Instant endTime = Instant.now(); // End time
        Duration elapsedTime = Duration.between(startTime, endTime); // Elapsed time

        long microSeconds = elapsedTime.toNanos() / 1_000L; // Convert nanoseconds to microseconds
        System.out.println("Analysis completed in " + microSeconds + " microseconds.");


    }
}