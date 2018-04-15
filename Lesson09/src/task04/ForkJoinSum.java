package task04;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSum extends RecursiveTask<Integer> {

    private int limit;
    private int[] array;

    ForkJoinSum(int[] array, int limit) {
        this.limit = limit;
        this.array = array;
    }

    @Override
    protected Integer compute() {
        if(array.length < limit) {
            int result = 0;
            for(int i = 0; i < array.length; i++) {
                result += array[i];
            }
            return result;
        } else {
            int mid = array.length / 2;
            ForkJoinSum s1 = new ForkJoinSum(Arrays.copyOfRange(array, 0, mid), limit);
            s1.fork();
            ForkJoinSum s2 = new ForkJoinSum(Arrays.copyOfRange(array, mid, array.length), limit);
            return s1.join() + s2.compute();
        }
    }
}
