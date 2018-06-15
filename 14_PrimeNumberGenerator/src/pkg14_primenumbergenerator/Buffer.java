package pkg14_primenumbergenerator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Borislav Sabev s4726863
 */
public class Buffer<E> {
    
    private int size;
    private Queue<E> elements = new LinkedList<>();
    private final Lock lock = new ReentrantLock();;
    private final Condition bufferFull = lock.newCondition(), 
                            bufferEmpty = lock.newCondition();
    
    public Buffer(int size){
        this.size = size;
    }
    
    /**
     * Put an element into the buffer, 
     * if the buffer is full, wait until an element is taken with get()
     * @param element - element to put
     */
    public void put(E element){
        lock.lock();
        // the producer waits if the buffer is full
        if(elements.size() == size){
            try {
                bufferFull.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // add an element and notify the consumer
        try { 
            elements.add(element);
            bufferEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }
    
    /**
     * Get element from the buffer,
     * if the buffer is empty, wait until element is put
     * @return the first element in the elements queue
     */
    public E get(){
        lock.lock();
        // consumer waits if the buffer is empty
        if(elements.isEmpty()){
            try {
                bufferEmpty.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // get an element and notify that the buffer is no longer full
        try {  
            E element = elements.poll();
            bufferFull.signalAll();
            return element;
        } finally {
            lock.unlock();
        }
       
    }    
    

}