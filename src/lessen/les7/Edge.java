package lessen.les7;

/**
 * Created by thom on 27-9-2016.
 */
public class Edge {
    // Represents an edge in the graph.
    public Vertex dest;        // Second vertex in Edge
    public double cost;        // Edge cost
    public Edge( Vertex d, double c ) {
        dest = d;
        cost = c;
    }
}
