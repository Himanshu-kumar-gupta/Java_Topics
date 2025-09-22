import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

class PrintTask extends RecursiveAction {
    private static final int THRESHOLD = 5; // max elements before splitting
    private final int[] arr;
    private final int start;
    private final int end;

    public PrintTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            // Base case: print directly
            for (int i = start; i < end; i++) {
                System.out.printf("Thread %s printing arr[%d] = %d%n",
                        Thread.currentThread().getName(), i, arr[i]);
            }
        } else {
            // Split into two subtasks
            int mid = start + length / 2;
            PrintTask left = new PrintTask(arr, start, mid);
            PrintTask right = new PrintTask(arr, mid, end);

            invokeAll(left, right); // fork both and wait for them
        }
    }
}

public class ForkJoinRecursiveAction1 {
    public static void main(String[] args) {
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1; // fill array [1..15]
        }

        ForkJoinPool pool = new ForkJoinPool();
        PrintTask task = new PrintTask(arr, 0, arr.length);

        pool.invoke(task); // no return value
    }
}
