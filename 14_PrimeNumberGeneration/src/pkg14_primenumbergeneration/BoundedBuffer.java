package pkg14_primenumbergeneration;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 *
 * @author Austin s1016930
 * @param <E>
 */
public class BoundedBuffer<E> {
    private final Queue<E> queue;
    private final Lock lock;
    private final Condition bufferFull,bufferEmpty;
    private static final int MAX = 2;
    
    public BoundedBuffer() {
      queue = new LinkedList<>();
      lock = new ReentrantLock();
      bufferFull = lock.newCondition();
      bufferEmpty = lock.newCondition();
    }

    void put(E element) {
        lock.lock();
        try{
            while(queue.size() > MAX) {
                bufferFull.await();
            }
            queue.add(element);
            bufferEmpty.signalAll();
        }catch (InterruptedException e) {}
        finally {
            lock.unlock();
        }
    }
    
    E get() {
        lock.lock();
        E element = null;
        try {
            while(queue.isEmpty()) {
                bufferEmpty.await();
            }
        element = queue.poll();
        bufferFull.signalAll();
        } catch (InterruptedException e) {}
        finally {
                lock.unlock();
        }
        return element;
    }
    
}
