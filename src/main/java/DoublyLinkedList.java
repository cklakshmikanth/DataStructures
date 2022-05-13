import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

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
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void clear() {
        Node<T> trav = head;
        while(trav != null) {
            Node<T> next = trav.next;
            trav.prev = null;
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
            node.prev = tail;
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
            head.prev = node;
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
            trav.prev = null;
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
            Node<T> trav = tail.prev;
            tail.prev = null;
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
        if(obj.prev == null)
            return removeFirst();
        if(obj.next == null)
            return removeLast();

        T data = obj.data;

        Node<T> prev = obj.prev;
        Node<T> next = obj.next;

        prev.next = next;
        next.prev = prev;

        obj.next = obj.prev = null;
        obj.data = null;
        size--;
        return data;
    }

    public T removeAt(int index) {
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("Inavlid Index");
        Node<T> trav = null;
        if(index < size/2) {// Remember this optimization
            trav = head;
            for(int i=0; i<= index; i++) {
                trav =trav.next;
            }
        } else {
            trav = tail;
            for(int i=0; i<= size-index; i++) {
                trav =trav.prev;
            }
        }
        return remove(trav);
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
