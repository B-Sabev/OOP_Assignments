package ooTaxi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ooTaxi.Simulation.MAX_TRAVELLERS;
import static ooTaxi.Simulation.MIN_TRAVELLERS;
import static ooTaxi.Simulation.TRAIN_TRIPS;
import ooTaxi.Station;

/**
 * The train brings a number of passengers to a station in the simulation.
 *
 * @author pieterkoopman
 */
public class Train implements Runnable{

    private int nrOfPassengers;
    private final Station station;
    private int nrOfTrips = 0;
    
    private Lock lock = new ReentrantLock();

    public Train(Station station) {
        this.station = station;
        this.nrOfPassengers = 0;
    }

    /**
     * Populate this train with number nrOfPassengers
     *
     * @param number the number of passengers of this train
     */
    public void loadPassengers(int number) {
        lock.lock();
        try {
            nrOfPassengers = number;
        } finally {
            lock.unlock();
        }
    }

    /**
     * empties this train and augment the number of Passengers at the station
     * with this nrOfPassenegers
     */
    public void unloadPassengers() {
        lock.lock();
        try {
            nrOfTrips += 1;
            station.enterStation(nrOfPassengers);
        } finally {
            lock.unlock();
        }
    }

    public void closeStation() {
        lock.lock();
        try {
            station.close();
        } finally {
            lock.unlock();
        }
    }

    public int getNrOfTrips() {
        lock.lock();
        try{
           return nrOfTrips; 
        } finally {
            lock.unlock();
        }
        
    }

    @Override
    public void run() {
        
        unloadPassengers();
        /*
        try {
            Thread.sleep(Util.getRandomNumber(10, 50));
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
      
    }
}
