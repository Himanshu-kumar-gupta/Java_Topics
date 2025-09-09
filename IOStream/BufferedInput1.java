import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedInput1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Enter an integer: ");
            int intVal = Integer.parseInt(br.readLine());

            System.out.print("Enter a float: ");
            float floatVal = Float.parseFloat(br.readLine());

            System.out.print("Enter a double: ");
            //can use any method that converts from String to required output
            double doubleVal = Double.valueOf(br.readLine());

            System.out.print("Enter a long: ");
            long longVal = Long.parseLong(br.readLine());

            System.out.print("Enter a boolean (true/false): ");
            boolean boolVal = Boolean.parseBoolean(br.readLine());

            System.out.print("Enter a single character: ");
            char charVal = br.readLine().charAt(0);

            // Print all values
            System.out.println("\n--- You Entered ---");
            System.out.println("Integer: " + intVal);
            System.out.println("Float: " + floatVal);
            System.out.println("Double: " + doubleVal);
            System.out.println("Long: " + longVal);
            System.out.println("Boolean: " + boolVal);
            System.out.println("Character: " + charVal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
