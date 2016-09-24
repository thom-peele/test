package tests;

import lessen.les5.HANStackArray;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by thom
 * On 24-9-2016
 */
public class HANStackTestTest {
    HANStackArray<String> hanStack = null;

    @Before
    public void setUp() throws Exception {
        hanStack = new HANStackArray<>();
        System.out.println(hanStack.getSize());
    }

    @Test
    public void push() throws Exception {
        hanStack.push("test");
        assertEquals("test",hanStack.top());
    }

    @Test
    public void pop() throws Exception {
        hanStack.push("test");
        System.out.println(hanStack.getSize());

        assertEquals("test",hanStack.pop());
        assertEquals(0,hanStack.getSize());
    }

    @Test
    public void top() throws Exception {
        hanStack.push("test");
        assertEquals("test",hanStack.top());
    }

    @Test
    public void getSize() throws Exception {
        hanStack.push("test");
        assertEquals(1,hanStack.getSize());
    }

}