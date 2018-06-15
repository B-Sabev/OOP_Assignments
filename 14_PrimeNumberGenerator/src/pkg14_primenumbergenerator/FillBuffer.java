package pkg14_primenumbergenerator;

import java.util.Iterator;

/**
 *
 * @author Borislav Sabev s4726863
 */
public class FillBuffer implements Runnable {
    
    /**
     * Make a generator that generates Integer starting from 2 
     */
    public class Iter implements Iterator<Integer>{
        
        private int num=1;

        @Override
        public boolean hasNext() { return true; }

        @Override
        public Integer next() { return ++num;}
    }
    
    private Iterator<Integer> it = new Iter();
    private Buffer<Integer> buff;

    public FillBuffer(Buffer<Integer> buff) {
        this.buff = buff;
    }
    
    /**
     * Fill the given buffer with all numbers from the iterator
     */
    @Override
    public void run() {
        while(true)
            buff.put(it.next());   
    }
    
}
