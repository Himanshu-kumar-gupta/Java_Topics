import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrier1 {
    public static void main(String[] args) {
        final int PARTIES = 3;
        Runnable barrierAction = () -> System.out.println("All threads reached barrier, proceeding...\n");
        
        // Barrier action will run once all threads reach the barrier
        CyclicBarrier barrier = new CyclicBarrier(PARTIES, barrierAction);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " working...");
                Thread.sleep((long) (Math.random() * 1000)); // simulate work
                System.out.println(Thread.currentThread().getName() + " waiting at barrier");
                barrier.await(); // wait for others
                System.out.println(Thread.currentThread().getName() + " continues after barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        // Start 3 threads
        for (int i = 1; i <= PARTIES; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}