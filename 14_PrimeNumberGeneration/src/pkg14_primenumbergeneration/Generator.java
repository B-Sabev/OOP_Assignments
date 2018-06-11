package pkg14_primenumbergeneration;

import java.util.Iterator;

/**
 *
 * @author Austin s1016930
 */
public class Generator implements Iterator<Integer> {
    private int next = 2;
    
    public Generator(int next) {
        this.next = next;
    }

    public static void genPrimes() {
        try {  
            Iterator<Integer> source = new Generator(2);
            for (int i = 1; i <= 100; i ++) {
                int prime = source.next();
                Primes PrimeThread = new Primes();
                PrimeThread.start();
                source = new Sieve(prime, source);
                System.out.println(i + ": " + prime);
            }
        } catch (Exception e) {}
    }
    
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return next++;
    }
    
}
