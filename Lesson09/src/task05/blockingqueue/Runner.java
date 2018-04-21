package task05.blockingqueue;

import task05.utils.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

class Runner {

    void run() {
        File baseDir = Helper.getDirectory();
        String smb = Helper.getSymbol();
        File destFile = Helper.getFile();
        ConcurrentMap<File, Integer> set = new ConcurrentHashMap<>();

        BlockingQueue<File> que = new ArrayBlockingQueue<>(10);
        FileRunTask running = new FileRunTask(que, baseDir);
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
        lines.add("Looking for words staring from '" + smb + "' into folder: " + baseDir.getName());
        for(Map.Entry<File, Integer> entry : set.entrySet()) {
            lines.add(baseDir.toPath().relativize(entry.getKey().toPath()).toString() + ": "  + entry.getValue());
        }
        try {
            Files.write(destFile.toPath(), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
