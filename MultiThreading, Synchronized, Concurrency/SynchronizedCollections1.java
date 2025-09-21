import java.util.*;
import java.util.concurrent.*;

public class SynchronizedCollections1 {
    public static void main(String[] args) throws InterruptedException {
        // Thread-safe collections
        ConcurrentMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();

        // Synchronized wrapper collections
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<>());

        // All above collections are synchronized
        
        Runnable concurrentTask = () -> {
            for (int i = 0; i < 5; i++) {
                concurrentMap.put(i, "Val-" + i);
                cowList.add(Thread.currentThread().getName() + "-item" + i);
            }
        };

        Runnable syncTask = () -> {
            for (int i = 0; i < 5; i++) {
                syncMap.put(i, "Sync-" + i);
                syncList.add(Thread.currentThread().getName() + "-item" + i);
            }
        };

        // Run both tasks in parallel
        Thread t1 = new Thread(concurrentTask, "C1");
        Thread t2 = new Thread(concurrentTask, "C2");
        Thread t3 = new Thread(syncTask, "S1");
        Thread t4 = new Thread(syncTask, "S2");

        t1.start(); t2.start(); t3.start(); t4.start();
        t1.join();  t2.join();  t3.join();  t4.join();

        // Iterating CopyOnWriteArrayList (safe without explicit sync)
        System.out.println("\nCopyOnWriteArrayList contents:");
        for (String s : cowList) {
            System.out.println(s);
        }

        // Iterating synchronized list 
        //needs manual sync for compound actions! (Iteration in Java uses an Iterator object, 
        //Internally, this calls Iterator.next().
        //While each next() call is synchronized, the entire iteration process is not atomic — another 
        //thread could modify the list in between hasNext() and next(), causing a ConcurrentModificationException.)
        System.out.println("\nSynchronizedList contents (inside synchronized block):");
        synchronized (syncList) {
            for (String s : syncList) {
                System.out.println(s);
            }
        }

        // Maps
        System.out.println("\nConcurrentHashMap contents: " + concurrentMap);
        synchronized (syncMap) {
            System.out.println("SynchronizedMap contents: " + syncMap);
        }
    }
}
