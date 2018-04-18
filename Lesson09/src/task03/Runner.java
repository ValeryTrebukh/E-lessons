package task03;

import java.util.AbstractMap;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class Runner {
    private AbstractMap<Integer, String> map;
    private Runnable sw, sr, cw, cr;
    private final int NUM_THREADS = 4;
    private final int MAP_SIZE = 4_000_000;

    {
         sw = () -> {
             int i = 0;
             synchronized (this) {
                 while (i < MAP_SIZE) {
                     map.put(i++, Thread.currentThread().getName());
                 }
             }
        };

        sr = () -> {
            int i = 0;
            synchronized (this) {
                while (i < MAP_SIZE) {
                    map.get(i++);
                }
                map.clear();
            }
        };

        cw = () -> {
            int i = 0;
            while (i < MAP_SIZE) {
                map.put(i++, Thread.currentThread().getName());
            }
        };

        cr = () -> {
            int i = 0;
            while (i < MAP_SIZE) {
                map.get(i++);
            }
            map.clear();
        };
    }


    void run() throws InterruptedException {

        map = new HashMap<>(1000, 0.8f);
        Long s1;

        s1 = new Date().getTime();
        startThreads(sw);
        System.out.println("synchronized write time: " + (new Date().getTime() - s1));

        s1 = new Date().getTime();
        startThreads(sr);
        System.out.println("synchronized read time: " + (new Date().getTime() - s1));


        map = new ConcurrentHashMap<>(1000, 0.8f);

        s1 = new Date().getTime();
        startThreads(cw);
        System.out.println("concurrent write time: " + (new Date().getTime() - s1));

        s1 = new Date().getTime();
        startThreads(cr);
        System.out.println("concurrent read time: " + (new Date().getTime() - s1));

    }


    private void startThreads(Runnable runnable) {
        Thread[] threads = new Thread[NUM_THREADS];
        for(int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        for(int i = 0; i < NUM_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
