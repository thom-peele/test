package lessen.les7;

/**
 * Created by thom
 * On 2-10-2016
 */
public class ThomEdge {
    private ThomVertex dest;        // Second vertex in Edge
    private double cost;            // Edge cost

    /**
     * ThomEdge - edge with costs
     * @param destination
     * @param cost
     */
    public ThomEdge( ThomVertex destination, double cost ) {
        dest = destination;
        this.cost = cost;
    }

    public ThomVertex getDest() {
        return dest;
    }

    public void setDest(ThomVertex dest) {
        this.dest = dest;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
