package com.cnc.algorithms;

import java.util.Iterator;

/**
 * Write an Iterator that only returns even Numbers
 *
 * Look for:
 * -use of generics
 * -extending an iterator
 * -knows how to implement an interface?
 * -use of mod operator?
 *
 * @author Evan Harris
 */
public class EvenIterator <T extends Number> implements Iterator<T> {

    private Iterator<T> baseIterator;
    private T nextEven;


    public EvenIterator(Iterable<T> iterable){
        this.baseIterator = iterable.iterator();
    }

    @Override
    public boolean hasNext() {
        while(baseIterator.hasNext() && nextEven == null){
            T candidate = baseIterator.next();
            if(candidate.intValue() % 2 == 0){
                nextEven = candidate;
            }
        }
        return nextEven != null;
    }

    @Override
    public T next() {
        T result = null;
        if(this.hasNext()) {
            result = nextEven;
            nextEven = null;
        }
        return result;
    }

    @Override
    public void remove() {

    }
}
