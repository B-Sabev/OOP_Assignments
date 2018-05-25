package pkg13_mergesort;

import java.util.Random;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class MergeSortTest {

    public static void main(String[] args) {
        /*
        TODO:
            implement the sortMultiThread()
        
            Include timing results and number of cores in comments
            Expectation: number of processors, with 4 cores - x2 speed up
            Huge time varition between 2 consequtive runs,
                Maybe run it multiple times and average the result
        */
        testMergeSort((int) 1e7, 10);
        
    }
    
    public static void testMergeSort(int N, int numRuns){
        int[] array = randomArray(N);
        int[] arrayCopy = new int[N];
        System.out.println("\nNumber of cores/processors: " + Runtime.getRuntime().availableProcessors() +
                           "\nSize of the array sorted: " + array.length +
                           "\nThreshold for creating a thread: " + MergeSortMultiThread.THRESHOLD + 
                           "\nTime averaged over " + numRuns + " runs");
        
        long seqTime = 0;
        long parallelTime = 0;
        long startTime;
        
        for(int i=0; i<numRuns; i++){
            arrayCopy = array.clone();
            // make sequential sort
            startTime = System.currentTimeMillis();
            MergeSort.sort(arrayCopy);
            seqTime += System.currentTimeMillis() - startTime;
            if(!MergeSort.isSorted(arrayCopy))
                System.out.println("Array is not sorted after seq sort");
            
            arrayCopy = array.clone();
            // make parallel sort
            startTime = System.currentTimeMillis();
            MergeSortMultiThread.sort(arrayCopy);
            parallelTime += System.currentTimeMillis() - startTime;
            if(!MergeSort.isSorted(arrayCopy))
                System.out.println("Array is not sorted after parallel sort");
        }
     
        System.out.println("Sequential merge sort time: " +
                            ((double)seqTime / (double) numRuns) + " ms");
        
      
        System.out.println("Parallel merge sort time: " +
                            ((double) parallelTime / (double) numRuns) + " ms");
       
    }
    
    /**
     * Generate a random array of integers
     * @param N - size of the array
     * @return the array of ints
     */
    public static int[] randomArray(int N){
        Random rand = new Random();
        final int MAX_NUM = 1000; 
        int[] array = new int[N];
        for(int i=0; i<N; i++){
            array[i] = rand.nextInt(MAX_NUM);
        }
        return array;
    }
    
}
