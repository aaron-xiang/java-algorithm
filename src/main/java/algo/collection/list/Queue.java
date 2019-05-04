package algo.collection.list;

public interface Queue<T> {
    void enqueue(T value);
    T dequeue();
    T peek();
    int size();
}
