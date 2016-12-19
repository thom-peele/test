package herkansing;

/**
 * Created by thom on 21-9-2016.
 */

public class ListNode<T> {
    private ListNode nextNode = null;

    private T value = null;

    public ListNode(T value) {
        this.value = value;
    }

    public void setNextNode(ListNode listNode) {
        nextNode = listNode;
    }

    public ListNode getNextNode() {
        if(nextNode != null) {
            return nextNode;
        }
        return null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
