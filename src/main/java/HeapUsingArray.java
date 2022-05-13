public class HeapUsingArray<T extends Comparable<T>> {
    int size = 0;
    int capacity;
    T[] heap;

    public HeapUsingArray() {
        this(5);
    }

    public HeapUsingArray(int capacity) {
        this.capacity = capacity;
        heap = (T[]) new Comparable[capacity];//Note: We can use array of object since object class does not implement comparable.
    }

    public T peek() {
        if(size == 0)
            return null;
        else
            return heap[0];
    }

    public T poll() {
        return remove(0);
    }

    private void sink(int i) {
        if(i == size - 1) {
            return;
        }
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;

        T leftChildValue = leftChildIndex > capacity - 1 ? null : heap[leftChildIndex];
        T rightChildValue = rightChildIndex > capacity - 1 ? null : heap[rightChildIndex];

        if(leftChildValue == null) {
            return;
        } else if(rightChildValue == null) {
            if(isLess(leftChildIndex, i)) {
                swap(leftChildIndex, i);
            }
        } else {
            if(isLess(leftChildIndex, rightChildIndex)) {
                if(isLess(leftChildIndex, i)) {
                    swap(leftChildIndex, i);
                    sink(leftChildIndex);
                }
            } else {
                if(isLess(rightChildIndex, i)) {
                    swap(rightChildIndex, i);
                    sink(rightChildIndex);
                }
            }
        }
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private boolean isLess(int i, int j) {
        return heap[i].compareTo(heap[j]) <= 0;
    }

    public T remove(int index) {
        if(size == 0)
            return null;
        else {
            swap(index, size - 1);
            T obj = heap[size - 1];
            heap[size - 1] = null;
            sink(index);
            size--;
            return obj;
        }
    }

    public void add(T obj) {
        if(size == capacity)
            throw new RuntimeException("Heap is full");
        else {
            heap[size] = obj;
            swim(size);
            size++;
        }
    }

    private void swim(int index) {
        if(index == 0)
            return;
        int parentIndex = (index - 1) / 2;
        if(isLess(index, parentIndex)) {
            swap(index, parentIndex);
            swim(parentIndex);
        }
    }
}