package redblacktree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Node root;

    private List<StringBuilder> printedTree = new ArrayList<>();

    public void insert(int val) {

        Node node = new Node(val);

        root = insert(root, node);

        reorder(node);
    }

    private Node insert(Node parent, Node node) {

        if(parent == null) {
            return node;
        }

        if(node.value < parent.value) {
            parent.left = insert(parent.left, node);
            parent.left.parent = parent;
        }
        else if(node.value > parent.value) {
            parent.right = insert(parent.right, node);
            parent.right.parent = parent;
        }
        else {
            node.isBlack = true;
        }

        return parent;
    }

    private void reorder(Node node) {

        Node p = null;
        Node g = null;

        while((node != root) && !node.isBlack && !node.parent.isBlack) {

            p = node.parent;
            g = node.parent.parent;

            if(p == g.left) {
                Node u = g.right;

                if(u != null && !u.isBlack) {
                    g.isBlack = false;
                    p.isBlack = true;
                    u.isBlack = true;
                    node = g;
                } else {
                    if(node == p.right) {
                        rotateLeft(p);
                        node = p;
                        p = node.parent;
                    }

                    rotateRight(g);

                    boolean b = p.isBlack;
                    p.isBlack = g.isBlack;
                    g.isBlack = b;

                    node = p;
                }
            } else {
                Node u = g.left;

                if(u != null && !u.isBlack) {
                    g.isBlack = false;
                    p.isBlack = true;
                    u.isBlack = true;
                    node = g;
                } else {
                    if(node == p.left) {
                        rotateRight(p);
                        node = p;
                        p = node.parent;
                    }

                    rotateLeft(g);

                    boolean b = p.isBlack;
                    p.isBlack = g.isBlack;
                    g.isBlack = b;

                    node = p;
                }
            }
        }
        root.isBlack = true;
    }

    private void rotateLeft(Node node) {

        Node pt = node.right;
        node.right = pt.left;

        if(node.right != null) {
            node.right.parent = node;
        }

        pt.parent = node.parent;

        if(node.parent == null) {
            root = pt;
        } else if(node == node.parent.left) {
            node.parent.left = pt;
        } else {
            node.parent.right = pt;
        }

        pt.left = node;
        node.parent = pt;
    }

    private void rotateRight(Node node) {

        Node pt = node.left;

        node.left = pt.right;

        if(node.left != null) {
            node.left.parent = node;
        }

        pt.parent = node.parent;

        if(node.parent == null) {
            root = pt;
        } else if(node == node.parent.left) {
            node.parent.left = pt;
        } else {
            node.parent.right = pt;
        }

        pt.right = node;

        node.parent = pt;

    }

    public void print() {

        if(root == null) {
            return;
        }

        int height = getHeight(root);

        for(int i = 0; i < height; i++) {
            printedTree.add(new StringBuilder());
        }

        printSubTree(root, height);

        for(int i = height - 1; i >= 0; i--) {
            System.out.println(printedTree.get(i).toString());
        }
    }

    private void printSubTree(Node node, int height) {

        if(height == 0) {
            return;
        }
        int indents = ((int)Math.pow(2, height) - 2) / 2;

        printedTree.get(height - 1)
                .append(printIndent(indents))
                .append(printValue(node))
                .append(printIndent(indents + 1));


        if(node.left != null) {
            printSubTree(node.left, height - 1);
        } else {
            for(int i = height - 2; i >= 0; i--) {
                printedTree.get(i).append(printIndent(indents + 1));
            }
        }

        if(node.right != null) {
            printSubTree(node.right, height - 1);
        } else {
            for(int i = height - 2; i >= 0; i--) {
                printedTree.get(i).append(printIndent(indents + 1));
            }
        }
    }

    private String printValue(Node node) {
        if(node.value < 10) {
            return " " + node.value + (node.isBlack ? "b" : "r");
        } else {
            return "" + node.value + (node.isBlack ? "b" : "r");
        }
    }

    private String printIndent(int indents) {
        String indent = "   ";

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < indents; i++) {
            sb.append(indent);
        }
        return sb.toString();
    }

    private int temp = 1;
    private int treeHeight = 1;

    private int getHeight(Node node) {

        if(root == null) {
            temp = 0;
            treeHeight = 0;
        }

        if(node.right != null) {
            if(++temp > treeHeight) {
                treeHeight = temp;
            }
            getHeight(node.right);
            temp--;
        }

        if(node.left != null) {
            if(++temp > treeHeight) {
                treeHeight = temp;
            }
            getHeight(node.left);
            temp--;
        }
        return treeHeight;
    }


}
