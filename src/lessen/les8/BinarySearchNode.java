package lessen.les8;

/**
 * Created by thom on 5-10-2016.
 */
public class BinarySearchNode<T> {
    private T value;
    private BinarySearchNode<T> leftChild;
    private BinarySearchNode<T> rightChild;

    public void addNewNode(T value) {
        System.out.println("value: " + this.value.toString()+ " compareto : " + value.toString() + " = " + this.value.toString().compareTo(value.toString()));
        if(this.value.toString().compareTo(value.toString()) > 0) {
            if(rightChild != null) {
                rightChild.addNewNode(value);
            } else {
                rightChild = new BinarySearchNode<T>(value);
            }
        } else if(this.value.toString().compareTo(value.toString()) < 0) {
            if(leftChild != null) {
                leftChild.addNewNode(value);
            } else {
                leftChild = new BinarySearchNode<T>(value);
            }
        }
    }

    public void fromSortedArray(T[] input, int startIndex, int endIndex) {
        if((endIndex - startIndex) > 0) {
            System.out.println(endIndex - startIndex);
            this.addNewNode(input[((endIndex - startIndex) / 2) + startIndex]);
            this.fromSortedArray(input, startIndex, startIndex + ((endIndex - startIndex) / 2));
            this.fromSortedArray(input, startIndex + ((endIndex - startIndex) / 2) + 1, endIndex);
        }
    }

    public String toString() {
        return "root: " + value + "\n" +(leftChild != null? " leftchild: "+ leftChild.toString():"")+(rightChild != null? " rightchild:"+ rightChild.toString():"") ;
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
