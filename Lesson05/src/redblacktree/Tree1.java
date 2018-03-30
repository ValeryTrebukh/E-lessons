package redblacktree;

import java.util.ArrayList;
import java.util.List;

public class Tree1 {

    Node root = null;

    public Tree1 insert(Node node) {
        if(root == null) {
            root = node;
            node.isBlack = true;
        } else {
            insertChild(getRoot(), node);

        }
        return this;
    }

    void insertChild(Node head, Node target) {

        if (target.value > head.value) {
            if(head.right == null) {
                head.right = target;
                target.parent = head;
            } else {
                insertChild(head.right, target);
            }
        } else if (target.value < head.value) {
            if(head.left == null) {
                head.left = target;
                target.parent = head;
            } else {
                insertChild(head.left, target);
            }
        }
        insertCase1(target);
    }

    public void insertCase1(Node node) {
        if(node.parent == null) {
            node.isBlack = true;
//            root = node;
        } else {
            insertCase2(node);
        }
    }

    private void insertCase2(Node node) {
        if(!node.parent.isBlack) {
            insertCase3(node);
        }
    }

    private void insertCase3(Node node) {

        Node uncle = getUncle(node);
        Node grand;

        if((uncle != null) && (!uncle.isBlack)) {
            node.parent.isBlack = true;
            uncle.isBlack = true;
            grand = getGrandParent(node);
            grand.isBlack = false;
            insertCase1(node);
        } else {
            insertCase4(node);
        }
    }

    private void insertCase4(Node node) {
        Node grand = getGrandParent(node);

        if((node == node.parent.right) && (node.parent == grand.left)) {
            rotateLeft(node.parent);
            node = node.left;
        } else if ((node == node.parent.left) && node.parent == grand.right) {
            rotateRight(node.parent);
            node = node.right;
        }
        insertCase5(node);
    }

    private void insertCase5(Node node) {
        Node grand = getGrandParent(node);

        node.parent.isBlack = true;
        grand.isBlack = false;

        if ((node == node.parent.left) && (node.parent == grand.left)) {
            rotateRight(grand);
        } else {
            rotateLeft(grand);
        }
    }


    private Node getGrandParent(Node node) {
        if((node != null) && (node.parent != null)) {
            return node.parent.parent;
        } else {
            return null;
        }
    }

    private Node getUncle(Node node) {

        Node grand = getGrandParent(node);

        if(grand == null) {
            return null;
        } if(node.parent == grand.left) {
            return grand.right;
        } else {
            return grand.left;
        }
    }

    private void rotateLeft(Node node) {
        Node current = node.right;
        current.parent = node.parent;

        if(node.parent != null) {
            if(node.parent.left == node) {
                node.parent.left = current;
            } else {
                node.parent.right = current;
            }
        }

        node.right = current.left;

        if(current.left != null) {
            current.left.parent = node;
        }

        node.parent = current;
        current.left = node;
    }

    private void rotateRight(Node node) {
        Node current = node.left;
        current.parent = node.parent;

        if(node.parent != null) {
            if(node.parent.left == node) {
                node.parent.left = current;
            } else {
                node.parent.right = current;
            }
        }

        node.left = current.right;

        if(current.right != null) {
            current.right.parent = node;
        }

        node.parent = current;
        current.right = node;
    }


    public void print() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        Node current;

        while(!nodes.isEmpty()) {

            int size = nodes.size();

            for(int i = 0; i < size; size--) {

                current = nodes.get(0);
                if(current.left != null) {
                    nodes.add(current.left);
                }

                if(current.right != null) {
                    nodes.add(current.right);
                }

                System.out.print(current.toString() + " ");
                nodes.remove(current);
            }
            System.out.println();
        }
    }

    private Node getRoot() {
        while(root.parent!=null) {
            root = root.parent;
        }
        return root;
    }
}
