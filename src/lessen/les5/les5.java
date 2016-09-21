package lessen.les5;

/**
 * Created by thom on 14-9-2016.
 */
public class les5 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for(int i = 0; i <= 20; i++) {
            arrayList.add(2);
        }
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(0));

        HANLinkedList hanLinkedList = new HANLinkedList(String.class);
        hanLinkedList.addFirst("test2");
        hanLinkedList.addFirst("test4");
        System.out.println(hanLinkedList.get(1));
        System.out.println(hanLinkedList.get(2));


    }

}
