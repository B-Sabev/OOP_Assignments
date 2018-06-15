package pkg14_primenumbergenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Borislav Sabev s4726863
 * 
 */
public class Generator {
    
    public static final int BUFFER_SIZE = 10;
    
    private List<Buffer<Integer>> buffers = new ArrayList<>();
    private List<Sieve> sieves = new ArrayList<>();
    private final FillBuffer fill;
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public Generator() {
        // make the first buffer and fill it with candidate numbers 
        buffers.add(new Buffer<>(BUFFER_SIZE)); 
        fill = new FillBuffer(buffers.get(0));
        executor.execute(fill);
    }
    
    /**
     * Finds the next prime, creates a sieve for it and output buffer for the sieve
     * @return the prime number
     */
    public Integer genPrime(){
        Integer prime = buffers.get(buffers.size()-1).get(); // get the prime from the last buffer
        buffers.add(new Buffer<>(BUFFER_SIZE));  // create a new buffer and sieve for this prime
        sieves.add(new Sieve(prime, 
                             buffers.get(buffers.size()-2), 
                             buffers.get(buffers.size()-1))); 
        executor.execute(sieves.get(sieves.size()-1)); // start the new sieve
        return prime;
    }
    
    public void showPrimes(){
        showPrimes(100); // show the first 100 numbers as asked in the assignment
    }
    
    public void showPrimes(int numOfPrimes){
        for(int i=0; i<numOfPrimes; i++){
            System.out.println(String.format("%d: %d", (i+1), genPrime()));
        }
    }
  
    
}
