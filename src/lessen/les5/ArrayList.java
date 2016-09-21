package lessen.les5;

/**
 * Created by thom on 16-9-2016.
 */
public class ArrayList {
    int size = 10;
    int[] array = new int[size];
    int length = -1;
    public void add(int value){
        if(length +1 >= size) {
            int[] tempArray = array.clone();
            size = size*2;
            array = new int[size];
            for(int i = 0; i < length; i++) {
                array[i] = tempArray[i];
            }
        }
        length++;
        array[length] = value;
    }

    public int get(int index) {
        if(index > length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public int size() {
        return length;
    }

    public void set(int index, int value) {
        if(index > length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }
}
