package src.main.java.mylib.datastructures.nodes;

public class DLLNode {
    private int value;
    private DLLNode next;
    private DLLNode prev;

    public DLLNode(int v) {
        this.value = v;
    }

// getters
    public int getValue() {
        return value;
    }

    public DLLNode getNext() {
        return next;
    }

    public DLLNode getPrev() {
        return prev;
    }

// setters
    public void setValue(int v) {
        this.value = v;
    }

    public void setNext(DLLNode n) {
        this.next = n;
    }

    public void setPrev(DLLNode p) {
        this.prev = p;
    }
}
