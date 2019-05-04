package algo.collection.list;

public class ArrayList<T> implements List<T> {
    private final int DEFAULT_CAPACTIY = 100;
    protected T[] data;
    private int size;

    public ArrayList() {
        data = (T[]) new Object[DEFAULT_CAPACTIY];
    }

    public ArrayList(int capacity) {
        data = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size >= data.length) resize(data.length*2);
        data[size++] = value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index: " + index);
        return data[index];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index: " + index);
        int start = index + 1;
        int end = size - 1;
        for (int i = start; i <= end; i++) {
            data[i-1] = data[i];
        }
        data[end] = null;
        size--;
        if (size < data.length/4) resize(data.length/2);
    }

    @Override
    public void insert(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid index: " + index);
        if (size >= data.length) resize(data.length*2);
        int start = index;
        int end = size - 1;
        for (int i = end; i >= start; i--) {
            data[i+1] = data[i];
        }
        data[index] = value;
        size++;
    }

    @Override
    public void put(int index, T value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index: " + index);
        data[index] = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<T> reverse() {
        List<T> reversed = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            reversed.insert(i, get(size-1-i));
        }
        return reversed;
    }


    private void resize(int length) {
//        data = Arrays.copyOf(data, length);
        T[] newData = (T[]) new Object[length];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
