package task05.forkjointask;

import task05.utils.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

class Runner {

    private int THREADS_NUMBER = 8;

    public void run() {
        File baseDir = Helper.getDirectory();
        String smb = Helper.getSymbol();
        File destFile = Helper.getFile();

        ForkJoinPool pool = new ForkJoinPool(THREADS_NUMBER);
        ForkJoinSearch fjs = new ForkJoinSearch(baseDir, smb);
        pool.invoke(fjs);

        List<String> lines = new ArrayList<>();
        lines.add("Looking for words staring from '" + smb + "' into folder: " + baseDir.getAbsolutePath());
        for(Map.Entry<File, Integer> entry : fjs.join().entrySet()) {
            lines.add(baseDir.toPath().relativize(entry.getKey().toPath()).toString() + ": "  + entry.getValue());
        }
        try {
            Collections.sort(lines);
            Files.write(destFile.toPath(), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
