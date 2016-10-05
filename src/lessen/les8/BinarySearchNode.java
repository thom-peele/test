package lessen.les8;

/**
 * Created by thom on 5-10-2016.
 */
public class BinarySearchNode<T> {
    private T value;
    private BinarySearchNode<T> leftChild;
    private BinarySearchNode<T> rightChild;

    public void addNewNode(T value) {
        int rootValueKey = Integer.parseInt(this.value.toString());
        int newValueKey = Integer.parseInt(value.toString());
        if(rootValueKey < newValueKey) {
            if (rightChild != null) {
                rightChild.addNewNode(value);
            } else {
                rightChild = new BinarySearchNode<T>(value);
            }
        } else if(rootValueKey > newValueKey) {
            if(leftChild != null) {
                leftChild.addNewNode(value);
            } else {
                leftChild = new BinarySearchNode<T>(value);
            }
        }
    }

    public void fromSortedArray(T[] input, int startIndex, int endIndex) {
        if((endIndex - startIndex) > 0) {
            this.addNewNode(input[((endIndex - startIndex) / 2) + startIndex]);
            this.fromSortedArray(input, startIndex, startIndex + ((endIndex - startIndex) / 2));
            this.fromSortedArray(input, startIndex + ((endIndex - startIndex) / 2) + 1, endIndex);
        }
    }

    public String toString() {
        return printTree("", true, true);
    }

    /**
     * printTree - returns an ascii representation of the total tree.
     * all pararms are for recursive use so set them "",true,true
     * @param prefix
     * @param isTail
     * @param isRight
     * @return
     */
    private String printTree(String prefix, boolean isTail, boolean isRight) {
        String tree = "";
        if(leftChild== null && rightChild == null) {
            isTail = true;
        }
        if(leftChild != null) {
            tree += leftChild.printTree(prefix + (isTail ? "    " : "│   "), false, false);
        }
        tree += "\n" + prefix + (isRight ? "└── ":"┌──") + value.toString();
        if(rightChild != null) {
            tree += rightChild.printTree(prefix + (isTail ? "    " : "│   "), false, true);
        }
        return tree;
    }

    public BinarySearchNode(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinarySearchNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinarySearchNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinarySearchNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinarySearchNode<T> rightChild) {
        this.rightChild = rightChild;
    }



}
