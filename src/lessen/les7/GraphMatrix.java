package lessen.les7;

/**
 * Created by thom on 5-10-2016.
 */
public class GraphMatrix {

    int[][] matrix;
    public GraphMatrix(int i) {
        matrix = new int[i][i];
    }

    public GraphMatrix toGraphMatrix() {
        GraphMatrix matrix = new GraphMatrix(5);
//        int i = 0;
//        for(String vName : vertices.keySet()) {
//            matrix.vertices[i] = vName;
//            indexMap.put(vName,i);
//            i++;
//        }
//
//        for(int j=0; j < i; j++) {
//            Vertex v = vertices.get(matrix.vertices[j]);
//            for(Edge e : v.adj) {
//                Vertex d = e.dest;
//                matrix[j][indexMap.get(d.name)] = e.cost;
//            }
//        }
        return matrix;
    }
}
