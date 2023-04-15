package src.main.java.mylib.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

import src.main.java.mylib.datastructures.nodes.TreeNode;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int val) {
        root = new TreeNode(val, 0, null, null, null);
    }

    public BinarySearchTree(TreeNode node) {
        root = node;
    }

    public void setRoot(TreeNode node) {
        root = node;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void Insert(int value) {
        TreeNode node = new TreeNode(value, 0, null, null, null);
        Insert(node, root);
    }
    public void Insert(TreeNode node) {
        Insert(node, root);
    }

    public TreeNode Insert(TreeNode node, TreeNode parent) {
        if (parent == null) {
            parent = node;
        }
        else if (node.getData() <= parent.getData()) {
            parent.setLeft(Insert(parent.getLeft(), node));
        }
        else if (node.getData() > parent.getData()) {
            parent.setRight(Insert(parent.getLeft(), node));
        }
        return parent;                                                          
    }

    public void Delete(int value) {
        TreeNode toDel = Search(value);
        TreeNode replace = toDel;
        if (toDel.getRight() == null) {
            if (toDel.getLeft() == null) {
                toDel = null;
            }
            else {
                while (replace.getLeft() != null) {
                    replace = replace.getLeft();
                }
            }
        }
    }

    public TreeNode Delete(int value, TreeNode parent) {
        if (parent == null) {
            return null;
        }
        else if (value < parent.getData()) {
            parent.setLeft(Delete(value, parent.getLeft()));
        }
        else if (value > parent.getData()) {
            parent.setRight(Delete(value, parent.getRight()));
        }

        else {
            if (parent.getLeft() == null) {
                return parent.getRight();
            }
            else if (parent.getRight() == null) {
                return parent.getLeft();
            }
            parent.setData(value);
            Delete(parent.getData());
        }
        return parent;
    }
 
    public TreeNode Search(int value, TreeNode node) {
        if (node.getData() == value || node == null) {
            return node;
        }
        else if (value < node.getData()) {
            return Search(value, node.getLeft());
        }
        else {
            return Search(value, node.getRight());
        }
    }

    public TreeNode Search(int value) {
        TreeNode searcher = root;
        if (searcher.getData() == value || searcher == null) {
            return searcher;
        }
        else if (value < searcher.getData()) {
            return Search(value, searcher.getLeft());
        }
        else {
            return Search(value, searcher.getRight());
        }
    }

    public void printInOrder() {
        TreeNode parent = root;
        if (parent == null) {
            return;
        }
    }
    public void traverseInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.getLeft());
        System.out.printf("%s ", node.getData());
        traverseInOrder(node.getRight());
    }
    
    public void printBF() {
        System.out.println(root.getData());
        if (root == null) {
            return;
        }
        
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        
        while (!currentLevel.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            
            for (TreeNode node : currentLevel) {
                System.out.print(node.getData() + " ");
    
                if (node.getLeft() != null) {
                    nextLevel.add(node.getLeft());
                }
                
                if (node.getRight() != null) {
                    nextLevel.add(node.getRight());
                }
            }
            
            System.out.println();
            currentLevel = nextLevel;
        }
    }
}
