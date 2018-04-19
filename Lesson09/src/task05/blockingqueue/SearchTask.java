package task05.blockingqueue;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchTask implements Runnable {
    private BlockingQueue<File> queue;
    private String word;
    private Pattern p = Pattern.compile("[\\w\\-']+");
    private ConcurrentMap<File, Integer> set;

    SearchTask(BlockingQueue<File> queue, String word, ConcurrentMap<File, Integer> set) {
        this.queue = queue;
        this.word = word;
        this.set = set;

    }

    private void search(File ff) throws IOException {
        Scanner sc = new Scanner(new FileInputStream(ff));
        Matcher m;
        int wordsCount = 0;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            m = p.matcher(str);
            while(m.find()) {
                if(m.group().startsWith(word)) {
                    wordsCount++;
                }
            }
        }
        if(wordsCount > 0) {
            set.put(ff, wordsCount);
        }
        sc.close();
    }

    @Override
    public void run() {
        try {
            while (true) {
                File ff = queue.take();
                if (ff == FileRunTask.EXIT) {
                    queue.put(ff);
                    break;
                } else search(ff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ignore) {}
    }

}

//  /home/john/work/java/epam/src/project02
//  /home/john/work/java/results