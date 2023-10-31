import java.io.File;

public class DirectoryTreePrinter {
    public static void printDirectoryTree(File directory, int level) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Print the directory name with appropriate indentation
                    System.out.println(getIndentation(level) + "+ " + file.getName());

                    // Recursively print the subdirectory's tree
                    printDirectoryTree(file, level + 1);
                } else {
                    // Print the file name with appropriate indentation
                    System.out.println(getIndentation(level) + "- " + file.getName());
                }
            }
        }
    }

    public static String getIndentation(int level) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indentation.append("  "); // Two spaces for each level
        }
        return indentation.toString();
    }


    // Test
    public static void main(String[] args) {
        String directoryPath = "C:/Users/winst/OneDrive/Documents/Test"; // Replace with the directory path you want to print
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Directory Tree for: " + directory.getAbsolutePath());
            printDirectoryTree(directory, 0);
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }
}
