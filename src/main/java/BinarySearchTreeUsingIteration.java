public class BinarySearchTreeUsingIteration<T extends Comparable<T>> {

    Node root;
    int size = 0;

    private class Node {
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T obj) {
        if(obj == null)
            throw new RuntimeException("Invalid value");
        if(isEmpty()) {
            root = new Node(obj);
            size++;
        } else {
            Node newNode = new Node(obj);
            Node parent = null;
            Node trav = root;
            while(trav != null) {
                parent = trav;
                if(isLess(obj, trav.getData())) {
                    trav = trav.left;
                } else {
                    trav = trav.right;
                }
            }
            if(isLess(obj, parent.getData())) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            size++;
        }
        return true;
    }

    private boolean isLess(T obj1, T obj2) {
        return obj1.compareTo(obj2) < 0;
    }

    public boolean contains(T obj) {
        boolean found = false;
        Node trav = root;
        while(trav != null) {
            if(obj.equals(trav.getData())) {
                found = true;
                break;
            } else if(isLess(obj, trav.getData())) {
                trav = trav.left;
            } else {
                trav = trav.right;
            }
        }
        return found;
    }

    public String getInOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        populateInOrder(root, sb);
        sb.append("]");
        return sb.toString();
    }

    private void populateInOrder(Node root, StringBuilder sb) {
        if(root != null) {
            populateInOrder(root.left, sb);
            sb.append(root.getData()).append(" ");
            populateInOrder(root.right, sb);
        }
    }

    public boolean remove(T obj) {
        if(obj == null) {
            throw new RuntimeException("Invalid Value");
        } else if(isEmpty()) {
            throw new RuntimeException("BST is empty");
        } else if(root.getData().equals(obj)) {
            root = null;
            return true;
        } else {
            boolean found = false;
            Node trav1 = root;
            Node trav2 = null;
            while(trav1 != null) {
                if(obj.equals(trav1.getData())) {
                    found = true;
                    break;
                } else if(isLess(obj, trav1.getData())) {
                    trav2 = trav1;
                    trav1 = trav1.left;
                } else {
                    trav2 = trav1;
                    trav1 = trav1.right;
                }
            }
            if (!found) {
                return false;
            } else {
                if(trav1.left == null && trav1.right == null) {
                    if(trav1.equals(trav2.right)) {
                        trav2.right = null;
                    } else {
                        trav2.left = null;
                    }
                } else if(trav1.left != null && trav1.right == null) {
                    if(trav1.equals(trav2.right)) {
                        trav2.right = trav1.left;
                    } else {
                        trav2.left = trav1.left;
                    }
                } else if(trav1.left == null && trav1.right != null) {
                    if (trav1.equals(trav2.right)) {
                        trav2.right = trav1.right;
                    } else {
                        trav2.left = trav1.right;
                    }
                } else if(trav1.left != null && trav1.right != null) {
                    T newObj = removeLeastNodeFromRightSubtree(trav1);
                    trav1.data = newObj;
                }
                return true;
            }
        }
    }

    private T removeLeastNodeFromRightSubtree(Node root) {
        Node trav1 = root.right;
        Node trav2 = root;
        while(trav1.left != null) {
            trav2 = trav1;
            trav1 = trav1.left;
        }
        if(trav2.equals(root)) {
            trav2.right = trav1.right;
        } else if(trav1.right == null) {
            trav2.left = null;
        } else {
            trav2.left = trav1.right;
        }
        return trav1.getData();
    }
}
