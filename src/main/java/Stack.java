import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    int top = -1;
    int size;
    Node<T> tail;

    public Stack() {
        this(10);
    }

    public Stack(int size) {
        this.size = size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> temp = tail;
            int topIndex = top;
            @Override
            public boolean hasNext() {
                return topIndex != -1;
            }

            @Override
            public T next() {
                T data =  temp.data;
                temp = tail.prev;
                topIndex--;
                return data;
            }
        };
    }

    private class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    public boolean push(T obj) {
        if(top == size - 1)
            throw new StackOverflowError();
        Node<T> node = new Node<>(obj);
        if(!isEmpty()) {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        top++;
        return true;
    }

    public T pop() {
        if (top == -1)
            throw new EmptyStackException();
        T data = tail.data;
        if(top == 0) {
            tail.data = null;
            tail = null;
        } else {
            Node<T> prev = tail.prev;
            prev.next = null;
            tail.data = null;
            tail = prev;
        }
        top--;
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public T peek() {
        if (top == -1)
            throw new EmptyStackException();
        T data = tail.data;
        return data;
    }

    @Override
    public String toString() {
        if(isEmpty())
            return "[]";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node<T> trav = tail;
        while(trav.prev != null) {
            stringBuilder.append(trav.data);
            stringBuilder.append(", ");
            trav = trav.prev;
        }
        stringBuilder.append(trav.data);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
