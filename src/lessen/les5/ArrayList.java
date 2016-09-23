package lessen.les5;

/**
 * Created by thom on 23-9-2016.
 */
public class ArrayList<T> {
    int size = 10;
    int length = -1;
    ArrayListNode<T>[] listNodes;

    ArrayList() {
        listNodes = new ArrayListNode[size];
    }


    public void add(T value){
        if(length +1 >= size) {
            ArrayListNode[] tempArray = listNodes.clone();
            size = size*2;
            listNodes = new ArrayListNode[size];
            for(int i = 0; i < length; i++) {
                listNodes[i] = tempArray[i];
            }
        }
        length++;
        listNodes[length] = new ArrayListNode<T>(value);
    }

    public T get(int index) {
        if(index > length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return listNodes[index].getValue();
    }

    public int size() {
        return length;
    }

    public void set(int index, T value) {
        if(index > length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        listNodes[index].setValue(value);
    }
}
