package src.main.java.mylib.datastructures.linear;

import src.main.java.mylib.datastructures.nodes.SLLNode;

public class Queue extends SinglyLinkedList {

    public Queue() {
        super();
    }

    public Queue(SLLNode v) {
        super(v);
    }

    public void InsertHead(SLLNode h) {}

    public void Insert(SLLNode node) {}

    public void SortedInsert(SLLNode node) {}

    public SLLNode Search(SLLNode node) {
        return super.Search(node);
    }

    public void DeleteTail() {}

    public void Sort() {}

    public void Clear() {
        super.Clear();
    }

    public void Enque(SLLNode t) {
        super.InsertTail(t);
    }

    public int Deque() {
        int value = head.getValue();
        super.DeleteHead();
        return value;
    }

    public void Print() {
        super.Print();
    }
}
