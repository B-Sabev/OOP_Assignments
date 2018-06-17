package pkg15_transportationv2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Taxi for the Simulation.
 * It takes passengers from the station and keeps basic historical data.
 * 
 * @adapted from pieterkoopman
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
//public class Taxi {
public class Taxi implements Runnable {

    private final int taxiId;
    private final int maxNrOfPassengers;
    private final int transportationTime;
    private final Station station;
    
    private int totalNrOfPassengers = 0;
    private int nrOfRides = 0;
    
    private final Lock lock = new ReentrantLock();
  
    public Taxi(int nr, int maxNumberOfPassengers, int transportationTime, Station station) {
        this.taxiId = nr;
        this.maxNrOfPassengers = maxNumberOfPassengers;
        this.transportationTime = transportationTime;
        this.station = station;
        System.out.println("Taxi " + nr + " created");
    }
    
    /**
     * Try to take the maximum number of passengers from the station. 
     * If actual number op passengers is less then that number is taken
     * When there are no passengers the taxi just waits a little
     */
    public void takePassengers() {
        lock.lock();
        try {
            if ( station.getWaitingPassengers() > 0 ) {
                // take min of the waiting and the capacity of the taxi, stations return how many are left after the call to getWaitingPassengers()
                int nrOfPassengers = station.leaveStation( Math.min( station.getWaitingPassengers() , maxNrOfPassengers));
                totalNrOfPassengers += nrOfPassengers;
                nrOfRides++;
                System.out.println("Taxi " + taxiId + " takes " + nrOfPassengers + " passengers");
            } 
        } finally {
            lock.unlock();
        }
    }
    /**
     * Calculates the total time of this taxi by multiplying the number of rides by the transportation time
     * @return total time
     */
    public int getTotalTransportationTime() {
        lock.lock();
        try{
            return transportationTime * nrOfRides;
        } finally {
            lock.unlock();
        }
        
    }
    
    public int getTotalNrOfPassengers() {   
        lock.lock();
        try{
            return totalNrOfPassengers;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {   
        while(!station.isClosed()){
            takePassengers();
            Util.threadWaitRandomTime(transportationTime * 2, transportationTime * 3);
        }  
    }
}    