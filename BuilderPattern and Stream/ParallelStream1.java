import java.util.*;
import java.util.stream.*;

public class ParallelStream1 {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 20)
                                         .boxed()
                                         .collect(Collectors.toList());

        System.out.println("Original List: " + numbers);

        // 1. Sequential stream sum
        int sequentialSum = numbers.stream()
                                   .reduce(0, Integer::sum);
        System.out.println("Sequential Sum = " + sequentialSum);

        // 2. Parallel stream sum
        int parallelSum = numbers.parallelStream()
                                 .reduce(0, Integer::sum);
        System.out.println("Parallel Sum = " + parallelSum);

        // 3. forEach (parallel execution - order not guaranteed)
        System.out.println("\nParallel forEach (order may vary):");
        numbers.parallelStream()
               .forEach(n -> System.out.println("Thread " +
                   Thread.currentThread().getName() + " processed " + n));

        // 4. forEachOrdered (parallel but preserves encounter order)
        System.out.println("\nParallel forEachOrdered (order preserved):");
        numbers.parallelStream()
               .forEachOrdered(n -> System.out.println("Processed " + n));

        // 5. Filtering and mapping in parallel
        System.out.println("\nFilter & Map in parallel:");
        List<Integer> squares = numbers.stream()
                                       .filter(n -> n % 2 == 0)   // keep evens
                                       .map(n -> n * n)           // square
                                       .parallel()             //can also be used like this
                                       .collect(Collectors.toList());
        System.out.println("Squares of even numbers = " + squares);

        // 6. Parallel stream with findAny (non-deterministic result)
        System.out.println("\nfindAny result from parallel stream: " +
            numbers.parallelStream().findAny().get());

        // 7. Performance difference demo (with large dataset)
        List<Integer> bigList = IntStream.rangeClosed(1, 1_000_000)
                                         .boxed()
                                         .collect(Collectors.toList());

        long start = System.currentTimeMillis();
        long sequentialCount = bigList.stream()
                                      .filter(n -> n % 2 == 0)
                                      .count();
        long end = System.currentTimeMillis();
        System.out.println("\nSequential count of evens = " + sequentialCount +
                           " (Time: " + (end - start) + " ms)");

        start = System.currentTimeMillis();
        long parallelCount = bigList.parallelStream()
                                    .filter(n -> n % 2 == 0)
                                    .count();
        end = System.currentTimeMillis();
        System.out.println("Parallel count of evens = " + parallelCount +
                           " (Time: " + (end - start) + " ms)");
        
        //Sometimes parallel can take more time, cost of thread coordination overshadows the benefit of parallelism
    }
}
