package redblacktree;

public class Node {

    Node parent, left, right;
    boolean isBlack;
    int value;

    public Node(int value) {
        this.value = value;
        isBlack = false;
        left = null;
        right = null;
        parent = null;
    }

    @Override
    public String toString() {
        String l = left==null ? "NULL" : "" + left.value;
        String r = right==null ? "NULL" : "" + right.value;
        String c = isBlack ? "b" : "r";

        return l + "<--" + value + c + "-->" + r;
    }
}
