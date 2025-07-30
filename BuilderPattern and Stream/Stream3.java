import java.util.*;
import java.util.stream.*;

public class Stream3 {

    public static void main(String[] args) {

        // Stream.of()
        System.out.println("=== Stream.of() ===");
        Stream<String> fruitStream = Stream.of("Apple", "Banana", "Cherry", "Date");
        fruitStream.forEach(System.out::println);

        // Create a list of integers for testing
        List<Integer> numbers = Arrays.asList(10, 20, 5, 30, 15);

        // count()
        System.out.println("\n=== count() ===");
        long count = numbers.stream().count();
        System.out.println("Count: " + count);

        /* Optional class all methods not explained in notes:
         * orElse(T other): Returns the value if present, otherwise returns a default value.
         * orElseGet(Supplier<? extends T> other): Returns the value if present, otherwise returns the result of a Supplier.
         * ifPresent(Consumer<? super T> consumer): Executes a consumer if a value is present.
         * map(Function<? super T, ? extends U> mapper): Transforms the value if present.
         * filter(Predicate<? super T> predicate): Filters the value based on a predicate.
         */

        // max()
        System.out.println("\n=== max() ===");
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        max.ifPresent(m -> System.out.println("Max: " + m));

        // min()
        System.out.println("\n=== min() ===");
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        min.ifPresent(m -> System.out.println("Min: " + m));

        // average()
        System.out.println("\n=== average() ===");
        OptionalDouble average = numbers.stream()
                                        .mapToInt(Integer::intValue)
                                        .average();
        average.ifPresent(avg -> System.out.println("Average: " + avg));

        // findFirst()
        System.out.println("\n=== findFirst() ===");
        Optional<Integer> first = numbers.stream().findFirst();
        first.ifPresent(f -> System.out.println("First: " + f));

        // findAny()
        System.out.println("\n=== findAny() ===");
        Optional<Integer> any = numbers.stream().findAny();
        any.ifPresent(a -> System.out.println("Any: " + a));

        // allMatch()
        System.out.println("\n=== allMatch(x > 0) ===");
        boolean allPositive = numbers.stream().allMatch(x -> x > 0);
        System.out.println("All > 0? " + allPositive);

        // anyMatch()
        System.out.println("\n=== anyMatch(x > 25) ===");
        boolean anyGreaterThan25 = numbers.stream().anyMatch(x -> x > 25);
        System.out.println("Any > 25? " + anyGreaterThan25);

        // noneMatch()
        System.out.println("\n=== noneMatch(x < 0) ===");
        boolean noneNegative = numbers.stream().noneMatch(x -> x < 0);
        System.out.println("None < 0? " + noneNegative);

        // reduce() for sum
        System.out.println("\n=== reduce() for sum ===");
        Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
        sum.ifPresent(s -> System.out.println("Sum using reduce: " + s));

        // reduce() for String concatenation
        System.out.println("\n=== reduce() for String concatenation ===");
        List<String> words = Arrays.asList("Java", "Stream", "API");
        Optional<String> sentence = words.stream().reduce((a, b) -> a + " " + b);
        sentence.ifPresent(s -> System.out.println("Concatenated sentence: " + s));
    }
}
