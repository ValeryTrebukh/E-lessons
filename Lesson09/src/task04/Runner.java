package task04;

import java.util.concurrent.ForkJoinPool;

class Runner {

    private int ARRAY_SIZE = 1_000_000;
    private int THREADS_NUMBER = 8;
    private int LIMIT = 20;

    void run() {
        int[] arr = generateByteArray(ARRAY_SIZE);

        ForkJoinPool pool = new ForkJoinPool(THREADS_NUMBER);
        int sum = pool.invoke(new ForkJoinSum(arr, LIMIT));

        System.out.println(sum);
    }

    private int[] generateByteArray(int size) {
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = (byte)(Math.random()*100);
        }
        return arr;
    }
}
