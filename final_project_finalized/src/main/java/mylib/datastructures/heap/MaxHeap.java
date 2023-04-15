package src.main.java.mylib.datastructures.heap;
import java.util.Vector;

public class MaxHeap extends Heap {

    public MaxHeap() {
        super();
    }

    public MaxHeap(int size) {
        super(size);
    }

    public MaxHeap(int[] element) {
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
        int largest = i; 
        int l = Left(i); 
        int r = Right(i);
        if (l < array.length && array[l] > array[largest]) {
            largest = l;
        }
        if (r < array.length && array[r] > array[largest]) {
            largest = r;
        }
        if (largest != i && largest == l) {
            super.Swap(i, largest);
            return Heapify(array, i * 2 + 1);
        }
        if (largest != i && largest == r) {
            super.Swap(i, largest);
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

    private Vector<Integer> Heapify(int[] array) {
        int[] heapArray = Heapify(array, (array.length - 1) / 2);
        for (int n = ((array.length - 1) / 2) - 1; n >= 0; n--) {
            heapArray = Heapify(heapArray, n);
        }

        Vector<Integer> result = new Vector<>(heapArray.length);
        for (int i = 0; array.length > i; i++) {
            result.set(i, heapArray[i]);
        }
        return result;
    }

    private int[] Heapify(int array[], int i) {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
        if (l < array.length && array[l] > array[largest])
            largest = l;
 
        if (r < array.length && array[r] > array[largest])
            largest = r;

        if (largest != i) {
            super.Swap(i, largest);
        }
        return array;
    }
}
