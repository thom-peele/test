package lessen.les8;

import java.util.LinkedList;
import java.util.List;

public class FCNSTree<T> {

    Node<T> root;

    public FCNSTree(T headerdata) {
        root = new Node<>(headerdata, null);
    }

    static class Node<T> {
        List<Node> children;
        T data;
        Node<T> parent;

        public Node(T data, Node<T> parent) {
            children = new LinkedList<>();
            this.data = data;
            this.parent = parent;
        }

        public List<Node> getChildren() {
            return children;
        }

        public Node<T> addChild(T data, Node<T> parent) {
            Node<T> newNode = new Node<>(data, parent);
            children.add(newNode);
            return newNode;
        }
    }
}
