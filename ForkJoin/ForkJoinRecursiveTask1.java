import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

// RecursiveTask returns a value
class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 5; // max elements before splitting
    private final int[] arr;
    private final int start;
    private final int end;

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            // base case: directly compute
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            System.out.printf("Computed sum of [%d..%d) directly: %d%n", start, end, sum);
            return sum;
        } else {
            // split task
            int mid = start + length / 2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);

            left.fork(); // async compute left
            long rightResult = right.compute(); // directly compute right
            long leftResult = left.join(); // wait for left

            long total = leftResult + rightResult;
            System.out.printf("Combined sum of [%d..%d) = %d%n", start, end, total);
            return total;
        }
    }
}

public class ForkJoinRecursiveTask1 {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1; // fill array [1..20]
        }

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(arr, 0, arr.length);

        long result = pool.invoke(task);

        System.out.println("Final Result = " + result);
    }
}
