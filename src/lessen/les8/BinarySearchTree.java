package lessen.les8;

/**
 * Created by thom on 5-10-2016.
 */
public class BinarySearchTree<T> {
    private BinarySearchNode root;

    public BinarySearchTree(T rootValue) {
        this.root = new BinarySearchNode<T>(rootValue);
    }

    public BinarySearchNode getRoot() {
        return root;
    }

    public void setRoot(BinarySearchNode root) {
        this.root = root;
    }
}
