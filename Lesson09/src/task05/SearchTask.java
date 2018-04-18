package task05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchTask implements Runnable {
    private BlockingQueue<File> que;
    private String word;
    private Pattern p = Pattern.compile("[\\w\\-']+");
    private Matcher m;
    int wordsCount = 0;

    SearchTask(BlockingQueue<File> que, String word) {
        this.que = que;
        this.word = word;
    }

    void search(File ff) throws IOException {
        Scanner sc = new Scanner(new FileInputStream(ff));

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            m = p.matcher(str);
            while(m.find()) {
                if(m.group().startsWith(word)) {
                    wordsCount++;
                }
            }
        }
        sc.close();
        System.out.println(ff + ": " + wordsCount);
    }

    public void run() {
        try {
            while (true) {
                File ff = que.take();
                if (ff == FileRunTask.EXIT) {
                    que.put(ff);
                    break;
                } else search(ff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
        }
    }
}