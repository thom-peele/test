package lessen.les7;

import java.util.ArrayList;
import java.util.Objects;

//import lessen.les5.ArrayList;

/**
 * Created by thom
 * On 30-9-2016
 */
public class ThomGraph<T> {

    private ArrayList<ThomVertex> vertexArrayList;
    private ThomVertex unweighted;

    /**
     * ThomGraph class
     *
     * @param firstVertexName this is the first vertex that will be added.
     */
    public ThomGraph(T firstVertexName) {
        vertexArrayList = new ArrayList<ThomVertex>();
        addVertex(firstVertexName);
    }

    public ThomVertex addVertex(T vertexName) {
        ThomVertex thomVertex = new ThomVertex(vertexName);
        vertexArrayList.add(thomVertex);
        return thomVertex;
    }

    public ThomVertex getVertex(T vertexName) {
        for (int i = 0; i < vertexArrayList.size(); i++) {
            if (Objects.equals(vertexArrayList.get(i).getVertex(), vertexName)) {
                return vertexArrayList.get(i);
            }
        }
        return null;
    }

    /**
     * addEdge - add new edge to sourceVertex. When vertices not found they will be created.
     */
    public void addEdge(T source, T dest, double cost) {
        ThomVertex sourceVertex = getVertex(source);
        ThomVertex destVertex = getVertex(dest);
        if (sourceVertex == null) {
            sourceVertex = addVertex(source);
        }
        if (destVertex == null) {
            destVertex = addVertex(dest);
        }
        sourceVertex.addAdj(destVertex, cost);
    }

    /**
     * setUnweighted - this will be the start vertex
     */
    public void setUnweighted(T unweighted) {
        this.unweighted = getVertex(unweighted);
    }

    /**
     * getPath - returns a string with the path to the dest vertex incl. cost
     */
    public String getPath(T destVertex) {
//        for(int i = 0; i < unweighted.getAdj().size(); i++) {
//            if(unweighted.getAdj().get(i).getDest().getName().equals(destVertex)) {
//                return unweighted.getName() + " to " + unweighted.getAdj().get(i).getDest().getName() + " costs: " + unweighted.getAdj().get(i).getCost();
//            }
//        }
        ThomEdge test = (ThomEdge) unweighted.getAdj().get(1);
        return "path not found.";
    }

    @Override
    public String toString() {
        String tmp = "";
        for (ThomVertex thomVertex : vertexArrayList) {
            for (int i = 0; i < thomVertex.getAdj().size(); i++) {
                ThomEdge thomEdge = (ThomEdge) thomVertex.getAdj().get(i + 1);
                System.out.println(thomVertex.getVertex().toString() + " - " + thomEdge.getDest().getVertex().toString() + " lengte: " + thomEdge.getCost());
            }
        }
        return null;
    }

}
