import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {

    Node<T> head;
    Node<T> tail;
    int size = 0;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav.next != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void clear() {
        Node<T> trav = head;
        while(trav != null) {
            Node<T> next = trav.next;
            trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T obj) {
        addLast(obj);
    }

    public void addLast(T obj) {
        if(isEmpty()) {
            head = tail = new Node<>(obj);
        } else {
            Node<T> node = new Node<>(obj);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public  void addFirst(T obj) {
        if(isEmpty()) {
            head = tail = new Node<>(obj);
        } else {
            Node<T> node = new Node<>(obj);
            node.next = head;
            head = node;
        }
        size++;
    }

    public T peekFirst() {
        if(isEmpty())
            throw new RuntimeException("Empty List");
        return head.data;
    }

    public T peekLast() {
        if(isEmpty())
            throw new RuntimeException("Empty List");
        return tail.data;
    }

    public T removeFirst() {
        if(isEmpty())
            throw new RuntimeException("Empty List");
        T data = head.data;
        if(size == 1) {
            head = tail = null;
        } else {
            Node<T> trav = head.next;
            head.next = null;
            head.data = null;
            head = trav;
        }
        size--;
        return data;
    }

    public T removeLast() {
        if(isEmpty())
            throw new RuntimeException("Empty List");
        T data = tail.data;
        if(size == 1) {
            tail.data = null;
            head = tail = null;
        } else {
            Node<T> trav = head;
            while(trav.next != tail) {
                trav = trav.next;
            }
            tail.data = null;
            trav.next = null;
            tail = trav;
        }
        size--;
        return data;
    }

    private T remove(Node<T> obj) {
        if(isEmpty())
            throw new RuntimeException("Empty List");
        if(obj.next == null)
            return removeLast();

        T data = obj.data;

        Node<T> trav = head;

        while(!trav.next.data.equals(data)) {
            trav = trav.next;
        }

        trav.next = obj.next;

        obj.next = null;
        obj.data = null;
        size--;
        return data;
    }

    public T removeAt(int index) {
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("Invalid Index");
        Node<T> trav = null;
        trav = head;
        for(int i=0; i < index - 1; i++) {
            trav = trav.next;
        }

        Node<T> temp = trav.next;
        trav.next = temp.next;
        T data = temp.data;
        temp.data = null;
        temp.next = null;
        size--;
        return data;
    }

    public boolean remove(T obj) {
        if(isEmpty())
            throw new RuntimeException("Empty List");
        Node<T> trav = head;
        while(trav != null) {
            if(trav.data.equals(obj)) {
                remove(trav);
                return true;
            }
            trav = trav.next;
        }
        return false;
    }

    public int indexOf(T obj) {
        if (isEmpty())
            throw new RuntimeException("Empty List");
        int index = 0;
        Node<T> trav = head;
        while(trav != null) {
            if(trav.data.equals(obj)) {
                return index;
            } else {
                index++;
            }
            trav = trav.next;
        }
        return -1;
    }

    public boolean contains(T obj) {
        return indexOf(obj) != -1;
    }

}
