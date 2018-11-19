package com.nixsolutions.barchenko.practice10;

import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;
import java.util.Arrays;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayCollectionImplTest {

    private ArrayCollection<Integer> arrayCollection = null;
    private Integer[] array = {1, 2, 3};

    @Before
    public void before() {
        arrayCollection = new ArrayCollectionImpl<>();
    }

    @After
    public void after() {
        arrayCollection.setArray(new Integer[0]);
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals("check collection before",0,
                arrayCollection.size());
        arrayCollection.setArray(array);
        Assert.assertFalse("check collection after", arrayCollection.isEmpty());
    }

    @Test
    public void contains() {
        Assert.assertEquals("check collection before", 0,
                arrayCollection.size());
        arrayCollection.setArray(array);
        Assert.assertTrue("check collection after",
                arrayCollection.contains(array[0]));
    }

    @Test
    public void iterator() {
        Assert.assertTrue("check iterator", arrayCollection.iterator()
                instanceof ArrayIterator);
    }

    @Test
    public void add() {
        Assert.assertEquals("check collection before",0,
                arrayCollection.size());
        Assert.assertTrue("add to collection", arrayCollection.add(array[0]));
        Assert.assertEquals("check collection after",1,
                arrayCollection.size());
    }

    @Test
    public void remove() {
        arrayCollection.setArray(array);
        Assert.assertTrue(arrayCollection.remove(array[0]));
        Assert.assertEquals("check collection after", array.length - 1,
                arrayCollection.size());
    }

    @Test
    public void addAll() {
        Assert.assertEquals("check collection before", 0,
                arrayCollection.size());
        arrayCollection.addAll(Arrays.asList(array));
        Assert.assertArrayEquals("check collection after",
                array, arrayCollection.getArray());
    }

    @Test
    public void clear() {
        arrayCollection.setArray(array);
        arrayCollection.clear();
        Assert.assertEquals("check collection after", 0,
                arrayCollection.size());
    }

    @Test
    public void retainAll() {
        arrayCollection.setArray(array);
        Integer[] array2 = {1, 2, 4};
        arrayCollection.retainAll(Arrays.asList(array2));
        Assert.assertEquals("check collection after", 2,
                arrayCollection.size());
    }

    @Test
    public void removeAll() {
        arrayCollection.setArray(array);
        Integer[] array2 = {1, 2, 4};
        arrayCollection.removeAll(Arrays.asList(array2));
        Assert.assertEquals("check collection after",1,
                arrayCollection.size());
    }

    @Test
    public void containsAll() {
        Assert.assertEquals(0, arrayCollection.size());
        arrayCollection.setArray(array);
        Assert.assertTrue(arrayCollection.containsAll(Arrays.asList(array)));
        Assert.assertArrayEquals("check collection after",
                array, arrayCollection.getArray());
    }

    @Test
    public void toArray() {
        Assert.assertEquals("check collection before", 0,
                arrayCollection.size());
        arrayCollection.setArray(array);
        Assert.assertArrayEquals("check collection after",
                array, arrayCollection.toArray());
    }
}