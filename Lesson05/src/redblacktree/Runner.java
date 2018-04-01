package redblacktree;

import java.util.Arrays;

public class Runner {

    public void run() {

        int[] values = generateArray(27);

        System.out.println("UNSORTED ARRAY");
        buildTree(values);

        System.out.println();
        System.out.println(" ---------------------------------------------------------------------------------------- ");
        System.out.println();

        Arrays.sort(values);

        System.out.println("SORTED ARRAY");
        buildTree(values);
    }

    private void buildTree(int[] values) {
        Tree tree = new Tree();

        for(int value : values) {
            tree.insert(value);
        }

        System.out.println(Arrays.toString(values));

        tree.print();

        System.out.println("\ndelete " + values[1]);

        tree.delete(values[1]);

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
