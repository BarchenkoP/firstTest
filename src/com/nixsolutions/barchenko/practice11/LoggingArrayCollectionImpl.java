package com.nixsolutions.barchenko.practice11;

import com.nixsolutions.barchenko.practice5.ArrayCollectionImpl;
import interfaces.logging.LoggingArrayCollection;
import java.util.Collection;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingArrayCollectionImpl<E>
        extends ArrayCollectionImpl<E> implements LoggingArrayCollection<E> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(LoggingArrayCollectionImpl.class);

    @Override
    public Logger getLogger() {
        return LOGGER;
    }

    public LoggingArrayCollectionImpl() {
        LOGGER.trace("LoggingArrayCollectionImpl created");
    }

    @Override
    public Object[] getArray() {
        LOGGER.trace("getArray started");
        return super.getArray();
    }

    @Override
    public void setArray(E[] e) {
        LOGGER.trace("setArray started");
        try {
            super.setArray(e);
        } catch (NullPointerException e1) {
            LOGGER.error("error " + e1);
            throw new NullPointerException();
        }
    }

    @Override
    public int size() {
        LOGGER.trace("size started");
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        LOGGER.trace("isEmpty started");
        return super.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        LOGGER.trace("contains started");
        return super.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        LOGGER.trace("iterator started");
        return super.iterator();
    }

    @Override
    public boolean add(E e) {
        LOGGER.trace("add started");
        return super.add(e);
    }

    @Override
    public boolean remove(Object o) {
        LOGGER.trace("remove started");
        return super.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        LOGGER.trace("addAll started");
        try {
            return super.addAll(c);
        } catch (IllegalArgumentException e) {
            LOGGER.error("error " + e);
        }
        return false;
    }

    @Override
    public void clear() {
        LOGGER.trace("clear started");
        super.clear();
    }

    @Override
    public boolean retainAll(Collection c) {
        LOGGER.trace("retainAll started");
        try {
            return super.retainAll(c);
        } catch (NullPointerException e) {
            LOGGER.error("error " + e);
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        LOGGER.trace("removeAll started");
        return super.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        LOGGER.trace("containsAll started");
        return super.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] e) {
        LOGGER.trace("toArray started");
        return super.toArray(e);
    }

    @Override
    public Object[] toArray() {
        LOGGER.trace("toArray started");
        return super.toArray();
    }
}
