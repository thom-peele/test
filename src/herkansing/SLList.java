package herkansing;

/**
 * Created by thom
 * On 16-12-2016.
 */
public class SLList<T> {

    private Node head;
    private SLList<T> tail;

    /**
     *
     * @param head
     */
    public SLList(T head) {
        this.head = new Node(head);
    }

    /**
     *
     * @param head
     * @param tail
     */
    public SLList(T head, SLList<T> tail) {
        this.head = new Node(head);
        this.tail = tail;
    }

    /**
     * removes the head and set next node as head if exists otherwise it will do nothing
     */
    public void removeFirst() {
        if (this.head != null && head.getNext() != null) {
            this.head = head.getNext();
        }
    }

    /**
     * @return head of the list
     */
    public T hd() {
        return (T) head.value;
    }

    /**
     * @return tail of list
     */
    public SLList<T> tl() {
        return tail;
    }

    /**
     *
     * @param value
     */
    public void add(T value) {
        head.setNext(new Node(value));
    }

    public SLList<T> getReversedSLList() {
        return head.getLast();
    }

    private SLList<T> reverseWith(SLList<T> reversed) {
        return reversed;
    }


    public String toString() {
        String temp = "[";
        Node node = head;
        while (node.getNext() != null) {
            temp += node.getValue().toString() + ",";
            node = node.getNext();
        }
        temp += node.getValue().toString();
        return temp +"]";
    }


    class Node<T> {
        private T value;    // we assume elements are character strings
        private Node next;

        /**
         * Creates a node with the given element and next node.
         */
        public Node(T value) {
            this.value = value;
        }


        public Node getNext() {
            return next;
        }

        /**
         * Sets the next node of this node.
         */
        public void setNext(Node newNext) {
            if (getNext() != null) {
                getNext().setNext(newNext);
            } else {
                next = newNext;
            }
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public SLList getLast() {
            return getLast(next);
        }

        public SLList getLast(Node parent) {
            if (next == null) {
                return new SLList(value);
            }
            SLList<T> temp = next.getLast(this);
            temp.add(value);
            return temp;
        }
    }

}
