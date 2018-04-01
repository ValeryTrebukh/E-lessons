package redblacktree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Node root;

    private List<StringBuilder> printedTree;

    public void insert(int val) {

        Node node = new Node(val);

        root = insert(root, node);

        reorderInsert(node);
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

    private void reorderInsert(Node node) {

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

    public void delete(int value) {

        if(root != null) {
            delete(root, value);
        }
    }

    private void delete(Node node, int value) {

        if(value < node.value) {
            delete(node.left, value);
        }
        else if (value > node.value) {
            delete(node.right, value);
        }
        else {
            if(node.right != null && node.left != null) {
                node.value = subTreeMinValue(node.right);
                delete(node.right, node.value);
            }
            else {
                fixViolations(node);

                if(node == node.parent.left) {
                    node.parent.left = null;
                }
                else if(node == node.parent.right) {
                    node.parent.right = null;
                }
            }
        }
    }

    private int subTreeMinValue(Node node) {

        int min = node.value;

        while(node.left != null) {
            min = node.left.value;
            node = node.left;
        }

        return min;
    }

    private void fixViolations(Node node) {
                                      // if node is red - delete this node
        if(node.isBlack) {            // if node has red child - replace the node with child and change color to black
            if (node.left != null) {
                node.left.isBlack = true;
                node.left.parent = node.parent;

                if(node == node.parent.left) {
                    node.parent.left = node.left;
                }
                else if(node == node.parent.right) {
                    node.parent.right = node.left;
                }
            }
            else if (node.right != null) {
                node.right.isBlack = true;
                node.right.parent = node.parent;

                if(node == node.parent.left) {
                    node.parent.left = node.right;
                }
                else if(node == node.parent.right) {
                    node.parent.right = node.right;
                }
            }
            else {                    //children are null
                deleteCase1(node);
            }
        }
    }

    private void deleteCase1(Node node) {
        if(node.parent != null) {
            deleteCase2(node);
        } else {
            root = null;
        }
    }

    private void deleteCase2(Node node) {
        Node sibling = sibling(node);

        if(!sibling.isBlack) {
            node.parent.isBlack = false;
            sibling.isBlack = true;
            if(node == node.parent.left) {
                rotateLeft(node.parent);
            }
            else {
                rotateRight(node.parent);
            }
        }

        deleteCase3(node);
    }

    private void deleteCase3(Node node) {
        Node sibling = sibling(node);

        if(node.parent.isBlack && sibling.isBlack &&
                (sibling.left == null || sibling.left.isBlack) &&
                (sibling.right == null || sibling.right.isBlack)) {

            sibling.isBlack = false;

            deleteCase1(node.parent);
        }
        else {
            deleteCase4(node);
        }
    }

    private void deleteCase4(Node node) {
        Node sibling = sibling(node);

        if(!node.parent.isBlack && sibling.isBlack &&
                (sibling.left == null || sibling.left.isBlack) &&
                (sibling.right == null || sibling.right.isBlack)) {

            sibling.isBlack = false;
            node.parent.isBlack = true;
        }
        else {
            deleteCase5(node);
        }
    }

    private void deleteCase5(Node node) {
        Node sibling = sibling(node);

        if(sibling.isBlack) {
            if((node == node.parent.left) && (sibling.right == null || sibling.right.isBlack) &&
                    (sibling.left != null && !sibling.left.isBlack)) {

                sibling.isBlack = false;
                sibling.left.isBlack = true;
                rotateRight(sibling);
            }
            else if((node == node.parent.right) && (sibling.left == null || sibling.left.isBlack) &&
                    (sibling.right != null && !sibling.right.isBlack)) {

                sibling.isBlack = false;
                sibling.right.isBlack = true;
                rotateLeft(sibling);
            }
        }

        deleteCase6(node);
    }

    private void deleteCase6(Node node) {
        Node sibling = sibling(node);

        sibling.isBlack = node.parent.isBlack;
        node.parent.isBlack = true;

        if(node == node.parent.left) {
            sibling.right.isBlack = true;
            rotateLeft(node.parent);
        }
        else {
            sibling.left.isBlack = true;
            rotateRight(node.parent);
        }
    }

    private Node sibling(Node node) {
        return node.parent.left == node ? node.parent.right : node.parent.left;
    }


    public void print() {

        if(root == null) {
            return;
        }

        printedTree = new ArrayList<>();

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
            printEmptySubTree(height, indents);
        }

        if(node.right != null) {
            printSubTree(node.right, height - 1);
        } else {
            printEmptySubTree(height, indents);
        }
    }

    private void printEmptySubTree(int height, int indents) {
        for(int i = height - 2; i >= 0; i--) {
            printedTree.get(i).append(printIndent(indents + 1));
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