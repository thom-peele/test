package lessen.les5;

/**
 * Created by thom
 * On 21-9-2016
 */


public class HANStack<T> {

    HANLinkedList<T> hanLinkedList = null;

    public HANStack() {
        hanLinkedList = new HANLinkedList<T>();
    }

    /**
     * Push - adds the value on top of the new/existing stack.
     * @param value
     */
    public void push(T value) {
        if(hanLinkedList.size() == 0){
            hanLinkedList.addFirst(value);
        } else {
            hanLinkedList.insert(hanLinkedList.size(), value);
        }
    }

    /**
     * Pop - pops out the last added value of the stack and returns it.
     * So this item is removed from the stack now.
     * @return value
     */
    public T pop() {
        T temp = hanLinkedList.get(hanLinkedList.size());
        hanLinkedList.delete(hanLinkedList.size());
        return temp;
    }

    /**
     * Top - also known as peek returns the last added item.
     * The item will remain in the stack though.
     * @return value
     */
    public T top() {
        return hanLinkedList.get(hanLinkedList.size());
    }

    /**
     * GetSize - returns the current size of the stack.
     * @return
     */
    public int getSize() {
        return hanLinkedList.size();
    }

    /**
     * @return representation of values in stack.
     */
    @Override
    public String toString() {
        String temp = "______\n";
        for(int i = hanLinkedList.size(); i > 0; i--) {
            temp += "| " + hanLinkedList.get(i).toString() + " |\n______\n";
        }
        return temp;
    }
}
