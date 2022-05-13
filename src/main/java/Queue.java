public class Queue<T> {

    int front = 0;
    int back = -1;
    int size;
    int capacity;
    T[] array;

    public Queue() {
        this(16);
    }

    public Queue(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean enqueue(T obj) {
        if(size == capacity)
            throw new RuntimeException("Queue is full");
        if(back == capacity - 1) {//Circular Queue implementation
            back = 0;
            array[back] = obj;
        } else {
            array[++back] = obj;
        }
        size++;
        return true;
    }

    public T dequeue() {
        if(isEmpty())
            throw new RuntimeException("Queue is empty");
        T obj = null;
        if(front == capacity - 1) {//Circular Queue implementation
            obj = array[front];
            front = 0;
        } else {
            obj = array[front++];
        }
        size--;
        return obj;
    }

    public T peek() {
        if(isEmpty())
            throw new RuntimeException("Queue is empty");
        return array[front];
    }

    @Override
    public String toString() {
        if(isEmpty())
            return "[]";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        if(front <= back) {
            for(int i = front ; i <= back; i++) {
                stringBuilder.append(array[i]);
                stringBuilder.append(" ");
            }
        } else {
            for(int i = front; i < capacity; i++) {
                stringBuilder.append(array[i]);
                stringBuilder.append(" ");
            }
            for(int i = 0; i <= back; i++) {
                stringBuilder.append(array[i]);
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
