package pkg13_mergesort;

import java.util.Random;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class MergeSortTest {

    /**
     *  
    *   threshold = 1000
    *   if (size < threshold) {
        sequential_solution;
    } else {
        divide_in_nonoverlapping_subproblems;
        solve_subproblems_in_parallel;
        combine_results;
    }
    * 
    * We can only start merging the sub-arrays when their sorting threads
are finished. Hence, your program needs an explicit
join
.
* 
* 
* In order to measure the effect of parallelization you apply the sequential and parallel version of
merge sort to a long array of pseudo random integers, say 10,000,000 elements.  You can obtain the
current time in milliseconds by
System.currentTimeMillis()

* 
* Include the timing results and the number of cores of your computer as
a comment in your program.
     */
    public static void main(String[] args) {
        // number of processors, with 4 cores - x2 speed up
        
        /* Huge time varition between 2 consequtive runs,
            Maybe run it multiple times and average the result
        */
            
        testMergeSort(10000, 0, 10);
        
    }
    
    public static void testMergeSort(int N, int threshold, int numRuns){
        int[] array = randomArray(N);
        int[] arrayCopy = new int[N];
        System.out.println("\nNumber of cores/processors: " + Runtime.getRuntime().availableProcessors() +
                           "\nSize of the array sorted: " + array.length +
                           "\nThreshold for creating a thread: " + threshold + 
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
            
            arrayCopy = array.clone();
            // make parallel sort
            startTime = System.currentTimeMillis();
            MergeSort.sort(arrayCopy);
            parallelTime += System.currentTimeMillis() - startTime;
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
    
    /*
    int N = 10; // 10 000 000
        int[] array = randomArray(N);
        int[] array_copy = array.clone();
        for(int e : array)
            System.out.print(e + " ");
        
        MergeSort.sort(array);
        
        
        System.out.println("");
        for(int e : array)
            System.out.print(e + " ");
        System.out.println("");
        for(int e : array_copy)
            System.out.print(e + " ");
    */
    
}
