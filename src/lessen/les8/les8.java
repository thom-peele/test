package lessen.les8;

/**
 * Created by thom on 3-10-2016.
 */
public class les8 {
    public static void main(String[] args) {
//        HANTree<String> hanTree = new HANTree<String>("test1");
//        System.out.println(hanTree.toString());
        Integer[] test = {1, 3, 8, 10, 19, 22, 24, 32, 33,34,44,45,50,62,68,77,78,90,91,92,93,94,95,96,97};
//        Integer[] test = {1, 3, 8,10,19,22,23,44,45,46,47};
        Integer test2 = 3;
        BinarySearchTree<Integer> BST = new BinarySearchTree<>(test[1]);
//        BST.getRoot().addNewNode(test[0]);
//        BST.getRoot().addNewNode(test[4]);
//        BST.getRoot().addNewNode(test[3]);
//        BST.getRoot().addNewNode(test[5]);
        BST = fromSortedArray(test);

        System.out.println(BST.getRoot().toString());


    }

    public static <T> BinarySearchTree<T> fromSortedArray(T[] input) {
        BinarySearchTree<T> bst = new BinarySearchTree<T>(input[input.length/2]);
        bst.getRoot().fromSortedArray(input,0, input.length);
        return bst;
    }
}
