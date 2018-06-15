package ooTaxi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Taxi for the Simulation.
 * It takes passengers from the station and keeps basic historical data.
 * 
 * @author pieterkoopman
 */
public class Taxi implements Runnable{

    private final int taxiId;
    private final int maxNrOfPassengers;
    private final int transportationTime;
    private final Station station;
    
    private int totalNrOfPassengers = 0;
    private int nrOfRides = 0;
    
    private Lock lock = new ReentrantLock();
  
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
            int passengersWaiting = station.getWaitingPassengers();
            if ( passengersWaiting > 0 ) {
                int nrOfPassengers = Math.min(passengersWaiting, maxNrOfPassengers);
                station.leaveStation(nrOfPassengers);
                totalNrOfPassengers += nrOfPassengers;
                nrOfRides++;
                System.out.println("Taxi " + taxiId + " takes " + nrOfPassengers + " passengers");
            } else {  
                System.out.println("There are no passengers for taxi " + taxiId);
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
        takePassengers();
        
        try {
            Thread.sleep(Util.getRandomNumber(10, 100));
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}