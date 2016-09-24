package lessen.les5;

/**
 * Created by thom
 * On 24-9-2016
 */
public class HANStackArray<T> {
    ArrayList<T> list = null;

    public HANStackArray() {
        list = new ArrayList<T>();
    }

    /**
     * Push - adds the value on top of the new/existing stack.
     * @param value
     */
    public void push(T value) {
        if(list.size() == 0){
            list.add(value);
        } else {
            list.set(list.size(), value);
        }
    }

    /**
     * Pop - pops out the last added value of the stack and returns it.
     * So this item is removed from the stack now.
     * @return value
     */
    public T pop() {
        T temp = list.get(list.size()-1);
        list.delete(list.size()-1);
        return temp;
    }

    /**
     * Top - also known as peek returns the last added item.
     * The item will remain in the stack though.
     * @return value
     */
    public T top() {
        return list.get(list.size()-1);
    }

    /**
     * GetSize - returns the current size of the stack.
     * @return
     */
    public int getSize() {
        return list.size();

    }


    /**
     * @return representation of values in stack.
     */
    @Override
    public String toString() {
        String temp = "______\n";
        for(int i = list.size(); i > 0; i--) {
            temp += "| " + list.get(i).toString() + " |\n______\n";
        }
        return temp;
    }
}
