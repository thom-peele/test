package nl.han.ica.icss.ast;

/**
 * Created by thom
 * On 31-10-2016
 */
public class Number extends Value {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "number: " + number;
    }
}
