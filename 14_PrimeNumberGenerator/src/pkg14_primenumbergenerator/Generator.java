/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg14_primenumbergenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Borislav
 */
public class Generator {
    
    private FillBuffer fill;
    private Iterator<Integer> iter = new Iter();
    private List<Buffer<Integer>> buffers = new ArrayList<>();
    private List<Sieve> sieves = new ArrayList<>();
    private ExecutorService executor = Executors.newCachedThreadPool();

    public Generator() {
        buffers.add(new Buffer<>(20)); 
        fill = new FillBuffer(iter, buffers.get(0));
        executor.execute(fill);
    }

    public List<Buffer<Integer>> getBuffers() {
        return buffers;
    }
    
    
    public Integer genPrime(){
        
        System.out.println(buffers.get(buffers.size()-1).isEmpty());
        Integer prime = buffers.get(buffers.size()-1).get();
        
        buffers.add(new Buffer<>(20));
        sieves.add(new Sieve(prime, 
                             buffers.get(buffers.size()-2), 
                             buffers.get(buffers.size()-1)));
        
        //executor.execute(sieves.get(sieves.size()-1));
        return prime;
    }
    
}
