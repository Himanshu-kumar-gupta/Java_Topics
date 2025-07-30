import java.util.*;

public class Stream2 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Bob", "Eve", "Alice");

        // 0. peek() - for debugging/logging (intermediate but performs an action)
        System.out.println("=== Using peek() ===");
        names.stream()
             .peek(n -> System.out.println("Original: " + n))
             .map(String::toUpperCase)
             .peek(n -> System.out.println("Mapped: " + n))
             .forEach(n -> {}); // Needed to trigger stream processing

        // 1. map() to Uppercase
        System.out.println("\n=== map() to Uppercase ===");
        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);

        // 2. mapToInt() and sum()
        System.out.println("\n=== mapToInt() and sum() ===");
        int totalLength = names.stream()
                               .mapToInt(String::length)
                               .sum();
        System.out.println("Total length: " + totalLength);

        // 3. distinct()
        System.out.println("\n=== distinct() ===");
        names.stream()
             .distinct()
             .forEach(System.out::println);

        // 4. sorted()    
        System.out.println("\n=== Using sorted() ===");
        names.stream()
             .sorted()
             .forEach(System.out::println);

        // 4. sorted() using Comparator (by length of name)
        System.out.println("\n=== sorted() using Comparator (by length) ===");
        names.stream()
             .sorted(Comparator.comparingInt(String::length))
             .forEach(System.out::println);

        // 5. limit(3)
        System.out.println("\n=== limit(3) ===");
        names.stream()
             .limit(3)
             .forEach(System.out::println);

        // 6. skip(2)
        System.out.println("\n=== skip(2) ===");
        names.stream()
             .skip(2)
             .forEach(System.out::println);

        // 7. flatMap() 
        System.out.println("\n=== flatMap() ===");
        List<List<String>> nestedList = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("C", "D"),
            Arrays.asList("E")
        );

        nestedList.stream()
                  .flatMap(list -> list.stream())  //With method reference - .flatMap(Collection::stream)
                  .forEach(System.out::println);
    }
}