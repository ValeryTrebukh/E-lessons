package task03;

import java.util.AbstractMap;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class Runner {
    private AbstractMap<Integer, String> map;
    private Runnable sw, sr, cw, cr;
    private final int NUM_THREADS = 8;
    private final int MAP_SIZE = 2_000_000;

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

        map = new HashMap<>();
        Long s1;

        s1 = new Date().getTime();
        syncWrite(sw);
        System.out.println("synchronized write time: " + (new Date().getTime() - s1));

        s1 = new Date().getTime();
        syncRead(sr);
        System.out.println("synchronized read time: " + (new Date().getTime() - s1));


        map = new ConcurrentHashMap<>();
        Thread.sleep(100);

        s1 = new Date().getTime();
        syncWrite(cw);
        System.out.println("concurrent write time: " + (new Date().getTime() - s1));

        s1 = new Date().getTime();
        syncRead(cr);
        System.out.println("concurrent read time: " + (new Date().getTime() - s1));

    }

    private void syncWrite(Runnable runnable) throws InterruptedException {
        startThreads(runnable);
        while(map.size() < MAP_SIZE) {
            Thread.sleep(1);
        }
    }

    private void syncRead(Runnable runnable) throws InterruptedException {
        startThreads(runnable);
        while(!map.isEmpty()) {
            Thread.sleep(1);
        }
    }

    private void startThreads(Runnable runnable) {
        for(int i = 0; i < NUM_THREADS; i++) {
            new Thread(runnable).start();
        }
    }
}
