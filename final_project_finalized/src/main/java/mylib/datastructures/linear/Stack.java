package src.main.java.mylib.datastructures.linear;

import src.main.java.mylib.datastructures.nodes.SLLNode;

public class Stack extends SinglyLinkedList {


    public Stack() {
        super();
    }
 
    public Stack(SLLNode v) {
        super(v);
    }

    public void push(SLLNode node) {
        super.InsertHead(node);
    }

    public SLLNode pop() {
        SLLNode r = head;
        DeleteHead();
        return r;
    }

    public SLLNode peek() {
        return head;
    }

    public SLLNode Search() {
        return super.Search(head);
    }

    public void DeleteHead() {}

    public void Delete() {}

    public void SortedInsert(SLLNode node) {}

    public void Insert() {}
    
    public void Sort() {}

    public void Clear() {
        super.Clear();
    }

    public void Print() {
        super.Print();
    }
}
