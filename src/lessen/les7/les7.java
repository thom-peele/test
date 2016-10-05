package lessen.les7;

/**
 * Created by thom on 20-9-2016.
 */
public class les7 {
    public static void main(String[] args) {

//        hashTableTest();

        graphTest();

    }

    /**
     * function to create a basic graph
     */
    private static void graphTest() {
        Graph graph = new Graph();
        graph.addEdge("test","test2",3);
        graph.addEdge("test","test3",3);
        graph.addEdge("test3","test2",3);
        graph.addEdge("test2", "test4",2);
        graph.unweighted("test");
        graph.printPath("test4");
    }

    /**
     * function to test some hashtable vars and prints the indexes of them
     */
    private static void hashTableTest() {
        System.out.println("2: index " + hashTableIndex(2,11));
        System.out.println("4: index " + hashTableIndex(4,11));
        System.out.println("5: index " + hashTableIndex(5,11));
        System.out.println("1: index " + hashTableIndex(1,11));
        System.out.println("8: index " + hashTableIndex(8,11));
        System.out.println("14: index " + hashTableIndex(14,11));
        System.out.println("12: index " + hashTableIndex(12,11));
    }

    /**
     * simple calculate function for the hashtable index
     * @param input
     * @param hashTableSize
     * @return
     */
    private static int hashTableIndex(int input, int hashTableSize){
        return (input*7) % hashTableSize;
    }
}
