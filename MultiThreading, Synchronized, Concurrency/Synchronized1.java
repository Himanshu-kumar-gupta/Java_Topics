// Shared counter class
class Counter {
    private int count = 0;

    // synchronized method
    public synchronized void increment() {
        count++;
    }

    // synchronized block
    public void decrement() {
        synchronized (this) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}

// Worker thread using Runnable
class Worker implements Runnable {
    //Instance variables shared in threading
    private Counter counter;

    public Worker(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
            counter.decrement();
        }
    }
}

public class Synchronized1 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Two threads working on the same counter
        Thread t1 = new Thread(new Worker(counter));
        Thread t2 = new Thread(new Worker(counter));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join(); // Main thread waits for both threads to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter.getCount());
    }
}

// Due to synchronization, Final result is consistent (0), even with thousands of increments/decrements.
//To see unsynchronized version remove synchronized keyword from method and remove sync. block