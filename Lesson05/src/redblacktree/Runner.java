package redblacktree;

public class Runner {

    public void run1() {
        Tree1 tree1 = new Tree1();

        tree1.insert(new Node(1))
            .insert(new Node(2))
            .insert(new Node(3));

        tree1.print();
    }

    public void run() {
        Tree tree = new Tree();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
//        tree.insert(5);

        tree.print();
    }
}
