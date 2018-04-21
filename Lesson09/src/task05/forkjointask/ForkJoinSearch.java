package task05.forkjointask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ForkJoinSearch extends RecursiveTask<Map<File, Integer>> {

    private File baseDir;
    private String symbol;

    ForkJoinSearch(File baseDir, String symbol) {
        this.baseDir = baseDir;
        this.symbol = symbol;
    }

    @Override
    protected Map<File, Integer> compute() {
        List<ForkJoinSearch> list = new ArrayList<>();
        Map<File, Integer> map = new HashMap<>();
        for (File f : baseDir.listFiles()) {
            if (f.isDirectory()) {
                list.add(new ForkJoinSearch(f, symbol));
            }
            else {
                int wordsCount = getWordsCount(f);
                if(wordsCount > 0) {
                    map.put(f, wordsCount);
                }
            }
        }
        invokeAll(list);
        for(ForkJoinSearch fjs : list) {
            map.putAll(fjs.join());
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
