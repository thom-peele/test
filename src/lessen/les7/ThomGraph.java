package lessen.les7;

import lessen.les5.ArrayList;

import java.util.Objects;

/**
 * Created by thom
 * On 30-9-2016
 */
public class ThomGraph {

    private ArrayList<ThomVertex> vertexArrayList;
    private ThomVertex unweighted;
    /**
     * ThomGraph class
     * @param firstVertexName this is the first vertex that will be added.
     */
    public ThomGraph(String firstVertexName) {
        vertexArrayList = new ArrayList<ThomVertex>();
        addVertex(firstVertexName);
    }

    public ThomVertex addVertex(String vertexName) {
        ThomVertex thomVertex = new ThomVertex(vertexName);
        vertexArrayList.add(thomVertex);
        return thomVertex;
    }

    public ThomVertex getVertex(String vertexName) {
        for(int i = 0; i < vertexArrayList.size(); i++) {
            if (Objects.equals(vertexArrayList.get(i).toString(), vertexName)) {
                return vertexArrayList.get(i);
            }
        }
        return null;
    }

    /**
     * addEdge - add new edge to sourceVertex. When vertices not found they will be created.
     * @param sourceName
     * @param destName
     * @param cost
     */
    public void addEdge(String sourceName, String destName, double cost ) {
        ThomVertex sourceVertex = getVertex(sourceName);
        ThomVertex destVertex = getVertex(destName);
        if(sourceVertex == null) {
            sourceVertex = addVertex(sourceName);
        }
        if(destVertex == null) {
            destVertex = addVertex(destName);
        }
        sourceVertex.addAdj(destVertex, cost);
    }

    /**
     * setUnweighted - this will be the start vertex
     * @param unweighted
     */
    public void setUnweighted(String unweighted) {
        this.unweighted = getVertex(unweighted);
    }

    /**
     * getPath - returns a string with the path to the dest vertex incl. cost
     * @param destVertex
     * @return
     */
    public String getPath(String destVertex) {
        System.out.println(unweighted.getAdj().size());
        for(int i = 0; i < unweighted.getAdj().size(); i++) {
            if(unweighted.getAdj().get(i).getDest().getName().equals(destVertex)) {
                return unweighted.getName() + " to " + unweighted.getAdj().get(i).getDest().getName() + " costs: " + unweighted.getAdj().get(i).getCost();
            }
        }
        return "path not found.";
    }






}
