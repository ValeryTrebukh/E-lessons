package task05.callable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CallableSearch implements Callable<Map<File, Integer>> {

    private File baseDir;
    private String symbol;
    Map<File, Integer> map = new HashMap<>();

    public CallableSearch(File baseDir, String symbol) {
        this.baseDir = baseDir;
        this.symbol = symbol;
    }

    @Override
    public Map<File, Integer> call() throws Exception {
        List<Future<Map<File, Integer>>> results = new ArrayList<>();
        for (File f : baseDir.listFiles()) {
            if (f.isDirectory()) {
                CallableSearch cs = new CallableSearch(f, symbol);
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
