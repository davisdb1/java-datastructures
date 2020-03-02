package com.cnc.algorithms;

/**
 * Write an Iterator that only returns even Numbers from a given source
 * <p>
 * Look for:
 * -use of generics
 * -extending an iterator
 * -knows how to implement an interface?
 * -use of mod operator?
 *
 * @author Evan Harris
 */
public class EvenIterator<T extends Number> implements Iterator<T> {

    public EvenIterator(Iterable<T> iterable) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public T next() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public void remove() {
		throw new UnsupportedOperationException("Not yet implemented.");
    }
	
}
