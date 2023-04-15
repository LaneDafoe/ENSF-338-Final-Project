package src.main.java.mylib.datastructures.linear;
import src.main.java.mylib.datastructures.nodes.SLLNode;

public class CircularLinkedList extends SinglyLinkedList {
    private int size = 0;
    private SLLNode head;

    public CircularLinkedList() {
        head = null;
    }

    public CircularLinkedList(SLLNode v) {
        head = v;
        head.setNext(head);
        size = 1;
    }

    public void InsertHead(SLLNode h) {
        if (head != null) {
            h.setNext(head);
        }
        SLLNode check = head;
        while (check.getNext() != head) {
            check = check.getNext();
        }
        check.setNext(h);
        head = h;
        size = size + 1;
    }
    
    public void InsertTail(SLLNode t) {
        SLLNode check = head;
        while (check.getNext() != head) {
            check = check.getNext();
        }
        check.setNext(t);
        t.setNext(head);
        size = size + 1; 
    }

    public void Insert(SLLNode node, int pos) {
        SLLNode temp = head;
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
            temp.setNext(node);
            size = size + 1;
        }
    }

    public void SortedInsert(SLLNode node) {
        SLLNode check = head;
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

    public SLLNode Search(SLLNode node) {
        SLLNode check = head;
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
        SLLNode check = head;
        while (check.getNext() != head) {
            check = check.getNext();
        }
        check.setNext(head.getNext());
        head = head.getNext();
        size = size - 1;
    }

    public void DeleteTail() {
        SLLNode temp = head;
        if (size == 1) {
            Clear();
            size = size - 1;
            return;
        }
        for (int i = 2; i < size; i++) {
            temp = temp.getNext();
        }
        temp.setNext(head);
        size = size - 1;
    }

    public void Delete(SLLNode node)  {
        if (node == head) {
            DeleteHead();
            return;
        }
        SLLNode check = head;
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
        SLLNode sorted = null; 
        SLLNode current = head;
        SLLNode next = current.getNext();
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
        SLLNode current = head;
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