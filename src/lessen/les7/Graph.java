package lessen.les7;

/**
 * Created by thom on 27-9-2016.
 */
public class Graph {
    public static final double INFINITY = Double.MAX_VALUE;
    public void addEdge( String sourceName, String destName, double cost ){
        /* Figure 14.10 */
    }
    public void printPath( String destName ) { /* Figure 14.13 */ }
    public void unweighted( String startName ) { /* Figure 14.22 */ }
    public void dijkstra( String startName ) { /* Figure 14.27 */ }
    public void negative( String startName ) { /* Figure 14.29 */ }
    public void acyclic( String startName ) { /* Figure 14.32 */ }
//    private Vertex getVertex( String vertexName ) { /* Figure 14.9 */ }
    private void printPath( Vertex dest ) { /* Figure 14.12 */ }
    private void clearAll( ) { /* Figure 14.11 */ }
//    private Map<String,Vertex> vertexMap = new HashMap<String,Vertex>( );
}

    // Used to signal violations of preconditions for
    // various shortest path algorithms.
    class GraphException extends RuntimeException {
        public GraphException( String name ) {
            super( name );
        }
}
