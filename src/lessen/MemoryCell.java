package lessen;

/**
 * Created by thom on 16-9-2016.
 */
public class MemoryCell<T> implements Comparable<MemoryCell<T>> {

    private T storedValue;

    public T read() {
        return storedValue;
    }

    public void write (T x) {
        storedValue = x;
    }

    @Override
    public int compareTo(MemoryCell<T> other) {
        return this.read().toString().compareTo(other.read().toString());
    }

}