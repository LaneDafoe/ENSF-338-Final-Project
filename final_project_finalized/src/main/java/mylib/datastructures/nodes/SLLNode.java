package src.main.java.mylib.datastructures.nodes;

public class SLLNode {
    private int value;
    private SLLNode next;

    public SLLNode(int v) {
        this.value = v;
    }
// getters
    public int getValue() {
        return value;
    }

    public SLLNode getNext() {
        return next;
    }

// setters 
    public void setValue(int v) {
        this.value = v;
    }

    public void setNext(SLLNode n) {
        this.next = n;
    }

}
