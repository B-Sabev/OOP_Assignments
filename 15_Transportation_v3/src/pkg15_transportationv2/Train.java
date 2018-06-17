package pkg15_transportationv2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static pkg15_transportationv2.Simulation.MAX_TRAVELLERS;
import static pkg15_transportationv2.Simulation.MIN_TRAVELLERS;
import static pkg15_transportationv2.Simulation.TRAIN_TRIPS;

/**
 * The train brings a number of passengers to a station in the simulation.
 * 
 * @adapted from pieterkoopman
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
//public class Train {
public class Train implements Runnable {
    private int nrOfPassengers;
    private final Station station;
    private int nrOfTrips = 0;
    
    private final Lock lock = new ReentrantLock();

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
        while(nrOfTrips < TRAIN_TRIPS){
            loadPassengers(Util.getRandomNumber(MIN_TRAVELLERS, MAX_TRAVELLERS));
            unloadPassengers();
            Util.threadWaitRandomTime(50, 100);
        }
        station.close();
    }
}