package nl.han.ica.icss.ast;

/**
 * Created by thom on 31-10-2016.
 */
public class Color extends Value {

    private String color;

    public Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "color: " + color;
    }
}
