package lessen.les8;

public class BinaryTree<T> {

    public static void main(String[] args) {
//        BinaryTree<String> tree = new BinaryTree<>();
//        tree.addNode(1, "1 ");
//        tree.addNode(3, "3 ");
//        tree.addNode(8, "8 ");
//        tree.addNode(10, "10 ");
//        tree.addNode(19, "19 ");
//        tree.addNode(22, "22 ");
//        tree.addNode(32, "32 ");
        Integer[] test = {1, 3, 8, 10, 19, 22, 22, 32};
        BinaryTree<Integer> toetsTree = fromSortedArray(test);

//        System.out.println(tree.min(tree.getRoot()));
//        System.out.println(tree.max(tree.getRoot()));
        System.out.println(toetsTree.toString(toetsTree.getRoot()));
    }

    Node root;

    public static <T> T[] quickSortArray(T[] input) {

        return null;
    }

    public static <T> BinaryTree<T> fromSortedArray(T[] input) {
        BinaryTree<T> binaryTree = new BinaryTree<T>();
//        input = quickSortArray(input);
        input = returnMiddles(input);
//        System.out.println(Integer.parseInt(input[0].toString()));
        for(int i = 0; i < input.length-1; i++) {
            System.out.println(input[i]);
            binaryTree.addNode(Integer.parseInt(input[i].toString()),input[i]);
        }
        return binaryTree;
    }

    public static <T> T[] returnMiddles(T[] input) {
        if(input.length > 2) {
            T[] links = (T[]) new Object[((input.length) / 2)-1];
            T[] rechts = (T[]) new Object[((input.length) / 2)];
            T[] temp = (T[]) new Object[input.length];
            System.arraycopy(input, 0, links, 0, ((input.length) / 2) - 1);
            System.arraycopy(input, ((input.length) / 2) + 1, rechts, 0, ((input.length) / 2) - 1);
            links = returnMiddles(links);
            rechts = returnMiddles(rechts);
            temp[0] = input[((input.length) / 2)];
            System.out.println("input length: " + input.length);
            System.out.println("templength: " + temp.length);
            System.out.println("linkslength: " + links.length);
            System.out.println("rechtslength: " + rechts.length);
            System.arraycopy(links, 0, temp, 1, links.length);

            System.arraycopy(rechts, 0, temp, links.length + 1, rechts.length);
            return temp;
        }
        return input;

        /**
         *  grafen als matrix:
         *  maak een classe die een graaf als matrix(dubbele array) van edges representateert.
         *  voeg een methode toe aan je huiswerk gemaakte graph klasse die de graaf naar de matrixrepresentatie converteert
         *  verzin en werk een algoritme uit die adhv de matrix kan zien of een graaf wel of niet verbonden is, negeer hierbij de richting.
         *  maak alle sorteer algoritme generic
         *  werk de trees uit.
         *
         */

    }

    public void addNode(int key, T name) {
        Node newNode = new Node(key, name);

        if(root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;

            while(true) {

                parent = focusNode;

                if(key < focusNode.key) {

                    focusNode = focusNode.leftChild;

                    if(focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;

                    if(focusNode == null) {

                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findNode(int key) {
        Node focus = root;

        while(focus.key != key) {
            if(key < focus.key) {
                focus = focus.leftChild;
            } else {
                focus = focus.rightChild;
            }

            if(focus == null) {
                return null;
            }
        }
        return focus;
    }

    public Node getRoot() {
        return root;
    }

    int min(Node n){
        if (n.leftChild == null)
            return n.key;
        return min(n.leftChild);
    }

    int max(Node n){
        if (n.rightChild == null)
            return n.key;
        return max(n.rightChild);
    }

    private String toString(Node root)
    {
        String result = "";
        if (root == null)
            return "";
        result += "left child: " + toString(root.leftChild);
        result += root.name.toString();
        result += "right child: " + toString(root.rightChild);


        return result;
    }

    class Node {
        int key;
        T name;
        Node leftChild;
        Node rightChild;

        Node(int key, T name){
            this.key = key;
            this.name = name;
        }

        public Node getNode() {
            return this;
        }

        public String toString() {
            String alles = "";
            alles += name.toString() + " has the key " + key;
            if(this.leftChild != null) {
                alles += " and leftchild: " + leftChild.name;
            }
            if(rightChild != null) {
                alles += " and rightchild: " + rightChild.name;
            }
            return alles;
        }
    }
}
