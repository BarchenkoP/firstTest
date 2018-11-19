package com.nixsolutions.barchenko.practice10;

import interfaces.task5.ArrayIterator;

import java.util.NoSuchElementException;

public class ArrayIteratorImpl<E> implements ArrayIterator<E> {

    private int counter;
    private int cursor;
    private boolean flag;
    private E[] objArray = (E[]) new Object[0];
    private int size;

    @Override
    public Object[] getArray() {
        return objArray;
    }

    @Override
    public boolean hasNext() {
        if (size == cursor) {
            return false;
        }
        return true;
    }

    @Override
    public E next() {
        if (cursor >= size) {
            throw new NoSuchElementException();
        } else {
            counter = cursor++;
            flag = true;
            return objArray[counter];
        }
    }

    @Override
    public void remove() {
        if (!flag) {
            throw new IllegalStateException();
        }
        removeByElement(counter);
        cursor--;
        flag = false;
    }

    private void removeByElement(int i) {
        System.arraycopy(objArray,i + 1, objArray, i, objArray.length - 1 - i);
        size--;
    }
}