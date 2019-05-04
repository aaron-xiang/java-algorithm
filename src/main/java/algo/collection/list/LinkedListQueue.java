package algo.collection.list;

public class LinkedListQueue<T> implements Queue<T> {
    List<T> list = new LinkedList<>();

    @Override
    public void enqueue(T value) {
        list.add(value);
    }

    @Override
    public T dequeue() {
        T value = list.get(0);
        list.remove(0);
        return value;
    }

    @Override
    public T peek() {
        T value = list.get(0);
        return value;
    }

    @Override
    public int size() {
        return list.size();
    }
}
