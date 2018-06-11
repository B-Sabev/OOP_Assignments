package pkg14_primenumbergenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Buffer<E> {
    
    private int size;
    private List<E> elements;
    private Lock lock;
    private Condition bufferFull;
    private Condition bufferEmpty;
    
    public Buffer(int size){
        this.size = size;
        elements = new ArrayList<>();
        lock = new ReentrantLock(); 
        bufferFull = lock.newCondition();
        bufferEmpty = lock.newCondition();
    }
    
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
            E element = elements.get(0);
            elements.remove(0);
            bufferFull.signalAll();
            return element;
        } finally {
            lock.unlock();
        }
       
    }    
}