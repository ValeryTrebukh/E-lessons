package redblacktree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Node root;

    public void insert(int val) {

        Node node = new Node(val);

        root = insert(root, node);

        reorder(node);
    }

    private Node insert(Node root, Node node) {

        if(root == null) {
            return node;
        }

        if(node.value < root.value) {
            root.left = insert(root.left, node);
            root.left.parent = root;
        }

        if(node.value > root.value) {
            root.right = insert(root.right, node);
            root.right.parent = root;
        }
        return root;
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

        List<Node> list = new ArrayList<>();
        list.add(root);

        while(!list.isEmpty()) {

            Node cur = list.get(0);

            if(cur.left != null) {

                list.add(cur.left);
            }

            if(cur.right != null) {
                list.add(cur.right);
            }
            System.out.println(cur.toString());

            list.remove(cur);
        }
    }
}
