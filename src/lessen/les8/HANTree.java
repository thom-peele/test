package lessen.les8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thom on 3-10-2016.
 */
public class HANTree<T> {

    Node root;

    public HANTree(T rootData) {
        root = new Node<T>(rootData, null);
    }

    public String toString() {
        return root.toString();
    }

    static class Node<T> {
        public T data;
        public Node<T> parent;
        public List<Node> children;

        public Node(T data, Node<T> parent) {
            this.data = data;
            this.parent = parent;
            children = new ArrayList<>();
        }

        public void addChild(Node n) {
            children.add(n);
        }

        public String toString() {
            String result = "";
            for(Node n : children) {
                result += n.data;
            }
            return result;
        }
    }
}

