package pkg14_primenumbergenerator;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Borislav
 */
public class GeneratorSeq {
    
    
    public void genPrimes(){
        ArrayList<Integer> candidates = new ArrayList<>();
        for(int i=2; i<1000; i++){
            candidates.add(i);
        }
        Buffer<Integer> pred = new Buffer<>(20);
        Buffer<Integer> succ = new Buffer<>(20);
        
        for(int i=0; i<20; i++){
            pred.put(candidates.get(i));
        }
        
        ExecutorService executor = Executors.newCachedThreadPool();
        
        Sieve s = new Sieve(2, pred, succ);
        
        executor.execute(s);
        
        
        for(int i=0; i<20; i++){
            System.out.println(succ.get());
        }
        
        
    }
}
