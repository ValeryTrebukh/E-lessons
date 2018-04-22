package task05.callable;

import task05.utils.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Runner {
    void run() {
        File baseDir = Helper.getDirectory();
        String smb = Helper.getSymbol();
        File destFile = Helper.getFile();

        CallableSearch cs = new CallableSearch(baseDir, smb);
        FutureTask<Map<File, Integer>> task = new FutureTask<>(cs);
        Thread t = new Thread(task);
        t.start();

        try {
            List<String> lines = new ArrayList<>();
            lines.add("Looking for words staring from '" + smb + "' into folder: " + baseDir.getAbsolutePath());
            for(Map.Entry<File, Integer> entry : task.get().entrySet()) {
                lines.add(baseDir.toPath().relativize(entry.getKey().toPath()).toString() + ": "  + entry.getValue());
            }
            Collections.sort(lines);
            Files.write(destFile.toPath(), lines);
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }
    }
}
