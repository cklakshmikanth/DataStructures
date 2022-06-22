public class HeapUsingArray<T extends Comparable<T>> {
    int size = 0;
    int capacity;
    T[] heap;

    public HeapUsingArray() {
        this(5);
    }

    public HeapUsingArray(int capacity) {
        this.capacity = capacity;
        heap = (T[]) new Comparable[capacity];//Note: We cant use array of object since object class does not implement comparable.
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
            if(isLesser(leftChildIndex, i)) {
                swap(leftChildIndex, i);
            }
        } else {
            if(isLesser(leftChildIndex, rightChildIndex)) {
                if(isLesser(leftChildIndex, i)) {
                    swap(leftChildIndex, i);
                    sink(leftChildIndex);
                }
            } else {
                if(isLesser(rightChildIndex, i)) {
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

    private boolean isLesser(int i, int j) {
        return heap[i].compareTo(heap[j]) <= 0;
    }

    private boolean isGreater(int i, int j) {
        return heap[i].compareTo(heap[j]) >= 0;
    }

    private T remove(int index) {
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

    public boolean remove(T obj) {
        int index = getObjectIndex(obj);
        if(index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    private int getObjectIndex(T obj) {
        for(int i = 0; i < size; i++)
            if(heap[i].equals(obj))
                return i;
        return -1;
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
        if(isLesser(index, parentIndex)) {
            swap(index, parentIndex);
            swim(parentIndex);
        }
    }

    public void heapify(T[] array) {
        heap = array;
        size = capacity = array.length;
        for(int i = size - 1; i >=0; i--) {
            heapifySink(i);
        }
    }

    private void heapifySink(int i) {
        if(i < size / 2) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;

            T leftChildValue = leftChildIndex > capacity - 1 ? null : heap[leftChildIndex];
            T rightChildValue = rightChildIndex > capacity - 1 ? null : heap[rightChildIndex];

            if (leftChildValue == null) {
                return;
            } else if (rightChildValue == null) {
                if (isGreater(leftChildIndex, i)) {
                    swap(leftChildIndex, i);
                }
            } else {
                if (isGreater(leftChildIndex, rightChildIndex)) {
                    if (isGreater(leftChildIndex, i)) {
                        swap(leftChildIndex, i);
                        heapifySink(leftChildIndex);
                    }
                } else {
                    if (isGreater(rightChildIndex, i)) {
                        swap(rightChildIndex, i);
                        heapifySink(rightChildIndex);
                    }
                }
            }
        }
    }
}