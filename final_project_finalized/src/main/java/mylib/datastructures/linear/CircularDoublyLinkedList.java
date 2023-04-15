package src.main.java.mylib.datastructures.linear;
import src.main.java.mylib.datastructures.nodes.DLLNode;

public class CircularDoublyLinkedList {
    private int size = 0;
    private DLLNode head;
    private DLLNode tail;

    public CircularDoublyLinkedList() {
        head = null;
        tail = null;
    }

    public CircularDoublyLinkedList(int v) {
        this.head = new DLLNode(v);
        head.setNext(head);
        head.setPrev(head);
        size = 1;
    }

    public void InsertHead(DLLNode h) {
        if (head != null) {
            h.setNext(head);
            h.setPrev(head.getPrev());
            head.getPrev().setNext(h);
            head.setPrev(h);
            head = h;
        }
        else {
            head = h;
            head.setNext(head);
            head.setPrev(head);
        }
        size = size + 1;
    }
    
    public void InsertTail(DLLNode t) {
        if (size != 0) {
            t.setPrev(tail);
            t.setNext(head);
            head.setPrev(t);
            tail.setNext(t);
            tail = t;
        }
        else {
            head = t;
            head.setNext(head);
            head.setPrev(head);
        }
        size = size + 1;
    }

    public void Insert(DLLNode node, int pos) {
        DLLNode temp = head;
        if (pos == 1) {
            InsertHead(node);
        }
        else if (pos > size + 1) {
            System.out.print("out of range");
        }
        else if (pos == size + 1) {
            InsertTail(node);

        }
        else {
            for (int i = 2; i < pos; i++) {
                temp = temp.getNext();
            }
            node.setNext(temp.getNext());
            node.setPrev(temp);
            temp.getNext().setPrev(node);
            temp.setNext(node);
            size = size + 1;
        }
    }

    public void SortedInsert(DLLNode node) {
        DLLNode check = head;
        while (check.getNext() != head) {
            if(check.getValue() > check.getNext().getValue()) {
                this.Sort();
                break;
            }
        }
        check = head;
        int pos = 2;
        if (head.getValue() > node.getValue()) {
            InsertHead(node);
            return;
        }
        boolean last = true;
        while (check.getNext() != head) {
            if (check.getValue() <= node.getValue() && check.getNext().getValue() >= node.getValue()) {
                last = false;
                break;
            }
            else {pos = pos + 1;}
        }
        if (last == true) {
            InsertTail(node);
        }
        else{
            Insert(node, pos);
        }
    }

    public DLLNode Search(DLLNode node) {
        DLLNode check = head;
        while (check.getNext() != head) {
            if (check.getValue() == node.getValue()) {
                return node;
            }
            else {check = check.getNext();}
        }
        if (check.getValue() == node.getValue()) {
            return node;
        }
        else {return null;}
    }

    public void DeleteHead() {
        tail.setNext(head.getNext());
        head.getNext().setPrev(tail);
        head = head.getNext();
        size = size - 1;
    }

    public void DeleteTail() {
        head.setPrev(tail.getPrev());
        tail.getPrev().setNext(head);
        tail = tail.getPrev();
        size = size - 1;
    }

    public void Delete(DLLNode node)  {
        if (node == head) {
            DeleteHead();
            return;
        }
        else if (node == tail) {
            DeleteTail();
            return;
        }
        DLLNode check = head;
        check = check.getNext();
        while (check.getNext() != head) {
            if (node == check) {
                check.setNext(check.getNext().getNext());
                size = size - 1;
                return;
            }
        }
        if (node == check) {
            DeleteTail();
            return;
        }
    }

    public void Sort() {
        DLLNode sorted = null;
        DLLNode current = head;
        DLLNode next = current.getNext();
        SortedInsert(current);
        current = next;
        while (current != head) {
            next = current.getNext();
            SortedInsert(current);
            current = next;
        }

        head = sorted;
    }
    
    public void Clear() {
        head = null;
    }

    public void Print() {
        boolean sorted = true;
        System.out.println("The length of the list is " + this.size);
        DLLNode current = head;
        System.out.println(current.getValue());
        if (current.getNext().getValue() < current.getValue()) {sorted = false;}
        current = current.getNext();
        while (current != head) {
            System.out.println(current.getValue());
            if (current.getNext() != head) {
                if (current.getNext().getValue() < current.getValue()) {sorted = false;}
            }
            current = current.getNext();
        }
        if (sorted == true) {
            System.out.println("The list is sorted");
        }
        else {
            System.out.println("The list is not sorted");
        }
    }
}
