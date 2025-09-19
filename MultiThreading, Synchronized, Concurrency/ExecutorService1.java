import java.util.concurrent.*;

public class ExecutorService1 {
    public static void main(String[] args) {
        // 1. Create ExecutorService with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 2. Define Callable tasks
        Callable<String> task1 = () -> {
            Thread.sleep(1000); // simulate work
            return "Result from task1";
        };

        Callable<Integer> task2 = () -> {
            int sum = 0;
            for (int i = 1; i <= 5; i++) sum += i;
            return sum;
        };

        try {
            // 3. Submit tasks -> Future objects
            Future<String> future1 = executor.submit(task1);
            Future<Integer> future2 = executor.submit(task2);

            System.out.println("Main thread doing other work...");

            // 4. Retrieve results
            System.out.println("Task1 result: " + future1.get());
            System.out.println("Task2 result: " + future2.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 5. Shut down executor
            executor.shutdown(); // no new tasks accepted

            try {
                // 6. Wait for termination (max 5 seconds)
                if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    System.out.println("All tasks finished.");
                } else {
                    System.out.println("Timeout: Some tasks not finished.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}