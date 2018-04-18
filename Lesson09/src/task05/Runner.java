package task05;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Runner {

    void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter directory -> ");
        String dir = sc.next();
        System.out.print("Enter symbol -> ");
        String smb = sc.next();

        BlockingQueue<File> que = new ArrayBlockingQueue<>(10);
        FileRunTask running = new FileRunTask(que, new File(dir));
        new Thread(running).start();
        for (int i=0; i<50; i++)
            new Thread(new SearchTask(que, smb)).start();
    }
}
