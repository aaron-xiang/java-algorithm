package algo.collection.list;

/**
 * This is interface of list ADT
 * @param <T> generic type
 */
public interface List<T> {
    /**
     * Add value to list
     * @param value - value to be added to the end of the list
     */
    void add(T value);

    /**
     * Get value from the specified index
     * @param index - index where the item to be retrieved
     * @return value at the index
     */
    T get(int index);

    void remove(int index);

    void insert(int index, T value);

    void put(int index, T value);

    int size();
}
