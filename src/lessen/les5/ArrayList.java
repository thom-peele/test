package lessen.les5;

/**
 * Created by thom on 23-9-2016.
 */
public class ArrayList<T> {
    int size = 10;
    int length = 0;
    ArrayListNode<T>[] listNodes;

    public ArrayList() {
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

        listNodes[length] = new ArrayListNode<T>(value);
        length++;
    }

    public T get(int index) {
        if(index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return listNodes[index].getValue();
    }

    public void delete(int index) {
        if(index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            length --;
            for(int i = index; i < length; i++) {
                listNodes[i] = listNodes[i+1];
            }
        }
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

    /**
     * @return String of stored values
     */
    @Override
    public String toString() {
        String temp = "[";
        for(int i = 0; i < length; i++) {
            if(i != 0) {
                temp += ",";
            }
            temp += listNodes[i].toString();
        }
        return temp + "]";
    }
}
