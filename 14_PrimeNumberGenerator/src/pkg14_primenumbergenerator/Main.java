/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg14_primenumbergenerator;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Borislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Generator gen = new Generator();
        /*
        List<Buffer<Integer>> buffers = gen.getBuffers();
        for(int i=0; i<20; i++){
            System.out.println(buffers.get(0).get());
        }
        */
        
        for(int i=0; i<20; i++){
            System.out.println(gen.genPrime());
        }
        
        
        
        //(new GeneratorSeq()).genPrimes();
    }
    
}
