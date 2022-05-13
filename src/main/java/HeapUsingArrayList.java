import java.util.ArrayList;
import java.util.List;

public class HeapUsingArrayList<T extends Comparable<T>> {

    int heapSize;
    List<T> heap;

    public HeapUsingArrayList() {
        this(10);
    }

    public HeapUsingArrayList(int capacity) {
        heap = new ArrayList<>(capacity);
    }

    public int size() {
        return heapSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        for (int i = 0; i < heapSize; i++) {
            heap.set(i, null);
        }
        heapSize = 0;
    }

    public T peek() {
        if (isEmpty()) return null;
        return heap.get(0);
    }

    public T poll() {
        if (isEmpty()) return null;
        return removeAt(0);
    }

    public boolean contains(T obj) {
        if (isEmpty()) return false;
        return heap.contains(obj);
    }

    public void add(T ob) {
        if (ob == null) throw new RuntimeException();

        heap.add(ob);
        swim(heapSize);
        heapSize++;
    }

    private void swim(int index) {
        if (index != 0) {
            T currentValue = heap.get(index);
            int parentIndex = (index - 1) / 2;
            T parentValue = heap.get(parentIndex);

            if (isLess(currentValue, parentValue)) {
                heap.set(parentIndex, currentValue);
                heap.set(index, parentValue);
                swim(parentIndex);
            }
        }
    }

    private boolean isLess(T leftValue, T rightValue) {
        //Just changing condition to leftValue.compareTo(rightValue) >= 0 will covert the program to max Heap
        return leftValue.compareTo(rightValue) < 0;
    }

    public T remove(T obj) {
        for (int i = 0; i < heapSize; i++) {
            if (heap.get(i).equals(obj)) {
                return removeAt(i);
            }
        }
        return null;
    }

    private T removeAt(int index) {
        T data = heap.get(index);
        heap.set(index, heap.get(heapSize - 1));
        heap.set(heapSize - 1, null);
        heapSize--;
        sink(index);
        return data;
    }

    private void sink(int index) {
        if (index < heapSize) {
            T currentValue = heap.get(index);
            T leftChildValue = null;
            T rightChildValue = null;

            int leftChildIndex = 2 * index + 1;
            if (leftChildIndex < heapSize) {
                leftChildValue = heap.get(leftChildIndex);
            }

            int rightChildIndex = 2 * index + 2;
            if (rightChildIndex < heapSize) {
                rightChildValue = heap.get(rightChildIndex);
            }

            if (leftChildValue == null) {
                return;
            }

            if (rightChildValue != null) {
                if (isLess(rightChildValue, leftChildValue)) {
                    if (isLess(rightChildValue, currentValue)) {
                        heap.set(rightChildIndex, currentValue);
                        heap.set(index, rightChildValue);
                        sink(rightChildIndex);
                    }
                } else {
                    if (isLess(leftChildValue, currentValue)) {
                        heap.set(leftChildIndex, currentValue);
                        heap.set(index, leftChildValue);
                        sink(leftChildIndex);
                    }
                }
            } else {
                if (isLess(leftChildValue, currentValue)) {
                    heap.set(leftChildIndex, currentValue);
                    heap.set(index, leftChildValue);
                }
            }
        }
    }

    private boolean isLess(int left, int right) {
        T leftValue = heap.get(left);
        T rightValue = heap.get(right);
        return leftValue.compareTo(rightValue) <= 0;
    }

    public boolean isMinHeap(int k) {
        // If we are outside the bounds of the heap return true
        if (k >= heapSize) return true;

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        // Make sure that the current node k is less than
        // both of its children left, and right if they exist
        // return false otherwise to indicate an invalid heap
        if (left < heapSize && !isLess(k, left)) return false;
        if (right < heapSize && !isLess(k, right)) return false;

        // Recurse on both children to make sure they're also valid heaps
        return isMinHeap(left) && isMinHeap(right);
    }
}
