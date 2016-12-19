package herkansing;


/**
 * Created by thom
 * On 16-12-2016.
 */
public class main {
    public static void main(String[] args) {

        System.out.println("------ opd 1 a -----");
        SLList slList = new SLList(13);
        slList.add(1);
        slList.add(1984);
        System.out.println(slList.toString());

        System.out.println("------ opd 1 b -----");
        SLList reversedList = slList.getReversedSLList();
        System.out.println(reversedList.toString());

        System.out.println("------ opd 1 c -----");
        SLQueue slQueue = new SLQueue();
        slQueue.enqueue("A");
        slQueue.enqueue("B");
        slQueue.enqueue("C");
        slQueue.dequeue();
        slQueue.enqueue("D");
        slQueue.enqueue("E");
        System.out.println(slQueue.toString());

        System.out.println("------ opd 2 a -----");

        ThomGraph<String> graph = new ThomGraph("Woonkamer");
        graph.addVertex("hal");
        graph.addVertex("keuken");
        graph.addVertex("wc");
        graph.addVertex("woonkamer");
        graph.addVertex("bergin");
        graph.addEdge("woonkamer", "hal", 4);
        graph.addEdge("hal", "keuken", 2);
        graph.addEdge("hal", "wc", 1);
        graph.addEdge("woonkamer", "keuken", 5);
        graph.addEdge("keuken", "berging", 3);
        graph.addEdge("berging", "hal", 4);
        graph.setUnweighted("hal");
        graph.getPath("berging");
        graph.toString();

    }
}
