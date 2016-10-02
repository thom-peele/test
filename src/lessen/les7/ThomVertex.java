package lessen.les7;


import lessen.les5.HANLinkedList;

/**
 * Created by thom
 * On 30-9-2016
 */
public class ThomVertex {
    private String name;             // Vertex name
    private HANLinkedList<ThomEdge> adj; // Adjacent vertices
    private double dist;             // Cost
    private ThomVertex prev;         // Previous vertex on shortest path
    private int scratch;             // Extra variable used in algorithm

    /**
     * ThomVertex - only creates new vertex and starts new linkedlist.
     * @param name
     */
    public ThomVertex(String name) {
        this.name = name;
        adj = new HANLinkedList<ThomEdge>();
        reset( );
    }

    /**
     * reset - resets the distances.
     */
    public void reset() {
        dist = Graph.INFINITY;
        prev = null;
//        pos = null;
        scratch = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HANLinkedList<ThomEdge> getAdj() {
        return adj;
    }

    /**
     * addAdj - adds new edge to vertex.
     * @param destVertex
     * @param cost
     */
    public void addAdj(ThomVertex destVertex, double cost) {
        adj.insert(adj.size(), new ThomEdge(destVertex, cost));
    }

    public void setAdj(HANLinkedList<ThomEdge> adj) {
        this.adj = adj;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    public ThomVertex getPrev() {
        return prev;
    }

    public void setPrev(ThomVertex prev) {
        this.prev = prev;
    }

    public int getScratch() {
        return scratch;
    }

    public void setScratch(int scratch) {
        this.scratch = scratch;
    }
}

