package com.nixsolutions.barchenko.practice10;

import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayCollectionImpl<E> implements ArrayCollection<E> {
    private int size;
    private E[] objArray = (E[]) new Object[0];

    @Override
    public Object[] getArray() {
        return objArray;
    }

    @Override
    public void setArray(E[] e) {
        objArray = e;
        size = objArray.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (objArray[i] == o) {
                flag = true;
                return flag;
            }
        }
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (objArray[i] == null) {
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIteratorImpl();
    }

    @Override
    public boolean add(E e) {
        if (size == objArray.length) {
            arrayUpSize(1);
            objArray[size] = e;
            size++;
        } else {
            objArray[size] = e;
            size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean flag = false;
        for (int i = 0; i < objArray.length; i++) {
            if (objArray[i].equals(o)) {
                removeByElement(i);
                arrayDownSize(1);
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (this == c) {
            throw new IllegalArgumentException();
        }
        for (E o:c) {
            add(o);
        }
        return true;
    }

    @Override
    public void clear() {
        objArray = (E[]) new Object[0];
        size = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object o;
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            o = objArray[i];
            if (!c.contains(o)) {
                this.remove(o);
                flag = true;
            }
        }
        if (c == null) {
            throw new NullPointerException();
        }
        return flag;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean flag = false;
        for (Object o:c) {
            if (remove(o)) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o:c) {
            if (contains(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public <E> E[] toArray(E[] e) {
        return (E[]) objArray;
    }

    @Override
    public Object[] toArray() {
        return objArray;
    }

    private void arrayUpSize(int up) {
        E[] tempArray = (E[]) new Object[objArray.length + up];
        System.arraycopy(objArray,0,tempArray,0,objArray.length);
        objArray = tempArray;
    }

    private void arrayDownSize(int down) {
        E[] tempArray = (E[]) new Object[objArray.length - down];
        System.arraycopy(objArray,0,tempArray,0,tempArray.length);
        objArray = tempArray;
    }

    private void removeByElement(int i) {
        System.arraycopy(objArray,i + 1, objArray, i, objArray.length - 1 - i);
        size--;
    }

    private class ArrayIteratorImpl implements ArrayIterator<E> {
        private int counter;
        private int cursor;
        private boolean flag;

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
    }
}
