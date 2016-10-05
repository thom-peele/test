package lessen.les8;

/**
 * Created by thom on 3-10-2016.
 */
public class les8 {
    public static void main(String[] args) {
//        HANTree<String> hanTree = new HANTree<String>("test1");
//        System.out.println(hanTree.toString());
        Integer[] test = {1, 3, 8,10,19,22,23,44,45,46,47};
        Integer test2 = 3;
        BinarySearchTree<Integer> BST = new BinarySearchTree<>(test[1]);
        BST.getRoot().addNewNode(test[0]);
        BST.getRoot().addNewNode(test[4]);
        BST.getRoot().addNewNode(test[3]);
        BST.getRoot().addNewNode(test[5]);
        BST = fromSortedArray(test);

        System.out.println(BST.getRoot().toString());
        System.out.println(BST.getRoot().getValue());
        System.out.println(test[1].toString().compareTo(test[2].toString()));
        System.out.println(BST.getRoot().getLeftChild().getValue());

    }

    public static <T> BinarySearchTree<T> fromSortedArray(T[] input) {
        BinarySearchTree<T> bst = new BinarySearchTree<T>(input[input.length/2]);
        bst.getRoot().fromSortedArray(input,0, input.length);
        return bst;
    }
}
