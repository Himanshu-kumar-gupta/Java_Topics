import java.util.Arrays;
import java.util.List;

public class Stream1 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Anna");

        System.out.println("Original List:");
        // using method reference for println() method
        names.forEach(System.out::println);

        System.out.println("\nNames starting with 'A':");
        names.stream()                               // Create a stream from the list
            .filter(name -> name.startsWith("A"))  // Filter condition
            .forEach(System.out::println);         // Terminal operation

        System.out.println("\nNames with length > 3:");
        names.stream()
            .filter(name -> name.length() > 3)
            .forEach(name -> System.out.println("Name: " + name));

        System.out.println("\nNames starting with 'A' and length > 3 :");
        names.stream()
            .filter(name -> name.startsWith("A"))
            .filter(name -> name.length() > 3)
            .forEach(name -> System.out.println("Name: " + name));

        names.stream()
            .filter(name -> name.startsWith("A") && name.length() > 3)
            .filter(name -> name.length() > 3)
            .forEach(name -> System.out.println("NameAgain: " + name));
    }
}