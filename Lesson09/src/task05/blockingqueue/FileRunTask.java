package task05.blockingqueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

class FileRunTask implements Runnable {
    private BlockingQueue<File> queue;
    private File startDir;
    static File EXIT = new File("");

    FileRunTask(BlockingQueue <File> queue, File startDir) {
        this.queue = queue;
        this.startDir = startDir;
    }

    @Override
    public void run() {
        try {
            runDir(startDir);
            queue.put(EXIT);
        } catch (InterruptedException ignore) { }
    }

    private void runDir(File dir) throws InterruptedException {
        File[] files = dir.listFiles();
        for (File ff: files)
            if (ff.isDirectory())
                runDir(ff);
            else
                queue.put(ff);
    }
}
