class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("From Thread class: " + i);
            try { Thread.sleep(5); } catch (InterruptedException e) {}
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("From Runnable interface: " + i);
            try { Thread.sleep(5); } catch (InterruptedException e) {}
        }
    }
}

public class ThreadRunnable1 {
    public static void main(String[] args) {
        // Using Thread class
        MyThread t1 = new MyThread();

        // Using Runnable interface
        Thread t2 = new Thread(new MyRunnable());

        // Start both threads
        t1.start();
        t2.start();

        // Main thread also
        for (int i = 1; i <= 5; i++) {
            System.out.println("From main thread: " + i);
            try { Thread.sleep(5); } catch (InterruptedException e) {}
        }
    }
}
