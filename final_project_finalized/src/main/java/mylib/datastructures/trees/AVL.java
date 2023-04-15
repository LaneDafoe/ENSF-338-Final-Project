package src.main.java.mylib.datastructures.trees;
import src.main.java.mylib.datastructures.nodes.TreeNode;

public class AVL extends BinarySearchTree {
    private TreeNode root;

    public AVL() {
        root = null;
    }

    public AVL(int val) {
        root = new TreeNode(val, 0, null, null, null);
    }

    public AVL(TreeNode obj) {
        root = obj;
        if (root.getLeft() != null || root.getRight() != null) {
            root = balance(root);
        }
    }

    private TreeNode balance(TreeNode node) {
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.getLeft()) > 0) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft())) ;
                node = rotateRight(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRight()) < 0) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }
        return node;
    }

    private int getBalanceFactor(TreeNode node) {
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return leftHeight - rightHeight;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private TreeNode rotateRight(TreeNode node) {
        TreeNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        return newRoot;
    }

    private TreeNode rotateLeft(TreeNode node) {
        TreeNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        return newRoot;
    }

    public void setRoot(TreeNode node) {
        root = node;
        if (root.getLeft() != null || root.getRight() != null) {
            root = balance(root);
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int val) {
        super.Insert(val);
        root = balance(root);
    }

    public void insert(TreeNode node) {
        super.Insert(node);
        root = balance(root);
    }

    public void delete(int val) {
        super.Delete(val);
        root = balance(root);
    }

    public TreeNode search(int val) {
        return super.Search(val);
    }

    public void printInOrder() {
        super.printInOrder();
    }

    public void printBF() {
        super.printBF();
    }
}