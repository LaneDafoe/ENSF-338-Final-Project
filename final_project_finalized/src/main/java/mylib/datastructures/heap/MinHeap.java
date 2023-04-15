package src.main.java.mylib.datastructures.heap;
import java.util.Vector;

public class MinHeap extends Heap {

    public MinHeap() {
        super();
    }

    public MinHeap(int size) {
        super(size);
    }

    public MinHeap(int[] element) {
        super();
        elements = Heapify(element);
    }
    
    public int GetSize() {
        return super.GetSize();
    }

    public boolean IsEmpty() {
        return super.IsEmpty();
    }

    public void Clear() {
        super.Clear();
    }

    public boolean Contains(Integer i) {
        return super.Contains(i);
    }

    public void Insert(Integer key) {
        super.Insert(key);
        HeapifyUp(elements.size() + 1);
    }

    public void Delete(Integer key) {
        Integer last = elements.elementAt(elements.size() - 1);
        super.Delete(key);
        HeapifyDown(elements.indexOf(last));
    } 

    public void Print() {
        super.Print();
    }

    protected void Swap(int x, int y) {
        super.Swap(x, y);
    }

    protected void HeapifyDown(int i) {
        int[] temp = new int[elements.size()];
        for (int j = 0; j < elements.size(); j++) {
            temp[i] = elements.elementAt(i);
        }
        temp = HeapDownStep(temp, i);

        Vector<Integer> result = new Vector<>(temp.length);
        for (int k = 0; temp.length > k; k++) {
            result.set(i, temp[i]);
        }
        elements = result;
    }
    
    private int[] HeapDownStep(int[] array, int i) {
        int smallest = i; 
        int l = Left(i); 
        int r = Right(i);
        if (l < array.length && array[l] < array[smallest]) {
            smallest = l;
        }
        if (r < array.length && array[r] < array[smallest]) {
            smallest = r;
        }
        if (smallest != i && smallest == l) {
            super.Swap(i, smallest);
            return Heapify(array, i * 2 + 1);
        }
        if (smallest != i && smallest == r) {
            super.Swap(i, smallest);
            return Heapify(array, i * 2 + 2);
        }
        return array;
    }
    
    protected void HeapifyUp(int i) {
        int[] temp = new int[elements.size()];
        for (int j = 0; j < elements.size(); j++) {
            temp[i] = elements.elementAt(i);
        }
        for (int l = i; l > 0; l = ((l - 1) / 2)) {
            temp = Heapify(temp, i);
        }
        Vector<Integer> result = new Vector<>(temp.length);
        for (int k = 0; temp.length > k; k++) {
            result.set(i, temp[i]);
        }
        elements = result;
    }

    protected Vector<Integer> Heapify(int[] array) {
        int[] heapArray = Heapify(array, Parent(array.length));
        for (int n = Parent(array.length); n >= 0; n--) {
            heapArray = Heapify(heapArray, n);
        }

        Vector<Integer> result = new Vector<>(heapArray.length);
        for (int i = 0; heapArray.length > i; i++) {
            result.set(i, heapArray[i]);
        }
        return result;
    }

    protected int[] Heapify(int array[], int i) {
        int smallest = i; 
        int l = Left(i); 
        int r = Right(i); 
 
        if (l < array.length && array[l] < array[smallest])
            smallest = l;
 
        if (r < array.length && array[r] < array[smallest])
            smallest = r;

        if (smallest != i) {
            super.Swap(i, smallest);
        }
        return array;
    }
}
