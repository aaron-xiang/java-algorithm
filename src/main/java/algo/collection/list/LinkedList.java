package algo.collection.list;

public class LinkedList<T> implements List<T> {
    private class Node<T> {
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNodeAt(index).data;
    }

    private Node<T> getNodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node<T> cur = head;
        int i = 0;
        while (i < index) {
            cur = cur.next;
            i++;
        }
        return cur;
    }

    @Override
    public void remove(int index) {
        // case 1: single-element list
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }

        Node node = getNodeAt(index);

        // case 2: remove the head element
        if (index == 0) {
            head = node.next;
            node.next = null; // just to be safe
            size--;
            return;
        }

        Node prev = getNodeAt(index - 1);

        // case 3: remove the tail element
        if (index == size-1) {
            prev.next = null;
            tail = prev;
            node.next = null;
            size--;
        }

        // other general cases
        else {
            prev.next = prev.next.next;
            node.next = null;
            size--;
        }

    }

    @Override
    public void insert(int index, T value) {

    }

    @Override
    public void put(int index, T value) {

    }

    @Override
    public int size() {
        return this.size;
    }
}
