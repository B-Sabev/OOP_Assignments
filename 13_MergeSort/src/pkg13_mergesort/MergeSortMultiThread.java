/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg13_mergesort;

import java.util.Arrays;
import static pkg13_mergesort.MergeSort.merge;
import static pkg13_mergesort.MergeSort.sort;

/**
 *
 * @author Borislav
 */
public class MergeSortMultiThread implements Runnable{
    
    private final int[] array;
    public static final int THRESHOLD = 10000;

    public MergeSortMultiThread(int[] array) {
        this.array = array;
    }
    
    public static void sort(int [] array) {
        MergeSortMultiThread msmt = new MergeSortMultiThread(array);
        msmt.run();
    }

    @Override
    public void run() {
        if (array.length > THRESHOLD) { // start 2 new threads if array is large
            
            int [] firstHalf = Arrays.copyOf(array, array.length / 2);
            int [] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);
            
            MergeSortMultiThread s1 = new MergeSortMultiThread(firstHalf);
            MergeSortMultiThread s2 = new MergeSortMultiThread(secondHalf);
            
            Thread t1 = new Thread(s1);
            Thread t2 = new Thread(s2);
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch ( InterruptedException e) {
                e.printStackTrace();
            }
            merge(s1.getArray(), s2.getArray(), array);
            
        } else if (array.length > 1) { // if array is small use the sequential version
            MergeSort.sort(array);
        }
    }
    
    public int[] getArray() {
        return array;
    }
}
