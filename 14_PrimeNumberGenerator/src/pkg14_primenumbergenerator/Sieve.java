/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg14_primenumbergenerator;

/**
 *
 * @author Borislav
 */
public class Sieve implements Runnable{
    private final int prime;
    private Buffer<Integer> in, out;

    public Sieve(int prime, Buffer predecessor, Buffer successor) {
        this.prime = prime;
        this.in = predecessor;
        this.out = successor;
    }
    
    public void filter(){
        int num = in.get();
        if(num % prime != 0)
            out.put(num);
    }

    @Override
    public void run() {
        filter();
    }
    
}
