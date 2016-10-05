package tests;

import lessen.les3;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by thom on 16-9-2016.
 */
public class les3test {
    int [] actual = {};
    @Before
    public void before() {
        actual = new int[20];
        for(int i = 0; i < 20; i++) {
            actual[i] = (int) (Math.random() * 100);
        }
    }

    @Test
    public void testInsertionSort2() {
        int[] expected = actual.clone();
        Arrays.sort(expected);
        assertEquals(Arrays.toString(expected), Arrays.toString(les3.insertionSort2(actual)));
    }

    @Test
    public void testQuickSort()
    {
        int[] expected = actual.clone();
        Arrays.sort(expected);
//        assertEquals(Arrays.toString(expected), Arrays.toString(les3.quickSort(actual,0,actual.length)));
    }

    @Test
    public void testSort() {
        int[] expected = actual.clone();
        Arrays.sort(expected);
        assertEquals(Arrays.toString(expected),Arrays.toString(les3.sort(actual,false)));
    }
}
