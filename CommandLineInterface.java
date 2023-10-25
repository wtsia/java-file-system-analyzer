import java.util.Scanner;

public class CommandLineInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the File System Analyzer!");
        System.out.print("Please enter your name: ");

        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "! Welcome to the CLI.");
        System.out.println("What would you like to do today?");

        // Here you can add more options and functionality based on user input.

        scanner.close();
    }
}
