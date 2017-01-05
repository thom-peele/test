package nl.han.ica.icss.ast;

/**
 * Created by thom
 * On 31-10-2016
 * todo: change to literal
 */
public class Size extends Value {
    private int number;
    private String uom;

    public Size(int number, String uom) {
        this.number = number;
        this.uom = uom;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    @Override
    public String toString() {
        return "size: " + number + " " + uom;
    }
}
