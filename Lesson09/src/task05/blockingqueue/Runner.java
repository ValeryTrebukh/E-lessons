package task05.blockingqueue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;

class Runner {

    void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter directory to lookup: ");
        String dir = sc.next();
        System.out.print("Enter symbol: ");
        String smb = sc.next();
        System.out.print("Enter destination file: ");
        String destinationFileName = sc.next();
        ConcurrentMap<File, Integer> set = new ConcurrentHashMap<>();


        BlockingQueue<File> que = new ArrayBlockingQueue<>(10);
        FileRunTask running = new FileRunTask(que, new File(dir));
        new Thread(running).start();

        Thread[] threads = new Thread[50];
        for (int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new SearchTask(que, smb, set));
            threads[i].start();
        }

        for (int i=0; i<threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<String> lines = new ArrayList<>();
        lines.add("Looking for words staring from '" + smb + "' into folder: " + dir);
        for(Map.Entry<File, Integer> entry : set.entrySet()) {
            lines.add(Paths.get(dir).relativize(entry.getKey().toPath()).toString() + ": "  + entry.getValue());
        }
        try {
            Files.write(Paths.get(destinationFileName), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
