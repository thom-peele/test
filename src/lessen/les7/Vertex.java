package lessen.les7;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by thom on 27-9-2016.
 */
public class Vertex {
    public String     name;   // Vertex name
    public List<Edge> adj;    // Adjacent vertices
    public double     dist;   // Cost
    public Vertex     prev;   // Previous vertex on shortest path
    public int        scratch;// Extra variable used in algorithm
    public Vertex( String nm ) {
        name = nm; adj = new LinkedList<Edge>( );
        reset( );
    }
    public void reset() {
        dist = Graph.INFINITY;
        prev = null;
//        pos = null;
        scratch = 0;
    }
}
