package lessen.old;

import java.util.Arrays;

/**
 * Created by koen on 16-9-2016.
 */
public class MyList<T> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(T e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @SuppressWarnings("unchecked")
    public T get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (T) elements[i];
    }
}

