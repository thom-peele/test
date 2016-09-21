package lessen.les5;


/**
 * Created by thom on 20-9-2016.
 */
public class HANLinkedList<T> {

    private ListNode<String> startnode = null;

    public HANLinkedList(Class<T> c) {
        System.out.println(c.toString());
        startnode = new ListNode<String>("start");
    }

    public void addFirst(T value) {
        ListNode<T> newListNode = new ListNode<T>(value);
        startnode.setNextNode(newListNode);
    }

}

class ListNode<T> {
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
}
