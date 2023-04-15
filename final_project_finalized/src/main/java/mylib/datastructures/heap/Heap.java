package src.main.java.mylib.datastructures.heap;


import java.util.Vector;

public class Heap {
    protected Vector<Integer> elements;

    protected Heap() {
        elements = new Vector<>(0);
    }

    protected Heap(int size) {
        elements = new Vector<>(size);
    }

    public int GetSize() {
        return elements.size();
    }

    public boolean IsEmpty() {
        if (IsEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void Clear() {
        elements.clear();
    }

    public boolean Contains(Integer i) {
        return elements.contains(i);
    }

    public void Insert(Integer key) {
        elements.addElement(key);
    }

    public void Delete(Integer key) {
        Integer last = elements.elementAt(elements.size() - 1);
        elements.remove(elements.size() - 1);
        elements.set(elements.indexOf(key), last);
    }

    public void Print() {

        for (int i = 0; i < elements.size(); i++) {
            if (i == 0) {
                System.out.print("-1    ");
            }
            else {
                System.out.printf("%d   ", (i - 1) / 2);
            }
        }

        System.out.printf("%n");

        for (Integer v : elements) {
            System.out.printf("%d   ", v);
        }
    }
    
    protected static int Parent(int i) {
        if (i == 0) {
            return -1;
        }
        else {
            return (i - 1) / 2;
        }
    }

    protected static int Left(int i) {
        return i * 2 + 1;
    }

    protected static int Right(int i) {
        return i * 2 + 2;
    }

    protected void Swap(int x, int y) {
        int temp = elements.elementAt(x);
        elements.setElementAt(elements.elementAt(y), x);
        elements.setElementAt(temp, y);
    }

}

