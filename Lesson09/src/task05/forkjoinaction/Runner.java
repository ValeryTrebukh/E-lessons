package task05.forkjoinaction;

import task05.utils.Helper;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

class Runner {

    private int THREADS_NUMBER = 4;

    public void run() {
/*        File baseDir = Helper.getDirectory();
        String smb = Helper.getSymbol();
        File destFile = Helper.getFile();*/

        File baseDir = new File("/home/john/work/java/epam/src/project02");
        String smb = "p";
        File destFile = new File("/home/john/work/java/testfiles/results");

        ForkJoinPool pool = new ForkJoinPool(THREADS_NUMBER);
        pool.invoke(new ForkJoinSearch(baseDir, smb, destFile));
    }

}
