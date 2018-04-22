package task05.executorservice;

import task05.utils.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

class Runner {
    void run() {
        File baseDir = Helper.getDirectory();
        String smb = Helper.getSymbol();
        File destFile = Helper.getFile();

        ExecutorService pool = Executors.newCachedThreadPool();

        Esearch es = new Esearch(baseDir, smb, pool);
        Future<Map<File, Integer>> results = pool.submit(es);

        try {
            List<String> lines = new ArrayList<>();
            lines.add("Looking for words staring from '" + smb + "' into folder: " + baseDir.getAbsolutePath());
            for(Map.Entry<File, Integer> entry : results.get().entrySet()) {
                lines.add(baseDir.toPath().relativize(entry.getKey().toPath()).toString() + ": "  + entry.getValue());
            }
            Collections.sort(lines);
            Files.write(destFile.toPath(), lines);
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }

        pool.shutdown();
        System.out.println(((ThreadPoolExecutor)pool).getLargestPoolSize());
    }
}
