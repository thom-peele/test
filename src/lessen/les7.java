package lessen;

import lessen.les5.HANLinkedList;

/**
 * Created by thom on 20-9-2016.
 */
public class les7 {
    public static void main(String[] args) {
        System.out.println("2: index " + hashTableIndex(2,11));
        System.out.println("4: index " + hashTableIndex(4,11));
        System.out.println("5: index " + hashTableIndex(5,11));
        System.out.println("1: index " + hashTableIndex(1,11));
        System.out.println("8: index " + hashTableIndex(8,11));
        System.out.println("14: index " + hashTableIndex(14,11));
        System.out.println("12: index " + hashTableIndex(12,11));

        HANLinkedList<String> hanLinkedList = new HANLinkedList<String>();
    }

    public static int hashTableIndex(int input, int hashTableSize){
        return (input*7) % hashTableSize;
    }
}
