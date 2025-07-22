import java.util.function.*;
import java.util.*;
import java.util.stream.*;

public class FuncInterface1 {

    public static void main(String[] args) {

        System.out.println("=== Supplier ===");
        Supplier<String> supplier = () -> "Hello from Supplier!";
        System.out.println(supplier.get());

        System.out.println("\n=== Consumer ===");
        Consumer<String> consumer = s -> System.out.println("Consumed: " + s);
        consumer.accept("Message to Consumer");

        System.out.println("\n=== Predicate ===");
        Predicate<String> isLongerThan5 = s -> s.length() > 5;
        System.out.println("Is 'HelloWorld' longer than 5? " + isLongerThan5.test("HelloWorld"));

        System.out.println("\n=== Function ===");
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'OpenAI': " + stringLength.apply("OpenAI"));

        System.out.println("\n=== BiPredicate ===");
        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        System.out.println("Is 10 greater than 5? " + isGreater.test(10, 5));

        System.out.println("\n=== UnaryOperator ===");
        UnaryOperator<String> toUpperCase = s -> s.toUpperCase();
        System.out.println("UnaryOperator on 'java': " + toUpperCase.apply("java"));

        System.out.println("\n=== Primitive Interfaces for double ===");
        DoubleSupplier randomSupplier = () -> Math.random() * 100;
        System.out.println("Random double: " + randomSupplier.getAsDouble());

        DoubleConsumer doubleConsumer = d -> System.out.println("Consumed double: " + d);
        doubleConsumer.accept(42.0);

        DoublePredicate isPositive = d -> d > 0;
        System.out.println("Is 42.0 positive? " + isPositive.test(42.0));

        System.out.println("\n=== ToDoubleFunction ===");
        ToDoubleFunction<String> toDoubleLength = str -> str.length() * 2.0;
        System.out.println("Double value from 'Hello': " + toDoubleLength.applyAsDouble("Hello"));

        System.out.println("\n=== DoubleFunction ===");
        DoubleFunction<String> doubleToString = d -> "Formatted Double: " + String.format("%.2f", d);
        System.out.println(doubleToString.apply(42.3456));

        System.out.println("\n=== Stream Example using Supplier, Consumer, Predicate, Function ===");
        List<String> names = Arrays.asList("Alice", "Bob", "Ankit", "Ravi", "Aman");

        Supplier<Stream<String>> nameStreamSupplier = () -> names.stream();

        Predicate<String> startsWithA = name -> name.startsWith("A");
        Function<String, Integer> nameLength = name -> name.length();
        Consumer<Integer> printLength = len -> System.out.println("Name length: " + len);

        nameStreamSupplier.get()  // Supply stream
                          .filter(startsWithA)  // Predicate
                          .map(nameLength)      // Function
                          .forEach(printLength); // Consumer
    }
}
