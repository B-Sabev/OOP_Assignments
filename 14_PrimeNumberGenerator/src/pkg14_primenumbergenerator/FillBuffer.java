/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg14_primenumbergenerator;

import java.util.Iterator;

/**
 *
 * @author Borislav
 */
public class FillBuffer implements Runnable {
    
    private Iterator<Integer> it;
    private Buffer<Integer> buff;

    public FillBuffer(Iterator<Integer> it, Buffer<Integer> buff) {
        this.it = it;
        this.buff = buff;
    }
    
    @Override
    public void run() {
        for(int i=0; i<20; i++)
            buff.put(it.next());
    }
    
}
