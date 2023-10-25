import java.io.File;
import java.util.Scanner;

public class CommandLineInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileTypeHashtable fileTypeHashtable = new FileTypeHashtable();

        System.out.println("Welcome to the File System Analyzer!");
        System.out.print("Please enter directory for traversal: ");
        // Test input: C:/Users/Winston/Documents/Test
        String name = scanner.nextLine();

        try {
            // Analyze system
            File rootDir = new File(name);
            if (rootDir.exists() && rootDir.isDirectory()) {
                // Start the analysis from the root directory
                FileSystemAnalyzer.analyzeDirectory(rootDir);
            } else {
                System.out.println("The specified root directory does not exist or is not a directory.");
            }

            // Print tree
            if (rootDir.exists() && rootDir.isDirectory()) {
                System.out.println("Directory Tree for: " + rootDir.getAbsolutePath());
                DirectoryTreePrinter.printDirectoryTree(rootDir, 0);
            } else {
                System.out.println("The specified directory does not exist or is not a directory.");
            }

            // Check highest filetype
            String fileType = "pdf";
            fileTypeHashtable.printFileTypeDescription(fileType);
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }

        scanner.close();
    }
}
