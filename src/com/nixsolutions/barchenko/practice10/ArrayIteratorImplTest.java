package com.nixsolutions.barchenko.practice10;

import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import junit.framework.TestCase;


public class ArrayIteratorImplTest extends TestCase {

    private ArrayCollection<Integer> arrayCollection = null;
    private Integer[] array = {1, 2, 3};

    public void setUp() throws Exception {
        arrayCollection = new ArrayCollectionImpl<>();
    }

    public void tearDown() throws Exception {
        arrayCollection.setArray(new Integer[0]);
    }

    public void testHasNext() {
        assertFalse("check iterator", arrayCollection.iterator().hasNext());
        arrayCollection.setArray(array);
        assertTrue("check iterator", arrayCollection.iterator().hasNext());
    }

    public void testNext() {
        arrayCollection.setArray(array);
        ArrayIterator iterator = (ArrayIterator) arrayCollection.iterator();
        assertEquals("check iterator", array[0], iterator.next());
    }

    public void testNextWhenCollectionEmpty() {
        assertEquals(0, arrayCollection.size());
        Iterator iterator = arrayCollection.iterator();
        try {
            iterator.next();
            fail("should threw NoSuchElementException");
        } catch (NoSuchElementException e) {
            //
        }
    }

    public void testRemoveBeforeNext() {
        try {
            arrayCollection.iterator().remove();
            fail("should be throw IllegalStateException");
        } catch (IllegalStateException e) {
            //
        }
    }
}