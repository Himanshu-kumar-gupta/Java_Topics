import java.io.*;

public class TryCatchFinally1 {

    public static void main(String[] args) {

        System.out.println("=== try-catch-finally with Multi-Catch ===");

        try {
            String s = null;
            int a = 10 / 0; // ArithmeticException
            System.out.println(s.length()); // NullPointerException (won't be reached)
        } 
        catch (ArithmeticException | NullPointerException e) {
            System.out.println("Caught multiple exception types: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes.");
        }

        System.out.println("\n=== try-with-resources with FileReader ===");

        // Make sure this file exists or update path
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("File Line: " + line);
            }
        } 
        // catch (FileNotFoundException | IOException e) { // FileNotFoundException is a subclass of alternative IOException
        catch(FileNotFoundException e) {
            System.out.println("File error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        catch(IOException e) {
            System.out.println("File error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
