package redblacktree;

import java.util.Arrays;

public class Runner {

    public void run() {

        int[] values = generateArray(9);

        buildTree(values);

        System.out.println();

        Arrays.sort(values);

        buildTree(values);
    }

    private void buildTree(int[] values) {
        Tree tree = new Tree();

        for(int value : values) {
            tree.insert(value);
        }

        System.out.println(Arrays.toString(values));

        tree.print();
    }

    private int[] generateArray(int size) {
        int[] result = new int[size];

        for(int i = 0; i < size; i++) {
            result[i] = (int)(Math.random()*100);
        }
        return result;
    }
}
