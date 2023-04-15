package src.main.java.mylib.datastructures.linear;
import src.main.java.mylib.datastructures.nodes.DLLNode;

public class DoublyLinkedList {
    private int size = 0;
    private DLLNode head;
    private DLLNode tail;


    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public DoublyLinkedList(DLLNode v) {
        this.head = v;
        this.tail = head;
        size = 1;
    }

    public void InsertHead(DLLNode h) {
        if (head != null) {
            h.setNext(head);
        }
        head = h;
        head.getNext().setPrev(head);
        size = size + 1;
    }

    public void InsertTail(DLLNode t) {
        if (tail != null) {
            t.setPrev(tail);
        }
        tail = t;
        head.getPrev().setNext(tail);
        size = size + 1;

    }

    public void Insert(DLLNode node, int pos) {
        DLLNode temp = head;
        if (pos == 1) {
            InsertHead(node);
        }
        else {
            for (int i = 2; i < pos; i++) {
                temp = temp.getNext();
            }
            node.setNext(temp.getNext());
            temp.getNext().setPrev(node);
            node.setPrev(temp);
            temp.setNext(node);
        }
        size = size + 1;
    }

    public void SortedInsert(DLLNode node) {
        DLLNode check = head;
        while (check.getNext() != null) {
            if(check.getValue() > check.getNext().getValue()) {
                this.Sort();
                break;
            }
        }
        check = head;
        if (head.getValue() > node.getValue()) {
            InsertHead(node);
            size = size + 1;
            return;
        }
        int pos = 2;
        while (check.getNext() != null) {
            if (check.getValue() <= node.getValue() && check.getNext().getValue() >= node.getValue()) {
                break;
            }
            else {pos = pos + 1;}
        }
            Insert(node, pos);
            size = size + 1;
    }

    public DLLNode Search(DLLNode node) {
        DLLNode check = head;
        while (check != null) {
            if (check.getValue() == node.getValue()) {
                return node;
            }
            else {check = check.getNext();}
        }
        return null;
    }

    public void DeleteHead() {
        head = head.getNext();
        head.setPrev(null);
        size = size - 1;
    }

    public void DeleteTail() {
        tail = tail.getPrev();
        tail.setNext(null);
        size = size - 1;
    }

    public void Delete(DLLNode node) {
        if (node == head) {
            DeleteHead();
            size = size - 1;
            return;
        }
        DLLNode check = head;
        while (check != null) {
            if (node == check) {
                check.setNext(check.getNext().getNext());
                if (check.getNext() != null) {
                    check.getNext().setPrev(check);
                }
                size = size - 1;
                return;
            }
        }
    }

    public void Sort() {
        DLLNode sorted = null; 
        DLLNode current = head;
        while (current != null) {
            DLLNode next = current.getNext();
            SortedInsert(current);
            current = next;
        }

        head = sorted;
        }
    
    public void Clear() {
        head = null;
        tail = null;
    }

    public void Print() {
        boolean sorted = true;
        System.out.println("The length of the list is " + this.size);
        DLLNode current = head;
        while (current != null) {
            System.out.println(current.getValue());
            if (current.getNext() != null) {
                if (current.getNext().getValue() < current.getValue()) {sorted = false;}
            }
        }
        if (sorted == true) {
            System.out.println("The list is sorted");
        }
        else {
            System.out.println("The list is not sorted");
        }
    }
}
