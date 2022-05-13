import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ArrayList<T> implements Iterable<T> {

    int capacity = 0;
    int size = 0;
    T[] array = null;

    public ArrayList() {
        this(16);
    }

    public ArrayList(int capacity) {
        if(capacity <= 0)
            throw new IllegalArgumentException("Size of array cannot be negative or empty");
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void add(int index, T ob) {
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
        array[index] = ob;
    }

    public void add(T ob) {
        if(size == capacity) {
            if(capacity == 0)
                capacity = 1;
            else
                capacity*=2;
            T[] newArray = (T[]) new Object[capacity];
            for(int i=0; i<size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        add(size, ob);
        size++;
    }

    public T get(int index) {
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
        return array[index];
    }

    public T removeAt(int index) {
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
        T data = array[index];
        T[] newArray = (T[]) new Object[--capacity];
        for(int i=0, j=0; i < size; i++, j++) {
            if(i == index)
                j--;
            else
                newArray[j] = array[i];
        }
        array = newArray;
        size--;
        return data;
    }

    public boolean remove(T ob) {
        for(int i=0; i< size; i++) {
            if(array[i].equals(ob)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T ob) {
        for(int i=0; i< size; i++) {
            if(array[i].equals(ob)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T ob) {
        return indexOf(ob) != -1;
    }

    public int size() {
        return  size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for(T ob : array) {
            ob = null;
        }
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    @Override
    public String toString() {
        if(size == 0)
            return "[]";
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size-1; i++) {
                sb.append(array[i].toString());
                sb.append(", ");
            }
            sb.append(array[size-1]);
            sb.append("]");
            return sb.toString();
        }
    }
}
