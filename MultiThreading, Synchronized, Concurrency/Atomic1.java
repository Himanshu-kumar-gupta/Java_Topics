import java.util.concurrent.atomic.*;

public class Atomic1 {
    public static void main(String[] args) throws InterruptedException {
        
        // 1. AtomicInteger example
        AtomicInteger atomicInt = new AtomicInteger(0);

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                atomicInt.incrementAndGet(); // atomically increments by 1
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(incrementTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("AtomicInteger final value (expected 2000): " + atomicInt.get());

        // 2. AtomicBoolean example
        AtomicBoolean flag = new AtomicBoolean(false);

        if (flag.compareAndSet(false, true)) {
            System.out.println("Flag was false, now set to true");
        } else {
            System.out.println("Flag was already true");
        }

        // 3. AtomicLong example
        AtomicLong atomicLong = new AtomicLong(100);

        System.out.println("Initial AtomicLong: " + atomicLong.get());
        System.out.println("Add 50: " + atomicLong.addAndGet(50));
        System.out.println("Get and decrement: " + atomicLong.getAndDecrement());
        System.out.println("After decrement: " + atomicLong.get());

        // 4. AtomicReference example
        AtomicReference<String> atomicRef = new AtomicReference<>("Hello");
        System.out.println("Initial reference: " + atomicRef.get());

        atomicRef.set("World");
        System.out.println("After set: " + atomicRef.get());

        boolean updated = atomicRef.compareAndSet("World", "Atomic!");
        System.out.println("CompareAndSet Update successful: " + updated);
        System.out.println("Final reference: " + atomicRef.get());
    }
}