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
        ListNode temp = startnode.getNextNode();
        ListNode<T> newListNode = new ListNode<T>(value);
        startnode.setNextNode(newListNode);
        if(temp != null){
            newListNode.setNextNode(temp);
        }
    }

    public void removeFirst(){
        ListNode toDeleteNode = startnode.getNextNode();
        if(toDeleteNode == null) {
            throw new IndexOutOfBoundsException();
        } else {
            ListNode<T> secondNode = toDeleteNode.getNextNode();
            if (secondNode != null) {
                startnode.setNextNode(secondNode);
            } else secondNode.setNextNode(null);
        }
    }

    public T get(int index) {
        ListNode temp = startnode;
        while(index != 0 && temp != null) {
            index--;
            temp = temp.getNextNode();
        }
        if(temp != null) {
            return (T)temp.getValue();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void insert(int index, T value) {
        ListNode temp = startnode;
        while(index != 0 && temp != null) {
            index--;
            temp = temp.getNextNode();
        }
        if(temp != null) {
            ListNode<T> afterNode = temp.getNextNode();
            ListNode<T> newListNode = new ListNode<T>(value);
            if(afterNode != null) {
                newListNode.setNextNode(afterNode);
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void delete(int index) {
        ListNode temp = startnode;
        while(index != 1 && temp != null) {
            index--;
            temp = temp.getNextNode();
        }
        if(temp != null) {
            ListNode<T> toDeleteNode = temp.getNextNode();
            if(toDeleteNode != null) {
                ListNode<T> afterDeleteNode = toDeleteNode.getNextNode();
                if(afterDeleteNode != null) {
                    temp.setNextNode(afterDeleteNode);
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }






}
