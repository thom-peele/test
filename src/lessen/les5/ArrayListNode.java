package lessen.les5;

/**
 * Created by thom on 23-9-2016.
 */
public class ArrayListNode<T> {
    private T value;

    ArrayListNode() {}
    ArrayListNode(T value) {
        this.value = value;
    }

    /**
     * @return stored value
     */
    public T getValue() {
        return value;
    }

    /**
     * Set value of node also possible to overwrite value
     * @param value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @return the to string of the stored value
     */
    @Override
    public String toString() {
        return value.toString();
    }
}
