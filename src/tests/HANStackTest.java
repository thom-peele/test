package tests;

import lessen.les5.HANStack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by thom
 * On 22-9-2016
 */
public class HANStackTest extends Assert {
    HANStack<String> hanStack = null;

    @Before
    public void setUp() throws Exception {
        hanStack = new HANStack<String>();
    }

    @Test
    public void push() throws Exception {
        hanStack.push("test");
        assertEquals("test",hanStack.top());
    }

    @Test
    public void pop() throws Exception {
        hanStack.push("test");
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