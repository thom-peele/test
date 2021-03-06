package lessen.les7;

import java.util.*;

/**
 * Created by thom on 27-9-2016.
 */
public class Graph<T> {
    public static final double INFINITY = Double.MAX_VALUE;

    private Map<String,Vertex> vertexMap = new HashMap<String,Vertex>( );
//
//    /**
//     * Add a new edge to the graph.
//     */
//    public void addEdge( T source, T dest, double cost ) {
//        Vertex v = getVertex( source );
//        Vertex w = getVertex( dest );
//        v.adj.add( new Edge( w, cost ) );
//    }
//
//    /**
//     * Driver routine to handle unreachables and print total cost.
//     * It calls recursive routine to print shortest path to
//     * destNode after a shortest path algorithm has run.
//     */
//    public void printPath( String destName ) {
//        Vertex w = vertexMap.get( destName );
//        if( w == null )
//            throw new NoSuchElementException( );
//        else if( w.dist == INFINITY )
//            System.out.println( destName + " is unreachable" );
//        else {
//            System.out.print( "(Cost is: " + w.dist + ") " );
//            printPath( w );
//            System.out.println( );
//        }
//    }
//
//    /**
//     * Single-source unweighted shortest-path algorithm.
//     */
//    public void unweighted( String startName ) {
//        clearAll( );
//        Vertex start = vertexMap.get( startName );
//        if( start == null )
//            throw new NoSuchElementException( "Start vertex not found" );
//        Queue<Vertex> q = new LinkedList<Vertex>( );
//        q.add( start ); start.dist = 0;
//        while( !q.isEmpty( ) ) {
//            Vertex v = q.remove( );
//            for( Edge e : v.adj ) {
//                Vertex w = e.dest;
//                if( w.dist == INFINITY ) {
//                    w.dist = v.dist + 1;
//                    w.prev = v;
//                    q.add( w );
//                }
//            }
//        }
//    }
//
//    /**
//     * Single-source weighted shortest-path algorithm.
//     */
//    public void dijkstra( String startName ) {
//        PriorityQueue<Path> pq = new PriorityQueue<Path>( );
//        Vertex start = vertexMap.get( startName );
//        if( start == null )
//            throw new NoSuchElementException( "Start vertex not found" );
//        clearAll( );
//        pq.add( new Path( start, 0 ) );
//        start.dist = 0;
//        int nodesSeen = 0;
//        while( !pq.isEmpty( ) && nodesSeen < vertexMap.size( ) ) {
//            Path vrec = pq.remove( );
//            Vertex v = vrec.dest;
//            if( v.scratch != 0 )  // already processed v
//            continue;
//            v.scratch = 1;
//            nodesSeen++;
//            for( Edge e : v.adj ) {
//                Vertex w = e.dest;
//                double cvw = e.cost;
//                if( cvw < 0 )
//                    throw new GraphException( "Graph has negative edges" );
//                if( w.dist > v.dist + cvw ) {
//                    w.dist = v.dist + cvw;
//                    w.prev = v;
//                    pq.add( new Path( w, w.dist ) );
//                }
//            }
//        }
//    }
//
//    /**
//     * Single-source negative-weighted shortest-path algorithm.
//     */
//    public void negative( String startName ) {
//        clearAll();
//        Vertex start = vertexMap.get(startName);
//        if (start == null)
//            throw new NoSuchElementException("Start vertex not found");
//        Queue<Vertex> q = new LinkedList<Vertex>();
//        q.add(start);
//        start.dist = 0;
//        start.scratch++;
//        while (!q.isEmpty()) {
//            Vertex v = q.remove();
//            if (v.scratch++ > 2 * vertexMap.size())
//                throw new GraphException("Negative cycle detected");
//            for (Edge e : v.adj) {
//                Vertex w = e.dest;
//                double cvw = e.cost;
//                if (w.dist > v.dist + cvw) {
//                    w.dist = v.dist + cvw;
//                    w.prev = v;
//                    // Enqueue only if not already on the queue
//                    if (w.scratch++ % 2 == 0)
//                        q.add(w);
//                    else
//                        w.scratch--;  // undo the enqueue increment
//                }
//            }
//        }
//    }
//
//    /**
//     * Single-source negative-weighted acyclic-graph shortest-path algorithm.
//     */
//    public void acyclic( String startName ) {
//        Vertex start = vertexMap.get( startName );
//        if( start == null )
//            throw new NoSuchElementException( "Start vertex not found" );
//        clearAll( );
//        Queue<Vertex> q = new LinkedList<Vertex>( );
//        start.dist = 0;
//        // Compute the indegrees
//        Collection<Vertex> vertexSet = vertexMap.values( );
//        for( Vertex v : vertexSet )
//            for( Edge e : v.adj )
//                e.dest.scratch++;
//
//        // Enqueue vertices of indegree zero
//        for( Vertex v : vertexSet )
//            if( v.scratch == 0 )
//                q.add( v );
//        int iterations;
//        for( iterations = 0; !q.isEmpty( ); iterations++ ) {
//            Vertex v = q.remove( );
//            for( Edge e : v.adj ) {
//                Vertex w = e.dest;
//                double cvw = e.cost;
//                if( --w.scratch == 0 )
//                    q.add( w );
//                if( v.dist == INFINITY )
//                    continue;
//                if( w.dist > v.dist + cvw ) {
//                    w.dist = v.dist + cvw;
//                    w.prev = v;
//                }
//            }
//        }
//        if( iterations != vertexMap.size( ) )
//            throw new GraphException( "Graph has a cycle!" );
//    }
//
//    /**
//     * If vertexName is not present, add it to vertexMap.
//     * In either case, return the Vertex.
//     */
//    private Vertex<T> getVertex( T vertexName ) {
//        Vertex v = vertexMap.get( vertexName );
//        if( v == null ) {
//            v = new Vertex( vertexName );
//            vertexMap.put( vertexName.toString(), v );
//        }
//        return v;
//    }
//
//    /**
//     * Recursive routine to print shortest path to dest
//     * after running shortest path algorithm. The path
//     * is known to exist.
//     */
//    private void printPath( Vertex dest ) {
//        if( dest.prev != null ) {
//            printPath( dest.prev );
//            System.out.print( " to " );
//        }
//        System.out.print( dest.name );
//    }
//
//    /**
//     *  Initializes the vertex output info prior to running
//     *  any shortest path algorithm.
//     */
//    private void clearAll( ) {
//        for( Vertex v : vertexMap.values( ) )
//            v.reset( );
//    }
}

    // Used to signal violations of preconditions for
    // various shortest path algorithms.
    class GraphException extends RuntimeException {
        public GraphException( String name ) {
            super( name );
        }
}
