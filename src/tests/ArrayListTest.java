package tests;

import lessen.les5.ArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by thom on 16-9-2016.
 */
public class ArrayListTest {
    ArrayList arrayList = null;
    @Before
    public void before() {
        arrayList = new ArrayList<Integer>();
    }

    @Test
    public void addTest() {
        arrayList.add(42);
        int expected = 42;
        assertEquals(expected, arrayList.get(0));
    }

    @Test
    public void setTest() {
        arrayList.add(1);
        arrayList.set(0,42);
        int expected = 42;
        assertEquals(expected, arrayList.get(0));
    }

}
