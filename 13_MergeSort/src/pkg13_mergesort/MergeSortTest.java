package pkg13_mergesort;

import java.util.Random;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class MergeSortTest {

    public static void main(String[] args) {
        // test sequential and multi-thread sort on 
        // random array with size 10^7, runtime averaged over 10 runs
        testMergeSort((int) 1e7, 10);
        
        /*
        Number of cores/processors: 4
        Size of the array sorted: 10 000 000
        Measured time is averaged over 10 runs
        Over the 2 sorting algorithms and the 10 runs, the same random array (its copy) is sorted
        
        Threshold for creating a thread: 10 000
        Sequential merge sort time: 3243.2 ms
        Multi-thread merge sort time: 2375.1 ms
        
        Threshold for creating a thread: 50 000
        Sequential merge sort time: 3213.1 ms
        Multi-thread merge sort time: 1598.6 ms

        Threshold for creating a thread: 100 000
        Sequential merge sort time: 3298.6 ms
        Multi-thread merge sort time: 1460.9 ms

        Threshold for creating a thread: 500 000
        Sequential merge sort time: 2837.1 ms
        Multi-thread merge sort time: 1262.4 ms

        Conclusion:
            threshold in range 50k - 500k, up to x2.26 speed up with multi-threading on 4 cores
            threshold = 10k, speed up is less than x2 
        
            wierdly, during the first 3 measurements and the last 2 of the time
            for sequential merge sort differ, which shouldn't happen, probably explained
            by other processes that run on the PC during testing
        */
    }
    
    /**
     * Test and compare the 2 mergeSort classes
     * print execution time for each sort in the console
     * @param N - size of a pseudo-random array to sort
     * @param numRuns - how many times sort the same array to get more stable 
     *                  measurement results
     */
    public static void testMergeSort(int N, int numRuns){
        int[] array = randomArray(N);
        int[] arrayCopy = new int[N];
        System.out.println("\nNumber of cores/processors: " + Runtime.getRuntime().availableProcessors() +
                           "\nSize of the array sorted: " + array.length +
                           "\nThreshold for creating a thread: " + MergeSortMultiThread.THRESHOLD);
        
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
                            ((double)seqTime / (double) numRuns) + " ms, average over " +
                            numRuns + " runs");
        
      
        System.out.println("Multi-thread merge sort time: " +
                            ((double) parallelTime / (double) numRuns) + " ms, average over " + 
                            numRuns + " runs");
       
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
