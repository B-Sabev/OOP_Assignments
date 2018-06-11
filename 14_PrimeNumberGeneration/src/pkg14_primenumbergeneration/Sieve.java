package pkg14_primenumbergeneration;

import java.util.Iterator;
/**
 *
 * @author Austin s1016930
 */
public class Sieve implements Iterator<Integer> {
    private final int prime;
    private final Iterator<Integer> source;
    private final BoundedBuffer predecessor, successor;
    
    public Sieve(int prime, Iterator<Integer> source) {
        this.prime = prime;
        this.source = source;
        predecessor = new BoundedBuffer();
        successor = new BoundedBuffer();
    }

    
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int next = source.next();
        while(next % prime == 0) {
            next = source.next();
        }
        return next;
    }
    
}
