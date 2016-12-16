package lessen.les8;

import java.util.Random;

/**
 * Created by thom
 * On 06-12-2016.
 */
public class les8 {
    public static void main(String[] args) {
//        HANTree<String> hanTree = new HANTree<String>("test1");
//        System.out.println(hanTree.toString());
        Integer[] test = {1, 3, 8, 10, 19, 22, 24, 32, 33,34,44,45,50,62,68,77,78,90,91,92,93,94,95,96,97};
//        Integer[] test = {1, 3, 8,10,19,22,23,44,45,46,47};
        Integer test2 = 3;
        BinarySearchTree<Integer> BST = new BinarySearchTree<>(test[1]);
        BST = fromSortedArray(test);


        System.out.println(BST.getRoot().toString());
        Random rand = new Random();
        FCNSTree fcnsTree = new FCNSTree(Integer.valueOf(rand.nextInt(20)));
        Integer[] test3 = {};
        for(int i = 0; i < 20; i++) {
            int randomNumber = rand.nextInt(20);
            test3[i] = randomNumber;
            fcnsTree.root.

        }


    }

    public static <T> BinarySearchTree<T> fromSortedArray(T[] input) {
        BinarySearchTree<T> bst = new BinarySearchTree<T>(input[input.length/2]);
        bst.getRoot().fromSortedArray(input,0, input.length);
        return bst;
    }
}
