package task05;

import java.io.File;
import java.util.concurrent.BlockingQueue;

class FileRunTask implements Runnable {
    private BlockingQueue<File> que;
    private File startDir;
    static File EXIT = new File("");

    FileRunTask(BlockingQueue <File> que, File startDir) {
        this.que = que;
        this.startDir = startDir;
    }
    public void run() {
        try {
            runDir(startDir);
            que.put(EXIT);
        } catch (InterruptedException ignore) { }
    }

    void runDir(File dir) throws InterruptedException {
        File[] files = dir.listFiles();
        for (File ff: files)
            if (ff.isDirectory())
                runDir(ff);
            else
                que.put(ff);
    }
}
