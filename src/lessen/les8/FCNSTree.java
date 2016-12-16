package lessen.les8;

public class FCNSTree<T> {

    Node<T> root;

    public FCNSTree(T headerdata) {
        root = new Node<>(headerdata);
    }

    static class Node<T> {
        Node child;
        Node sibling;
        T data;

        public Node(T data) {
            this.data = data;
        }

        public void add(T data) {
            if(child == null) {
                child = new Node(data);
            } else if(sibling != null) {
                sibling = new Node(data);
            } else {
                sibling.add(data);
            }
        }

        public void addChild(T data) {
            child = new Node(data);
        }

        public void addSibling(T data){
            this.sibling = new Node(data);
        }


        public Node getChild() {
            return child;
        }

        public Node getSibling() {
            return sibling;
        }

        public T getData() {
            return data;
        }
    }
}
