package lessen.les8;

import java.util.Arrays;

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
//        Integer[] test = {1, 3, 8, 10, 19, 22, 24, 32, 33,34,44,45,50,62,68,77,78,90,91,92,93,94,95,96,97};
        Integer[] test = {1, 3, 8,10,19,22,23,44,45,46,47};

        BinaryTree<Integer> toetsTree = fromSortedArray(test);

//        System.out.println(tree.min(tree.getRoot()));
//        System.out.println(tree.max(tree.getRoot()));
        System.out.println(toetsTree.toString(toetsTree.getRoot()));
        System.out.println(toetsTree.getRoot().toString("   "));
    }

    Node root;

    public static <T> T[] quickSortArray(T[] input) {

        return null;
    }

    public static <T> BinaryTree<T> fromSortedArray(T[] input) {
        BinaryTree<T> binaryTree = new BinaryTree<T>();
//        input = quickSortArray(input);
        input = returnMiddles(input);
        System.out.println(Arrays.toString(input));
        for(int i = 0; i <= input.length-1; i++) {
            System.out.println(input[i]);
            binaryTree.addNode(Integer.parseInt(input[i].toString()),input[i]);
        }
        return binaryTree;
    }

    public static <T> T[] returnMiddles(T[] input) {
        if(input.length > 2) {
            int evenAdjustment = -1;
            if(input.length % 2 != 0) {
                evenAdjustment = 0;
//                rechts lengte + 1
            }
            T[] links = (T[]) new Object[((input.length) / 2)];
            T[] rechts = (T[]) new Object[((input.length) / 2) + evenAdjustment];
            T[] temp = (T[]) new Object[input.length];
            System.arraycopy(input, 0, links, 0, ((input.length) / 2));
            System.arraycopy(input, ((input.length) / 2) + 1, rechts, 0, ((input.length) / 2) + evenAdjustment);
            links = returnMiddles(links);
            rechts = returnMiddles(rechts);
            temp[0] = input[((input.length) / 2)];
            System.out.println("input length: " + input.length);
            System.out.println("templength: " + temp.length + " val middle: " + temp[0]);
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
        String left = toString(root.leftChild);
        String middle = root.name.toString();
        String right = toString(root.rightChild);
        System.out.println(root.toString("  "));
        if(!left.equals("")) {
            result += " left child: " + left;
        }
        result += " root: " + middle;
        if(!right.equals("")) {
            result += " right child: " + right;
        }


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

        public boolean isLeftLeaf() {
            if(leftChild != null && (leftChild.leftChild != null || leftChild.rightChild != null)) {
                return false;
            }
            return true;
        }
        public boolean isRightLeaf() {
            if(rightChild != null && (rightChild.leftChild != null || rightChild.rightChild != null)) {
                return false;
            }
            return true;
        }
        public Node getNode() {
            return this;
        }

        public String toString(String tab) {
            if(this.leftChild == null && this.rightChild == null) {
                tab = tab.replace("│", "");
                tab = tab.replace("│", "");
                return tab + key;
            }
            String alles = "";
            if(this.leftChild != null) {
                String tmp = "";
                if(!isLeftLeaf()) {
                    tmp = "  │";
                } else {
                    tmp = "┌";
                }
                alles += "\n" + tab + leftChild.toString(tab+tmp);
                alles += "\n" + tab +  "   │";
            }
            String temp = tab;
            if(tab.indexOf('└') > 0) {
                temp = temp.replace(tab.substring(tab.indexOf('└')+1, tab.length()),"");
            } else if(tab.indexOf('┌')> 0) {
                temp = temp.replace(tab.substring(tab.indexOf('┌')+1, tab.length()),"");
            }
            temp= temp.replace("│", "");
            alles += temp + key + "─┤";

            if(rightChild != null) {
                String tmp = "";
                if(!isRightLeaf()) {
                    tmp = "  │";
                } else {
                    tmp = "└";
                }
                alles += "\n" + tab +  "   │";
                alles += "\n" + tab + rightChild.toString(tab+tmp);
            }
            return alles;
        }
//        public void print() {
//            print("", true);
//        }

//        private void print(String prefix, boolean isTail) {
//            System.out.println(prefix + (isTail ? "└── " : "├── ") + name);
//            for (int i = 0; i < children.size() - 1; i++) {
//                children.get(i).print(prefix + (isTail ? "    " : "│   "), false);
//            }
//            if (children.size() > 0) {
//                children.get(children.size() - 1)
//                        .print(prefix + (isTail ?"    " : "│   "), true);
//            }
//        }
    }
}
