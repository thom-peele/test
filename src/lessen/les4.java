package lessen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thom on 13-9-2016.
 */
public class les4 {
    public static void main(String[] args) {
        System.out.println("----------------\nopdracht: 4.4: autoboxing is het bijvoorbeeld het type Integer gebruiken als type voor een compareable. \n " +
                "\t unboxing is het uitpakken van een (bovenstaande) box.(uitlezen van de waarde/ometten naar een primitive)");
        System.out.println("----------------\nopdracht: 4.11: before java 5 manual boxing, after java 5 type Type-Parametrisation");
        System.out.println("----------------\n opdracht: 4.33:");
        int[] unsortedList = {8,6,0,7,5,3,1};
        ArrayList<Square> squares = new ArrayList<Square>();
        ArrayList<String> dummyStrings = new ArrayList<String>();
        for (int unsortedInt : unsortedList) {
            squares.add(new Square(unsortedInt));
            dummyStrings.add("DummyString nummer: " + unsortedInt);
        }
//        lessen.Square square1 = new lessen.Square(1);
//        for (lessen.Square square : squares) {
//            System.out.println(square.compareTo(square1));
//        }
        Collections.sort(squares);
        System.out.println(squares);
        System.out.println("----------------\nopdracht: 4.24: " + min(dummyStrings));

        MemoryCell memoryCell1 = new MemoryCell();
        MemoryCell memoryCell2 = new MemoryCell();
        memoryCell1.write("test1");
        memoryCell2.write("test0");
        System.out.println(memoryCell1.compareTo(memoryCell2));


    }


    /**
     * function for getting smallest item from a List
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T min(List<T> list) {
        if (list.isEmpty()) {
            return null;
        } else {
            T smallestItem = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if(smallestItem.compareTo(list.get(i)) > 0) {
                    smallestItem = list.get(i);
                }
            }
            return smallestItem;
        }
    }

    public static <T extends Comparable<T>> T selectSmallest(T[] a) {
        int smallest = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[smallest])<=0) {
                smallest = i;
            }
        }
        return a[smallest];
    }
}


class Shape {
    protected int area;

    public int getArea(){
        return area;
    }
}


class Square extends Shape implements Comparable<Square> {

    Square(int area) {
        this.area = area;
    }

    @Override
    public int compareTo(Square other) {
        area = this.getArea();
        if (area == other.getArea()) return 0;
        if (area > other.getArea()) return 1;
        return -1;
    }

    @Override
    public int getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "lessen.Square size: " + area;
    }
}
