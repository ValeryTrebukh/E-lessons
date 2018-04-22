package task05.executorservice;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Esearch implements Callable<Map<File, Integer>> {
    private File baseDir;
    private String symbol;
    private ExecutorService pool;
    Map<File, Integer> map = new HashMap<>();

    Esearch(File baseDir, String symbol, ExecutorService pool) {
        this.baseDir = baseDir;
        this.symbol = symbol;
        this.pool = pool;
    }

    @Override
    public Map<File, Integer> call() throws Exception {
        List<Future<Map<File, Integer>>> results = new ArrayList<>();
        for (File f : baseDir.listFiles()) {
            if (f.isDirectory()) {
                Esearch cs = new Esearch(f, symbol, pool);
                FutureTask<Map<File, Integer>> task = new FutureTask<>(cs);
                results.add(task);
                Thread t = new Thread(task);
                t.start();
            }
            else {
                int wordsCount = getWordsCount(f);
                if(wordsCount > 0) {
                    map.put(f, wordsCount);
                }
            }
        }

        for(Future<Map<File, Integer>> result : results) {
            map.putAll(result.get());
        }
        return map;
    }

    private int getWordsCount(File f) {
        Pattern p = Pattern.compile("[\\w\\-']+");
        Scanner sc = null;
        int wordsCount = 0;
        try {
            sc = new Scanner(new FileInputStream(f));
            Matcher m;
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                m = p.matcher(str);
                while(m.find()) {
                    if(m.group().startsWith(symbol)) {
                        wordsCount++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  finally {
            if(sc!=null)
                sc.close();
        }
        return wordsCount;
    }
}
