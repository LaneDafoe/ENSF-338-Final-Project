package src.main.java.mylib.datastructures.nodes;

public class TreeNode {
    private TreeNode parent;
    private int data;
    private TreeNode left;
    private TreeNode right;
    private int balance;

    public TreeNode(int v, int b, TreeNode p, TreeNode l, TreeNode r) {
        this.data = v;
        this.balance = b;
        this.parent = p;
        this.left = l;
        this.right = r;
    }

// getters
    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode getParent() {
        return parent;
    }

    public int getBalance() {
        return balance;
    }

// setters
    public void setData(int v) {
        this.data = v;
    }

    public void setLeft(TreeNode l) {
        this.left = l;
    }

    public void setRight(TreeNode r) {
        this.right = r;
    }

    public void setParent(TreeNode p) {
        this.parent = p;
    }

    public void setBalance(int b) {
        this.balance = b;
    }

    public void Print() {
        System.out.print(toString());
    }

    public String toString() {
        String output = "The value at the node is " + Integer.toString(data) + "\n";

        if (parent == null) {output = output + "The node has no parent \n";}
        else {output = output + "The node has a parent with value " + Integer.toString(parent.getData()) + "\n";}

        if (left == null) {output = output + "The node has no left child \n";}
        else {output = output + "The node has a left child with value " + Integer.toString(left.getData()) + "\n";}

        if (right == null) {output = output + "The node has no right child \n";}
        else {output = output + "The node has a right child with value " + Integer.toString(right.getData()) + "\n";}

        return output;
    }
}
