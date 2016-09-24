package lessen.les5;


/**
 * Created by thom on 20-9-2016.
 */
public class HANLinkedList<T> {

    private ListNode<String> startnode = null;

    public HANLinkedList() {
        startnode = new ListNode<String>("start");
    }

    /**
     * AddFirst - adds value as first node in the list,
     * when the firstnode is allready taken that node will move to the second place in this list.
     * @param value
     */
    public void addFirst(T value) {
        ListNode temp = startnode.getNextNode();
        ListNode<T> newListNode = new ListNode<T>(value);
        startnode.setNextNode(newListNode);
        if(temp != null){
            newListNode.setNextNode(temp);
        }
    }

    /**
     * RemoveFirst - remove first item of the list.
     */
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

    /**
     * Get - gets item on given index.
     * @param index
     * @return
     */
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

    /**
     * Insert - inserts given value on given index, if index allready set the later values will shift.
     * @param index
     * @param value
     */
    public void insert(int index, T value) {
        ListNode temp = startnode;
        while(index != 0 && temp != null) {
            index--;
            temp = temp.getNextNode();
        }
        if(temp != null) {
            ListNode<T> afterNode = temp.getNextNode();
            ListNode<T> newListNode = new ListNode<T>(value);
            temp.setNextNode(newListNode);
            if(afterNode != null) {
                newListNode.setNextNode(afterNode);
            }
        } else {
            throw new IndexOutOfBoundsException();

        }
    }

    /**
     * Delete - deletes value on index, also shifts next values one place back.
     * @param index
     */
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
                } else {
                    temp.setNextNode(null);
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Size - returns size of list.
     */
    public int size() {
        int i = -1;
        boolean check = true;
        ListNode temp = startnode;
        while (check) {
            if(temp == null) {
                check = false;
            } else {
                temp = temp.getNextNode();
                i++;
            }
        }
        return i;
    }

    /**
     * @return string of the stored values in this linked list, separated by ','.
     */
    @Override
    public String toString() {
        String tempString = "[";
        ListNode temp = startnode.getNextNode();
        while(temp != null) {
            tempString += temp.toString();
            temp = temp.getNextNode();
            if(temp != null) {
                tempString += ",";
            }
        }
        return tempString;
    }






}
