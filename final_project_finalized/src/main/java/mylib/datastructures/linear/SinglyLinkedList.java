package src.main.java.mylib.datastructures.linear;

import src.main.java.mylib.datastructures.nodes.SLLNode;

public class SinglyLinkedList {
    private int size = 0;
    protected SLLNode head;

    public SinglyLinkedList() {
        this.head = null;
    }
    
    public SinglyLinkedList(SLLNode v) {
        head = v;
        size = 1;
    }

    public void InsertHead(SLLNode h) {
        if (head != null) {
            h.setNext(head);
        }
        head = h;
        size = size + 1;
    }

    public void InsertTail(SLLNode h) {
        SLLNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(h);
        size = size + 1;

    }

    public void Insert(SLLNode node, int pos) {
        SLLNode temp = head;
        if (pos == 1) {
            InsertHead(node);
        }
        else {
            for (int i = 2; i < pos; i++) {
                temp = temp.getNext();
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        size = size + 1;
    }

    public void SortedInsert(SLLNode node) {
        SLLNode check = head;
        while (check.getNext() != null) {
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
        while (check.getNext() != null) {
            if (check.getValue() <= node.getValue() && check.getNext().getValue() >= node.getValue()) {
                break;
            }
            else {pos = pos + 1;}
        }
        Insert(node, pos);
    }

    public SLLNode Search(SLLNode node) {
        SLLNode check = head;
        while (check.getNext() != null) {
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
        head = head.getNext();
        size = size - 1;
    }

    public void DeleteTail() {
        SLLNode temp = head;
        if (size == 1) {
            DeleteHead();
            size = size - 1;
            return;
        }
        for (int i = 2; i < size; i++) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        size = size - 1;
    }

    public void Delete(SLLNode node) {
        if (node == head) {
            DeleteHead();
            return;
        }
        SLLNode check = head;
        while (check.getNext() != null) {
            if (node == check) {
                check.setNext(check.getNext().getNext());
                size = size - 1;
                return;
            }
        }
        if (node == check) {
            check.setNext(check.getNext().getNext());
            size = size - 1;
            return;
        }
    }

    public void Sort() {
        SLLNode sorted = null; 
        SLLNode current = head;
        while (current != null) {
            SLLNode next = current.getNext();
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
        while (current != null) {
            System.out.println(current.getValue());
            if (current.getNext() != null) {
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