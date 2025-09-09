import java.util.Scanner;

public class ScannerInput1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter an integer: ");
            int intVal = sc.nextInt();

            System.out.print("Enter a float: ");
            float floatVal = sc.nextFloat();

            System.out.print("Enter a double: ");
            double doubleVal = sc.nextDouble();

            System.out.print("Enter a long: ");
            long longVal = sc.nextLong();

            System.out.print("Enter a boolean (true/false): ");
            boolean boolVal = sc.nextBoolean();

            System.out.print("Enter a single character: ");
            char charVal = sc.next().charAt(0);  // next() reads a word, take first char

            // Print all values
            System.out.println("\n--- You Entered ---");
            System.out.println("Integer: " + intVal);
            System.out.println("Float: " + floatVal);
            System.out.println("Double: " + doubleVal);
            System.out.println("Long: " + longVal);
            System.out.println("Boolean: " + boolVal);
            System.out.println("Character: " + charVal);
        }
    }
}
