package task03;

import java.util.AbstractMap;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

class Runner {
    private AbstractMap<Integer, String> map;
    private Runnable sw, sr, cw, cr;
    private final int NUM_THREADS = 16;
    private final int MAP_SIZE = 5_000_000;
    private AtomicLong syncWriteTime = new AtomicLong();
    private AtomicLong syncReadTime = new AtomicLong();
    private AtomicLong concWriteTime = new AtomicLong();
    private AtomicLong concReadTime = new AtomicLong();

    {
         sw = () -> {
             int i = 0;
             long t;
             long threadTime = 0;
             while (i++ < MAP_SIZE) {
                 t = new Date().getTime();
                 synchronized (this) {
                     map.put(i, Thread.currentThread().getName());
                 }
                 threadTime += new Date().getTime() - t;
             }
             syncWriteTime.addAndGet(threadTime);
        };

        sr = () -> {
            int i = 0;
            long t;
            long threadTime = 0;
            while (i++ < MAP_SIZE) {
                t = new Date().getTime();
                synchronized (this) {
                    map.get(i);

                }
                threadTime += new Date().getTime() - t;
            }
            syncReadTime.addAndGet(threadTime);
        };

        cw = () -> {
            int i = 0;
            long t;
            long threadTime = 0;
            while (i++ < MAP_SIZE) {
                t = new Date().getTime();
                map.put(i, Thread.currentThread().getName());
                threadTime += new Date().getTime() - t;
            }
            concWriteTime.addAndGet(threadTime);
        };

        cr = () -> {
            int i = 0;
            long t;
            long threadTime = 0;
            while (i++ < MAP_SIZE) {
                t = new Date().getTime();
                map.get(i);
                threadTime += new Date().getTime() - t;
            }
            concReadTime.addAndGet(threadTime);
        };
    }


    void run() throws InterruptedException {
        long t;
        System.out.println("Map size: " + MAP_SIZE + ". Threads number: " + NUM_THREADS);
        System.out.println();

        map = new HashMap<>(1000, 0.8f);
        t = new Date().getTime();
        startThreads(sw);
        System.out.println("main\tsynchronized write time:\t" + (new Date().getTime() - t));
        System.out.println("thread\tsynchronized write time:\t" + syncWriteTime.get()/NUM_THREADS);
        t = new Date().getTime();
        startThreads(sr);
        System.out.println("main\tsynchronized read  time:\t" + (new Date().getTime() - t));
        System.out.println("thread\tsynchronized read  time:\t" + syncReadTime.get()/NUM_THREADS);
        System.out.println();

        map = new ConcurrentHashMap<>(1000, 0.8f);
        t = new Date().getTime();
        startThreads(cw);
        System.out.println("main\tconcurrent write time:\t" + (new Date().getTime() - t));
        System.out.println("thread\tconcurrent write time:\t" + concWriteTime.get()/NUM_THREADS);
        t = new Date().getTime();
        startThreads(cr);
        System.out.println("main\tconcurrent read  time:\t" + (new Date().getTime() - t));
        System.out.println("thread\tconcurrent read  time:\t" + concReadTime.get()/NUM_THREADS);

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
