package task05.forkjoinaction;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.concurrent.RecursiveAction;

class ForkJoinSearch extends RecursiveAction {

    private File baseDir;
    private String symbol;
    private File destFile;

    ForkJoinSearch(File baseDir, String symbol, File destFile) {
        this.baseDir = baseDir;
        this.symbol = symbol;
        this.destFile = destFile;
    }

    @Override
    protected void compute() {
        List<ForkJoinSearch> list = new ArrayList<>();
        for (File f : baseDir.listFiles()) {
            if (f.isDirectory()) {
                list.add(new ForkJoinSearch(f, symbol, destFile));
            }
            else {
                parseFile(f);
            }
        }
        invokeAll(list);
    }

    private void parseFile(File f) {
        Pattern p = Pattern.compile("[\\w\\-']+");
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream(f));
            Matcher m;
            int wordsCount = 0;
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                m = p.matcher(str);
                while(m.find()) {
                    if(m.group().startsWith(symbol)) {
                        wordsCount++;
                    }
                }
            }
            if(wordsCount > 0) {
                writeToFile(f.getName(), wordsCount);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  finally {
            if(sc!=null)
                sc.close();
        }
    }

    private void writeToFile(String s, int wordsCount) {
        try {
            synchronized (Lock.WRITE) {
                FileWriter fw = new FileWriter(destFile, true);
                fw.write(s + ": "  + wordsCount + "\n");
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}