package pkg14_primenumbergenerator;

import java.util.Iterator;

/**
 *
 * @author Borislav
 */
public class Iter implements Iterator<Integer>{
    private int num=1;

    @Override
    public boolean hasNext() { return true; }

    @Override
    public Integer next() {
        return ++num;
    }
    
}
