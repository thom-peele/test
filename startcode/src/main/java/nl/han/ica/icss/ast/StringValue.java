package nl.han.ica.icss.ast;

/**
 * Created by thom
 * On 31-10-2016
 * todo: change to literal
 */
public class StringValue extends Value {
    private String value;

    public StringValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "stringvalue: " + value;
    }
}
