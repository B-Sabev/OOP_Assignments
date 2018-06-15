package pkg15_transportationv2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class that holds the number of persons arriving by train at the station and
 * is waiting for a taxi.
 * 
 * @adapted from pieterkoopman
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Station {

    private int nrOfPassengersAtStation = 0;
    private int totalNrOfPassengers = 0;
    private boolean isClosed = false;
    
    private final Lock lock = new ReentrantLock();
    
    public void enterStation(int nrOfPassengers) {
        lock.lock();
        try {
            nrOfPassengersAtStation += nrOfPassengers;
            totalNrOfPassengers += nrOfPassengers;
            System.out.println(nrOfPassengers + " passengers arrived at station");
        } finally {
            lock.unlock();
        }
    }
    /**
     * Ask for nrOfPassengers Passengers to leave the station
     *
     * @param nrOfPassengers
     */
    public void leaveStation(int nrOfPassengers) {
        lock.lock();
        try {
            if ( nrOfPassengers <= nrOfPassengersAtStation )
                nrOfPassengersAtStation -= nrOfPassengers;
            else
                System.out.println( "leaveStation(" + nrOfPassengers + ") there are only "
                        + nrOfPassengersAtStation + " passengers at the station." );
        } finally {
            lock.unlock();
        }
    }

    public int getWaitingPassengers() {
        lock.lock();
        try{
            return nrOfPassengersAtStation;
        } finally{
            lock.unlock();
        }
    }
    
    public void close() {
        lock.lock();
        try {
            isClosed = true;
        } finally {
            lock.unlock();
        }
    }
    
    public boolean isClosed() {
        lock.lock();
        try{
            return isClosed; 
        } finally{
            lock.unlock();
        }
    }

    public int getTotalNrOfPassengers() {
        lock.lock();
        try{
            return totalNrOfPassengers;
        } finally{
            lock.unlock();
        }
    }
}
